package edu.hawaii.its.casdemo.util;

import java.io.IOException;
import org.springframework.core.io.Resource;

/**
  * Set SSL-related System property "javax.net.ssl.trustStore"
  * as configured in Spring if useAlternateTruststore.
  */
public class SslPropertiesInitializer {
    public static final String TRUSTSTORE_PATH_PROPERTY = "javax.net.ssl.trustStore";
    public static final String TRUSTSTORE_PASSWORD_PROPERTY = "javax.net.ssl.trustStorePassword";

    public SslPropertiesInitializer(boolean useAlternate, Resource trustStore, String password)
            throws IOException {
        if (useAlternate) {
            System.setProperty(TRUSTSTORE_PATH_PROPERTY, trustStore.getFile().getPath());
            System.setProperty(TRUSTSTORE_PASSWORD_PROPERTY, password);
        }
    }
}