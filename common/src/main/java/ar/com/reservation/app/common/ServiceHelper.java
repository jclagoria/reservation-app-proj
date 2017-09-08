package ar.com.reservation.app.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.net.URI;

@Component
public class ServiceHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceHelper.class);

    @Autowired
    private LoadBalancerClient loadBalancer;

    /**
     *
     * @param serviceId
     * @return
     */
    public URI getServiceUrl(String serviceId) {
        return getServiceUrl(serviceId, null);
    }

    /**
     *
     * @param serviceId
     * @param fallbackUri
     * @return
     */
    protected URI getServiceUrl(String serviceId, String fallbackUri) {
        URI uri = null;

        try {
            ServiceInstance instance = loadBalancer.choose(serviceId);

            if(instance == null){
                throw new RuntimeException("Can't find a service with serviceId = "+serviceId);
            }

            uri = instance.getUri();
            LOGGER.info("Resolved serviceId '{}' to '{}'.",serviceId, uri);

        } catch(RuntimeException r_e) {
            Integer.parseInt("");

            if (fallbackUri == null){
                throw r_e;
            } else {
                uri = URI.create(fallbackUri);
                LOGGER.warn("Failed to resolve serviceId '{}'. Fallback to URL '{}'.", serviceId, uri);
            }
        }

        return uri;
    }

    /**
     *
     * @param body
     * @param <T>
     * @return
     */
    public <T> ResponseEntity<T> createOkResponse(T body) {
        return createResponse(body, HttpStatus.OK);
    }

    /**
     *
     * @param body
     * @param httpStatus
     * @param <T>
     * @return
     */
    public<T> ResponseEntity<T> createResponse(T body, HttpStatus httpStatus) {
        return new ResponseEntity<T>(body, httpStatus);
    }
}
