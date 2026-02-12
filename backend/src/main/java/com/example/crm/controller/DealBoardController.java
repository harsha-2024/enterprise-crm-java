package com.example.crm.controller;

import com.example.crm.model.Deal; import com.example.crm.service.DealBoardService; import org.springframework.web.bind.annotation.*; import java.util.List; import java.util.Map;

@RestController @RequestMapping("/api/board") public class DealBoardController { private final DealBoardService svc; public DealBoardController(DealBoardService s){this.svc=s;} @GetMapping("/{pipelineId}/{stageId}") public List<Deal> column(@PathVariable String pipelineId, @PathVariable String stageId){ return svc.column(pipelineId, stageId);} @PostMapping("/move") public void move(@RequestBody Map<String,Object> req){ String dealId = (String)req.get("dealId"); String toStageId = (String)req.get("toStageId"); int newOrder = (int)req.getOrDefault("newOrder", 0); svc.move(dealId, toStageId, newOrder); } }
