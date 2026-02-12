package com.example.crm.model;

import org.springframework.data.annotation.Id; import org.springframework.data.mongodb.core.mapping.Document; import java.time.Instant;

@Document("email_templates")
public class EmailTemplate {
  @Id private String id; private String tenantId; private String name; private String subject; private String html;
  private Instant createdAt = Instant.now();
  public String getId(){return id;} public void setId(String id){this.id=id;}
  public String getTenantId(){return tenantId;} public void setTenantId(String t){this.tenantId=t;}
  public String getName(){return name;} public void setName(String v){this.name=v;}
  public String getSubject(){return subject;} public void setSubject(String v){this.subject=v;}
  public String getHtml(){return html;} public void setHtml(String v){this.html=v;}
  public Instant getCreatedAt(){return createdAt;} public void setCreatedAt(Instant v){this.createdAt=v;}
}
