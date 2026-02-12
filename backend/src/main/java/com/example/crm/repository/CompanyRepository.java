package com.example.crm.repository;

import com.example.crm.model.Company;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.domain.Page; import org.springframework.data.domain.Pageable;

public interface CompanyRepository extends MongoRepository<Company, String> {
  Page<Company> findByTenantIdAndNameContainingIgnoreCase(String tenantId, String q, Pageable p);
  Page<Company> findByTenantId(String tenantId, Pageable p);
}
