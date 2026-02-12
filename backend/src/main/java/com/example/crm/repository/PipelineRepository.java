package com.example.crm.repository;

import com.example.crm.model.Pipeline;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface PipelineRepository extends MongoRepository<Pipeline, String> {
  List<Pipeline> findByTenantId(String tenantId);
}
