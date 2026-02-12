package com.example.crm.repository;

import com.example.crm.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.domain.Page; import org.springframework.data.domain.Pageable;

public interface ContactRepository extends MongoRepository<Contact, String> {
  Page<Contact> findByTenantIdAndFirstNameContainingIgnoreCaseOrTenantIdAndLastNameContainingIgnoreCaseOrTenantIdAndEmailContainingIgnoreCase(String t1,String q1,String t2,String q2,String t3,String q3, Pageable p);
  Page<Contact> findByTenantId(String tenantId, Pageable p);
}
