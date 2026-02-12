package com.example.crm.repository;

import com.example.crm.model.Deal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.domain.Page; import org.springframework.data.domain.Pageable;
import java.util.List;

public interface DealRepository extends MongoRepository<Deal, String> {
  Page<Deal> findByTenantIdAndTitleContainingIgnoreCase(String tenantId, String q, Pageable p);
  Page<Deal> findByTenantId(String tenantId, Pageable p);
  List<Deal> findByTenantIdAndPipelineIdAndStageIdOrderByOrderInStage(String tenantId, String pipelineId, String stageId);
}
