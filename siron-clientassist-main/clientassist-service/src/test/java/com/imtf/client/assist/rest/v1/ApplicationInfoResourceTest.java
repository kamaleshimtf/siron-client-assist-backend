package com.imtf.client.assist.rest.v1;

import com.imtf.client.assist.domain.ApplicationInfo;
import com.imtf.client.assist.service.ApplicationInfoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ApplicationInfoResourceTest {

    @InjectMocks
    private ApplicationInfoResource applicationInfoResource;

    @Mock
    private ApplicationInfoService applicationInfoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetProjectInfo_Success() {
        ApplicationInfo mockApplicationInfo = new ApplicationInfo("TestApp", "1.0.0");
        when(applicationInfoService.getApplicationInfo()).thenReturn(mockApplicationInfo);

        ApplicationInfo result = applicationInfoResource.getApplicationInfo();

        assertNotNull(result);
        assertEquals("TestApp", result.applicationName());
        assertEquals("1.0.0", result.applicationVersion());
        verify(applicationInfoService, times(1)).getApplicationInfo();
    }

    @Test
    void testGetProjectInfo_Exception() {
        when(applicationInfoService.getApplicationInfo()).thenThrow(new RuntimeException("Service error"));

        Exception exception = assertThrows(RuntimeException.class, () -> applicationInfoResource.getApplicationInfo());
        assertEquals("Service error", exception.getMessage());
        verify(applicationInfoService, times(1)).getApplicationInfo();
    }
}
