package com.example.crm.controller;

import com.example.crm.model.Attachment; import com.example.crm.service.AttachmentService; import org.springframework.data.domain.Page; import org.springframework.http.ResponseEntity; import org.springframework.web.bind.annotation.*; import org.springframework.web.multipart.MultipartFile; import java.util.Map;

@RestController @RequestMapping("/api/attachments") public class AttachmentController { private final AttachmentService svc; public AttachmentController(AttachmentService s){this.svc=s;} @GetMapping public Page<Attachment> list(@RequestParam String entityType, @RequestParam String entityId, @RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="20") int size){ return svc.list(entityType, entityId, page, size);} @PostMapping(consumes={"multipart/form-data"}) public ResponseEntity<Attachment> upload(@RequestParam String entityType, @RequestParam String entityId, @RequestParam MultipartFile file){ // TODO: implement provider upload (S3/Azure/GCS). For now, store metadata only.
  Attachment a = new Attachment(); a.setEntityType(entityType); a.setEntityId(entityId); a.setContentType(file.getContentType()); a.setSize(file.getSize()); a.setObjectKey(file.getOriginalFilename()); return ResponseEntity.ok(svc.saveMeta(a)); }
}
