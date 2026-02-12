package com.example.crm.repository;
import com.example.crm.model.OAuthToken;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;
public interface OAuthTokenRepository extends MongoRepository<OAuthToken, String> { Optional<OAuthToken> findByTenantIdAndUserEmail(String tenantId, String userEmail); }
