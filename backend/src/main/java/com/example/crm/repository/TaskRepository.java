package com.example.crm.repository;

import com.example.crm.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.domain.Page; import org.springframework.data.domain.Pageable;

public interface TaskRepository extends MongoRepository<Task, String> {
  Page<Task> findByTenantIdAndOwnerUserId(String tenantId, String ownerUserId, Pageable p);
}
