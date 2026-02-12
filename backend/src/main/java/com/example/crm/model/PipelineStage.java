package com.example.crm.model;

public class PipelineStage {
    private String id; private String name; private int orderIndex; private int winProbability; // 0..100
    public String getId(){return id;} public void setId(String id){this.id=id;}
    public String getName(){return name;} public void setName(String n){this.name=n;}
    public int getOrderIndex(){return orderIndex;} public void setOrderIndex(int o){this.orderIndex=o;}
    public int getWinProbability(){return winProbability;} public void setWinProbability(int v){this.winProbability=v;}
}
