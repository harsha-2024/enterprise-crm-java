package com.example.crm.controller;

import com.example.crm.dto.AuthRequest; import com.example.crm.dto.AuthResponse; import com.example.crm.service.AuthService; import org.springframework.http.ResponseEntity; import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/api/auth") public class AuthController { private final AuthService auth; public AuthController(AuthService a){this.auth=a;} @PostMapping("/login") public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest req){ return ResponseEntity.ok(auth.login(req)); } }
