package com.example.crm.repository;

import com.example.crm.model.TimelineEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.domain.Page; import org.springframework.data.domain.Pageable;

public interface TimelineRepository extends MongoRepository<TimelineEvent, String> {
  Page<TimelineEvent> findByTenantIdAndEntityTypeAndEntityIdOrderByAtDesc(String tenantId, String type, String id, Pageable p);
}
