package com.example.crm.repository;

import com.example.crm.model.Attachment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.domain.Page; import org.springframework.data.domain.Pageable;

public interface AttachmentRepository extends MongoRepository<Attachment, String> {
  Page<Attachment> findByTenantIdAndEntityTypeAndEntityId(String tenantId, String type, String id, Pageable p);
}
