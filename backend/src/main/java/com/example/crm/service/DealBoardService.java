package com.example.crm.service;

import com.example.crm.model.Deal; import com.example.crm.repository.DealRepository; import com.example.crm.tenant.TenantContext; import org.springframework.stereotype.Service; import java.util.List;

@Service public class DealBoardService {
  private final DealRepository deals; public DealBoardService(DealRepository d){this.deals=d;}
  public List<Deal> column(String pipelineId, String stageId){ return deals.findByTenantIdAndPipelineIdAndStageIdOrderByOrderInStage(tenant(), pipelineId, stageId); }
  public void move(String dealId, String toStageId, int newOrder){ Deal d = deals.findById(dealId).orElseThrow(); d.setStageId(toStageId); d.setOrderInStage(newOrder); deals.save(d); }
  private String tenant(){ return TenantContext.getTenantId(); }
}
