package com.imtf.client.assist.rest.v1;

import com.imtf.client.assist.domain.ApplicationInfo;
import com.imtf.client.assist.service.ApplicationInfoService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/v1/application-info")
public class ApplicationInfoResource {

    @Inject
    ApplicationInfoService applicationInfoService;

    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public ApplicationInfo getApplicationInfo() {
        return applicationInfoService.getApplicationInfo();
    }
}