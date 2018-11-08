package com.thoughtmechanix.licenses.controllers;

import com.thoughtmechanix.licenses.model.License;
import com.thoughtmechanix.licenses.services.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {

    @Autowired
    LicenseService licenseService;

    @GetMapping(value = "/{licenseId}/{clientType}")
    public License getLicenses(@PathVariable("organizationId") String organizationId,
                               @PathVariable("licenseId") String licenseId,
                               @PathVariable("clientType") String clientType) {
       return licenseService.getLicense(organizationId, licenseId, clientType);
    }
}
