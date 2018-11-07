package com.thoughtmechanix.organization.controllers;

import com.thoughtmechanix.organization.model.Organization;
import com.thoughtmechanix.organization.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1/organizations")
public class OrganizationController {
    @Autowired
    private OrganizationService orgService;

    @RequestMapping(value="/{organizationId}",method = RequestMethod.GET)
    public Organization getOrganization(@PathVariable("organizationId") String orgId) {
        return orgService.getOrg(orgId);
    }

    @RequestMapping(value="/{organizationId}",method = RequestMethod.PUT)
    public void updateOrganization(@PathVariable("organizationId") String orgId, @RequestBody Organization org) {
        orgService.updateOrg( org );
    }

    @RequestMapping(value="/",method = RequestMethod.POST)
    public void saveOrganization(@RequestBody Organization org) {
        orgService.saveOrg(org);
    }

    @RequestMapping(value="/{organizationId}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrganization(@PathVariable("organizationId") String orgId) {
        orgService.deleteOrg(orgId);
    }
}
