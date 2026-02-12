package com.example.crm.model;

import org.springframework.data.annotation.Id; import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal; import java.time.Instant; import java.time.LocalDate; import java.util.ArrayList; import java.util.List;

@Document("deals")
public class Deal {
  @Id private String id; private String tenantId;
  private String title; private String pipelineId; private String stageId; private int orderInStage = 0;
  private String companyId; private List<String> contactIds = new ArrayList<>();
  private BigDecimal amount; private String currency = "USD"; private LocalDate closeDate; private String ownerUserId;
  private boolean won = false; private boolean lost = false; private Instant createdAt = Instant.now(); private Instant updatedAt = Instant.now();
  public String getId(){return id;} public void setId(String id){this.id=id;}
  public String getTenantId(){return tenantId;} public void setTenantId(String t){this.tenantId=t;}
  public String getTitle(){return title;} public void setTitle(String v){this.title=v;}
  public String getPipelineId(){return pipelineId;} public void setPipelineId(String v){this.pipelineId=v;}
  public String getStageId(){return stageId;} public void setStageId(String v){this.stageId=v;}
  public int getOrderInStage(){return orderInStage;} public void setOrderInStage(int v){this.orderInStage=v;}
  public String getCompanyId(){return companyId;} public void setCompanyId(String v){this.companyId=v;}
  public List<String> getContactIds(){return contactIds;} public void setContactIds(List<String> v){this.contactIds=v;}
  public BigDecimal getAmount(){return amount;} public void setAmount(BigDecimal v){this.amount=v;}
  public String getCurrency(){return currency;} public void setCurrency(String v){this.currency=v;}
  public LocalDate getCloseDate(){return closeDate;} public void setCloseDate(LocalDate v){this.closeDate=v;}
  public String getOwnerUserId(){return ownerUserId;} public void setOwnerUserId(String v){this.ownerUserId=v;}
  public boolean isWon(){return won;} public void setWon(boolean v){this.won=v;}
  public boolean isLost(){return lost;} public void setLost(boolean v){this.lost=v;}
  public Instant getCreatedAt(){return createdAt;} public void setCreatedAt(Instant v){this.createdAt=v;}
  public Instant getUpdatedAt(){return updatedAt;} public void setUpdatedAt(Instant v){this.updatedAt=v;}
}
