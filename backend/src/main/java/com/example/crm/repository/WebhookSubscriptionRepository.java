package com.example.crm.repository;

import com.example.crm.model.WebhookSubscription;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface WebhookSubscriptionRepository extends MongoRepository<WebhookSubscription, String> {
  List<WebhookSubscription> findByTenantIdAndActiveTrue(String tenantId);
}
