package com.example.crm.controller;

import com.example.crm.model.Note; import com.example.crm.service.NoteService; import org.springframework.data.domain.Page; import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/api/notes") public class NoteController { private final NoteService svc; public NoteController(NoteService s){this.svc=s;} @GetMapping public Page<Note> list(@RequestParam String entityType, @RequestParam String entityId, @RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="20") int size){ return svc.list(entityType, entityId, page, size);} @PostMapping public Note add(@RequestBody Note n){ return svc.add(n);} }
