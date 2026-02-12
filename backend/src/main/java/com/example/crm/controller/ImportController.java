package com.example.crm.controller;

import com.example.crm.service.ImportExportService; import org.springframework.http.HttpHeaders; import org.springframework.http.MediaType; import org.springframework.http.ResponseEntity; import org.springframework.web.bind.annotation.*; import org.springframework.web.multipart.MultipartFile; import java.util.*;

@RestController @RequestMapping("/api/import") public class ImportController { private final ImportExportService svc; public ImportController(ImportExportService s){this.svc=s;} @PostMapping("/contacts/csv") public ResponseEntity<String> importContacts(@RequestParam MultipartFile file) throws Exception { int count = svc.importCsv(file.getInputStream(), m -> { // TODO: map to Contact service
  return true; }); return ResponseEntity.ok("Imported: "+count); } @GetMapping("/contacts/csv") public ResponseEntity<byte[]> exportContacts() throws Exception { byte[] data = svc.exportCsv(new String[]{"firstName","lastName","email","phone"}, List.of(new String[]{"John","Doe","john@acme.com",""})); return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=contacts.csv").contentType(MediaType.TEXT_PLAIN).body(data);} }
