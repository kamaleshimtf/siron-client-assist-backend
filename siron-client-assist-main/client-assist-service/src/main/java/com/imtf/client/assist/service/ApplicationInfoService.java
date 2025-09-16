package com.imtf.client.assist.service;

import com.imtf.client.assist.domain.ApplicationInfo;
import com.imtf.client.assist.exception.IllegalException;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import java.util.logging.Logger;

@ApplicationScoped
public class ApplicationInfoService {

    private static final Logger LOGGER = Logger.getLogger(ApplicationInfoService.class.getName());

    private final String applicationName;
    private final String applicationVersion;

    public ApplicationInfoService(
            @ConfigProperty(name = "quarkus.application.name") String applicationName,
            @ConfigProperty(name = "quarkus.application.version") String applicationVersion) {

        this.applicationName = applicationName;
        this.applicationVersion = applicationVersion;
    }

    public ApplicationInfo getApplicationInfo() {

        LOGGER.info("Fetching application info: name=" + applicationName + ", version=" + applicationVersion);

        if (applicationName == null || applicationVersion == null){

            LOGGER.warning("Application name or version is not set in configuration.");
            throw new IllegalException("Application name or version is not set in configuration.");
        }

        return new ApplicationInfo(applicationName, applicationVersion);
    }
}
