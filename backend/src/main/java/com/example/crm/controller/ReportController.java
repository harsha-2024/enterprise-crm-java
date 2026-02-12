package com.example.crm.controller;

import com.example.crm.service.ReportService; import org.springframework.web.bind.annotation.*; import java.util.Map;

@RestController @RequestMapping("/api/reports") public class ReportController { private final ReportService svc; public ReportController(ReportService s){this.svc=s;} @GetMapping("/pipeline-summary") public Map<String,Object> pipeline(){ return svc.pipelineSummary(); } }
