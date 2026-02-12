package com.example.crm.repository;
import com.example.crm.model.TenantSettings;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;
public interface TenantSettingsRepository extends MongoRepository<TenantSettings, String> { Optional<TenantSettings> findByTenantId(String tenantId); }
