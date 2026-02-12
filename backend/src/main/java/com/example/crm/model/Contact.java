package com.example.crm.model;

import org.springframework.data.annotation.Id; import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant; import java.util.ArrayList; import java.util.List;

@Document("contacts")
public class Contact {
  @Id private String id; private String tenantId;
  private String firstName; private String lastName; private String email; private String phone; private String companyId;
  private List<String> tags = new ArrayList<>();
  private String ownerUserId; private Instant createdAt = Instant.now(); private Instant updatedAt = Instant.now();
  public String getId(){return id;} public void setId(String id){this.id=id;}
  public String getTenantId(){return tenantId;} public void setTenantId(String t){this.tenantId=t;}
  public String getFirstName(){return firstName;} public void setFirstName(String v){this.firstName=v;}
  public String getLastName(){return lastName;} public void setLastName(String v){this.lastName=v;}
  public String getEmail(){return email;} public void setEmail(String v){this.email=v;}
  public String getPhone(){return phone;} public void setPhone(String v){this.phone=v;}
  public String getCompanyId(){return companyId;} public void setCompanyId(String v){this.companyId=v;}
  public List<String> getTags(){return tags;} public void setTags(List<String> v){this.tags=v;}
  public String getOwnerUserId(){return ownerUserId;} public void setOwnerUserId(String v){this.ownerUserId=v;}
  public Instant getCreatedAt(){return createdAt;} public void setCreatedAt(Instant v){this.createdAt=v;}
  public Instant getUpdatedAt(){return updatedAt;} public void setUpdatedAt(Instant v){this.updatedAt=v;}
}
