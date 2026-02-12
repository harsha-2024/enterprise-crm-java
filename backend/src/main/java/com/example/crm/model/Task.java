package com.example.crm.model;

import org.springframework.data.annotation.Id; import org.springframework.data.mongodb.core.mapping.Document; import java.time.Instant; import java.time.LocalDateTime;

@Document("tasks")
public class Task {
  @Id private String id; private String tenantId; private String type; private String subject; private String relatedEntityType; private String relatedEntityId; private String ownerUserId; private LocalDateTime dueAt; private boolean completed=false; private Instant createdAt = Instant.now();
  public String getId(){return id;} public void setId(String id){this.id=id;}
  public String getTenantId(){return tenantId;} public void setTenantId(String t){this.tenantId=t;}
  public String getType(){return type;} public void setType(String v){this.type=v;}
  public String getSubject(){return subject;} public void setSubject(String v){this.subject=v;}
  public String getRelatedEntityType(){return relatedEntityType;} public void setRelatedEntityType(String v){this.relatedEntityType=v;}
  public String getRelatedEntityId(){return relatedEntityId;} public void setRelatedEntityId(String v){this.relatedEntityId=v;}
  public String getOwnerUserId(){return ownerUserId;} public void setOwnerUserId(String v){this.ownerUserId=v;}
  public LocalDateTime getDueAt(){return dueAt;} public void setDueAt(LocalDateTime v){this.dueAt=v;}
  public boolean isCompleted(){return completed;} public void setCompleted(boolean v){this.completed=v;}
  public Instant getCreatedAt(){return createdAt;} public void setCreatedAt(Instant v){this.createdAt=v;}
}
