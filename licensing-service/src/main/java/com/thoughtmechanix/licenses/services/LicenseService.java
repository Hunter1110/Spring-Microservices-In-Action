package com.thoughtmechanix.licenses.services;

import com.thoughtmechanix.licenses.clients.OrganizationDiscoveryClient;
import com.thoughtmechanix.licenses.clients.OrganizationRestTemplateClient;
import com.thoughtmechanix.licenses.config.ServerConfig;
import com.thoughtmechanix.licenses.model.License;
import com.thoughtmechanix.licenses.model.Organization;
import com.thoughtmechanix.licenses.repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicenseService {

    @Autowired
    private LicenseRepository licenseRepository;

    @Autowired
    private OrganizationDiscoveryClient organizationDiscoveryClient;

    @Autowired
    private OrganizationRestTemplateClient organizationRestClient;

    @Autowired
    ServerConfig serverConfig;

    public License getLicense(String organizationId, String licenseId, String clientType) {
        License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
        Organization org = retrieveOrgInfo(organizationId, clientType);

        return license
                .withComment(serverConfig.getExampleProperty())
                .withOrganizationName(org.getName())
                .withContactName(org.getContactName())
                .withContactEmail(org.getContactName())
                .withContactPhone(org.getContactPhone());
    }

    public List<License> getLicensesByOrg(String organizationId) {
        return licenseRepository.findByOrganizationId(organizationId);
    }

    private Organization retrieveOrgInfo(String organizationId, String clientType){
        Organization organization = null;

        switch (clientType) {
//            case "feign":
//                System.out.println("I am using the feign client");
//                organization = organizationFeignClient.getOrganization(organizationId);
//                break;
            case "rest":
                System.out.println("I am using the rest client");
                organization = organizationRestClient.getOrganization(organizationId);
                break;
            case "discovery":
                System.out.println("I am using the discovery client");
                organization = organizationDiscoveryClient.getOrganization(organizationId);
                break;
            default:
                organization = organizationRestClient.getOrganization(organizationId);
        }

        return organization;
    }
}
