package com.example.crm.model;

import org.springframework.data.annotation.Id; import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Document("notes")
public class Note {
  @Id private String id; private String tenantId; private String entityType; private String entityId; private String body; private String authorUserId; private Instant createdAt = Instant.now();
  public String getId(){return id;} public void setId(String id){this.id=id;}
  public String getTenantId(){return tenantId;} public void setTenantId(String t){this.tenantId=t;}
  public String getEntityType(){return entityType;} public void setEntityType(String v){this.entityType=v;}
  public String getEntityId(){return entityId;} public void setEntityId(String v){this.entityId=v;}
  public String getBody(){return body;} public void setBody(String v){this.body=v;}
  public String getAuthorUserId(){return authorUserId;} public void setAuthorUserId(String v){this.authorUserId=v;}
  public Instant getCreatedAt(){return createdAt;} public void setCreatedAt(Instant v){this.createdAt=v;}
}
