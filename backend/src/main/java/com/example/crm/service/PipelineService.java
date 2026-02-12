package com.example.crm.service;

import com.example.crm.model.Pipeline; import com.example.crm.model.PipelineStage; import com.example.crm.repository.PipelineRepository; import com.example.crm.tenant.TenantContext; import org.springframework.stereotype.Service; import java.util.List; import java.util.UUID;

@Service public class PipelineService {
  private final PipelineRepository repo; public PipelineService(PipelineRepository r){this.repo=r;}
  public List<Pipeline> list(){ return repo.findByTenantId(TenantContext.getTenantId()); }
  public Pipeline create(Pipeline p){ p.setTenantId(TenantContext.getTenantId()); // assign IDs to stages
    if (p.getStages()!=null){ int i=0; for(PipelineStage s: p.getStages()){ if(s.getId()==null) s.setId(UUID.randomUUID().toString()); s.setOrderIndex(i++);} }
    return repo.save(p);
  }
  public Pipeline update(String id, Pipeline p){ p.setId(id); p.setTenantId(TenantContext.getTenantId()); return repo.save(p);}  
}
