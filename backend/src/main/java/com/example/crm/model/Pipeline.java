package com.example.crm.model;

import org.springframework.data.annotation.Id; import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList; import java.util.List;

@Document("pipelines")
public class Pipeline {
    @Id private String id; private String tenantId; private String name;
    private List<PipelineStage> stages = new ArrayList<>();
    public String getId(){return id;} public void setId(String id){this.id=id;}
    public String getTenantId(){return tenantId;} public void setTenantId(String t){this.tenantId=t;}
    public String getName(){return name;} public void setName(String n){this.name=n;}
    public List<PipelineStage> getStages(){return stages;} public void setStages(List<PipelineStage> s){this.stages=s;}
}
