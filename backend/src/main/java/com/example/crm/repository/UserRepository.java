package com.example.crm.repository;

import com.example.crm.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;
import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
  Optional<User> findByEmail(String email);
  List<User> findByTenantId(String tenantId);
}
