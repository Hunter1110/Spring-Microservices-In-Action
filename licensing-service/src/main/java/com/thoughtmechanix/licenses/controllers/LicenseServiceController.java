package com.thoughtmechanix.licenses.controllers;

import com.thoughtmechanix.licenses.config.ServerConfig;
import com.thoughtmechanix.licenses.model.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {

    @Autowired
    ServerConfig serverConfig;

    @GetMapping(value = "/{licenseId}")
    public License getLicenses(@PathVariable("organizationId") String organizationId,
                               @PathVariable("licenseId") String licenseId) {
        String value = serverConfig.getExampleProperty();
        return new License()
                .withId(licenseId)
                .withOrganizationId(organizationId)
                .withProductName(value)
                .withLicenseType("Seat");
    }
}
