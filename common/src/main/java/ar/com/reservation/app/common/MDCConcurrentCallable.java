package ar.com.reservation.app.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.Map;
import java.util.concurrent.Callable;

public class MDCConcurrentCallable<K> implements Callable{

    private static final Logger LOGGER = LoggerFactory.getLogger(MDCConcurrentCallable.class);

    private final Callable<K> actual;
    private final Map parentMDC;

    public MDCConcurrentCallable(Callable<K> actual) {
        LOGGER.debug("Init MDCHystrixContextCallable...");
        this.actual = actual;
        this.parentMDC = MDC.getCopyOfContextMap();
        LOGGER.debug("actual --> " + actual);
        LOGGER.debug("this.parentMDC --> " + this.parentMDC);
    }

    @Override
    public K call() throws Exception {
        LOGGER.debug("Call using MDCHystrixContextCallable...");
        Map childMDC = MDC.getCopyOfContextMap();
        LOGGER.debug("childMDC --> " + childMDC);

        try {
            if (parentMDC != null) {
                MDC.setContextMap(parentMDC);
            }
            LOGGER.debug("parentMDC --> " + parentMDC);
            return actual.call();
        } finally {
            if(parentMDC != null) {
                MDC.setContextMap(childMDC);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Non-Executable");
    }

}
