package com.example.crm.model;

import org.springframework.data.annotation.Id; import org.springframework.data.mongodb.core.mapping.Document; import java.time.Instant; import java.util.Set;

@Document("webhook_subscriptions")
public class WebhookSubscription {
  @Id private String id; private String tenantId; private String url; private String secret; private Set<String> events; private boolean active = true; private Instant createdAt = Instant.now();
  public String getId(){return id;} public void setId(String id){this.id=id;}
  public String getTenantId(){return tenantId;} public void setTenantId(String t){this.tenantId=t;}
  public String getUrl(){return url;} public void setUrl(String v){this.url=v;}
  public String getSecret(){return secret;} public void setSecret(String v){this.secret=v;}
  public Set<String> getEvents(){return events;} public void setEvents(Set<String> v){this.events=v;}
  public boolean isActive(){return active;} public void setActive(boolean v){this.active=v;}
  public Instant getCreatedAt(){return createdAt;} public void setCreatedAt(Instant v){this.createdAt=v;}
}
