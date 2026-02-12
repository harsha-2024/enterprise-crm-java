package com.example.crm.repository;

import com.example.crm.model.EmailMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface EmailMessageRepository extends MongoRepository<EmailMessage, String> {
  List<EmailMessage> findByTenantIdAndStatus(String tenantId, String status);
}
