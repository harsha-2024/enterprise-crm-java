package com.example.crm.controller;

import com.example.crm.service.EmailService; import org.springframework.web.bind.annotation.*; import java.util.Map;

@RestController @RequestMapping("/api/email") public class EmailController { private final EmailService svc; public EmailController(EmailService s){this.svc=s;} @PostMapping("/send") public void send(@RequestBody Map<String,String> req){ svc.queue(req.get("to"), req.get("subject"), req.get("html")); } }
