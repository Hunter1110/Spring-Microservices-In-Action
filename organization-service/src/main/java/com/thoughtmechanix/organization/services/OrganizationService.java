package com.thoughtmechanix.organization.services;

import com.thoughtmechanix.organization.model.Organization;
import com.thoughtmechanix.organization.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;

    public Organization getOrg(String organizationId) {
        Optional<Organization> t = organizationRepository.findById(organizationId);
        return t.get();
    }

    public void saveOrg(Organization org) {
        org.setId(UUID.randomUUID().toString());
        organizationRepository.save(org);
    }

    public void updateOrg(Organization org) {
        organizationRepository.save(org);
    }

    public void deleteOrg(String organizationId) {
        organizationRepository.deleteById(organizationId);
    }
}
