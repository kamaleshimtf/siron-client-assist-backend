package com.imtf.client.assist.domain;

public record ApplicationInfo(String applicationName, String applicationVersion) {

    public ApplicationInfo(String applicationName, String applicationVersion) {
        this.applicationName = applicationName;
        this.applicationVersion = applicationVersion;
    }
}
