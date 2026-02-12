package com.example.crm.service;

import com.example.crm.model.Attachment; import com.example.crm.repository.AttachmentRepository; import com.example.crm.tenant.TenantContext; import org.springframework.beans.factory.annotation.Value; import org.springframework.data.domain.Page; import org.springframework.data.domain.PageRequest; import org.springframework.stereotype.Service;

@Service public class AttachmentService {
  private final AttachmentRepository repo; private final String provider;
  public AttachmentService(AttachmentRepository r, @Value("${storage.provider}") String provider){ this.repo=r; this.provider=provider; }
  public Page<Attachment> list(String type, String id, int page, int size){ return repo.findByTenantIdAndEntityTypeAndEntityId(TenantContext.getTenantId(), type, id, PageRequest.of(page, size)); }
  public Attachment saveMeta(Attachment a){ a.setTenantId(TenantContext.getTenantId()); // TODO: integrate presigned URLs per provider
    if (a.getProvider()==null) a.setProvider(provider); return repo.save(a);
  }
}
