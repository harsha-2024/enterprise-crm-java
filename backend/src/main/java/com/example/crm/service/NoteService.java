package com.example.crm.service;

import com.example.crm.model.Note; import com.example.crm.repository.NoteRepository; import com.example.crm.tenant.TenantContext; import org.springframework.data.domain.Page; import org.springframework.data.domain.PageRequest; import org.springframework.stereotype.Service;

@Service public class NoteService {
  private final NoteRepository repo; public NoteService(NoteRepository r){this.repo=r;}
  public Page<Note> list(String type, String id, int page, int size){ return repo.findByTenantIdAndEntityTypeAndEntityIdOrderByCreatedAtDesc(TenantContext.getTenantId(), type, id, PageRequest.of(page, size)); }
  public Note add(Note n){ n.setTenantId(TenantContext.getTenantId()); return repo.save(n); }
}
