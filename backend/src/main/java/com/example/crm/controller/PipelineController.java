package com.example.crm.controller;

import com.example.crm.model.Pipeline; import com.example.crm.service.PipelineService; import org.springframework.web.bind.annotation.*; import java.util.List;

@RestController @RequestMapping("/api/pipelines") public class PipelineController { private final PipelineService svc; public PipelineController(PipelineService s){this.svc=s;} @GetMapping public List<Pipeline> all(){ return svc.list(); } @PostMapping public Pipeline create(@RequestBody Pipeline p){ return svc.create(p);} @PutMapping("/{id}") public Pipeline update(@PathVariable String id, @RequestBody Pipeline p){ return svc.update(id, p);} }
