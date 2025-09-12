package com.imtf.client.assist.service;

import com.imtf.client.assist.domain.ApplicationInfo;
import com.imtf.client.assist.exception.IllegalException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationInfoServiceTest {

    private ApplicationInfoService applicationInfoService;

    @BeforeEach
    void setUp() {
        applicationInfoService = new ApplicationInfoService("TestApp", "1.0.0");
    }

    @Test
    void testGetProjectInfoSuccess() {
        ApplicationInfo applicationInfo = applicationInfoService.getApplicationInfo();

        assertNotNull(applicationInfo);
        assertEquals("TestApp", applicationInfo.applicationName());
        assertEquals("1.0.0", applicationInfo.applicationVersion());
    }

    @Test
    void testProjectInfoNull() {
        ApplicationInfoService serviceWithNullValues = new ApplicationInfoService(null, null);

        IllegalException exception = assertThrows(IllegalException.class, serviceWithNullValues::getApplicationInfo);
        assertEquals("Application name or version is not set in configuration.", exception.getMessage());
    }

}
