package com.example.crm.repository;

import com.example.crm.model.EmailTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface EmailTemplateRepository extends MongoRepository<EmailTemplate, String> {
  List<EmailTemplate> findByTenantId(String tenantId);
}
