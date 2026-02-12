package com.example.crm.repository;
import com.example.crm.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.domain.Page; import org.springframework.data.domain.Pageable;
public interface NoteRepository extends MongoRepository<Note, String> { Page<Note> findByTenantIdAndEntityTypeAndEntityIdOrderByCreatedAtDesc(String tenantId, String type, String id, Pageable p); }
