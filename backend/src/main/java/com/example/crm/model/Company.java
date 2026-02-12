package com.example.crm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;
import java.util.ArrayList; import java.util.List;

@Document("companies")
public class Company {
  @Id private String id; private String tenantId;
  private String name; private String domain; private String website; private String phone; private String address;
  private List<String> tags = new ArrayList<>();
  private Instant createdAt = Instant.now(); private Instant updatedAt = Instant.now();
  public String getId(){return id;} public void setId(String id){this.id=id;}
  public String getTenantId(){return tenantId;} public void setTenantId(String t){this.tenantId=t;}
  public String getName(){return name;} public void setName(String n){this.name=n;}
  public String getDomain(){return domain;} public void setDomain(String d){this.domain=d;}
  public String getWebsite(){return website;} public void setWebsite(String w){this.website=w;}
  public String getPhone(){return phone;} public void setPhone(String p){this.phone=p;}
  public String getAddress(){return address;} public void setAddress(String a){this.address=a;}
  public List<String> getTags(){return tags;} public void setTags(List<String> t){this.tags=t;}
  public Instant getCreatedAt(){return createdAt;} public void setCreatedAt(Instant c){this.createdAt=c;}
  public Instant getUpdatedAt(){return updatedAt;} public void setUpdatedAt(Instant u){this.updatedAt=u;}
}
