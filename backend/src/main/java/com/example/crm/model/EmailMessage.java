package com.example.crm.model;

import org.springframework.data.annotation.Id; import org.springframework.data.mongodb.core.mapping.Document; import java.time.Instant;

@Document("email_messages")
public class EmailMessage {
  @Id private String id; private String tenantId; private String toEmail; private String subject; private String html; private String status; // QUEUED, SENT, FAILED
  private Instant createdAt = Instant.now(); private String error;
  public String getId(){return id;} public void setId(String id){this.id=id;}
  public String getTenantId(){return tenantId;} public void setTenantId(String t){this.tenantId=t;}
  public String getToEmail(){return toEmail;} public void setToEmail(String v){this.toEmail=v;}
  public String getSubject(){return subject;} public void setSubject(String v){this.subject=v;}
  public String getHtml(){return html;} public void setHtml(String v){this.html=v;}
  public String getStatus(){return status;} public void setStatus(String v){this.status=v;}
  public Instant getCreatedAt(){return createdAt;} public void setCreatedAt(Instant v){this.createdAt=v;}
  public String getError(){return error;} public void setError(String v){this.error=v;}
}
