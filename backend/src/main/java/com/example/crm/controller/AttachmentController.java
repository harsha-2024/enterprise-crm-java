package com.example.crm.controller;

import com.example.crm.dto.PresignRequest; import com.example.crm.dto.PresignResponse; import com.example.crm.model.Attachment; import com.example.crm.service.S3PresignService; import org.springframework.data.domain.Page; import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/api/attachments") public class AttachmentController { private final S3PresignService svc; public AttachmentController(S3PresignService s){this.svc=s;} @PostMapping("/presign") public PresignResponse presign(@RequestBody PresignRequest req){ return svc.presign(req);} @PostMapping public Attachment save(@RequestBody Attachment a){ return svc.saveMeta(a);} @GetMapping public Page<Attachment> list(@RequestParam String entityType, @RequestParam String entityId, @RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="20") int size){ return svc.list(entityType, entityId, page, size);} }
