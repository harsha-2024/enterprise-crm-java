package com.example.crm.repository;

import com.example.crm.model.EmailSequence;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface EmailSequenceRepository extends MongoRepository<EmailSequence, String> {
  List<EmailSequence> findByTenantId(String tenantId);
}
