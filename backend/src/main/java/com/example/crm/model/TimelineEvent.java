package com.example.crm.model;

import org.springframework.data.annotation.Id; import org.springframework.data.mongodb.core.mapping.Document; import java.time.Instant;

@Document("timeline")
public class TimelineEvent {
  @Id private String id; private String tenantId; private String entityType; private String entityId; private String type; private String dataJson; private Instant at = Instant.now(); private String actorUserId;
  public String getId(){return id;} public void setId(String id){this.id=id;}
  public String getTenantId(){return tenantId;} public void setTenantId(String t){this.tenantId=t;}
  public String getEntityType(){return entityType;} public void setEntityType(String v){this.entityType=v;}
  public String getEntityId(){return entityId;} public void setEntityId(String v){this.entityId=v;}
  public String getType(){return type;} public void setType(String v){this.type=v;}
  public String getDataJson(){return dataJson;} public void setDataJson(String v){this.dataJson=v;}
  public Instant getAt(){return at;} public void setAt(Instant v){this.at=v;}
  public String getActorUserId(){return actorUserId;} public void setActorUserId(String v){this.actorUserId=v;}
}
