package ar.com.reservation.app.common;

import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;

import java.util.concurrent.Callable;

public class MDCHystrixConcurrencyStrategy extends HystrixConcurrencyStrategy {

    public <T> Callable<T> wrapCallable(Callable<T> callable) {
        return new MDCConcurrentCallable<>(callable);
    }
}
