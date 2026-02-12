package com.example.crm.controller;

import org.springframework.beans.factory.annotation.Value; import org.springframework.http.ResponseEntity; import org.springframework.web.bind.annotation.*; import java.net.URLEncoder; import java.nio.charset.StandardCharsets; import java.util.Map;

@RestController @RequestMapping("/api/oauth") public class OAuthController { private final String clientId; private final String tenantId; private final String redirect; private final String scopes; public OAuthController(@Value("${msft.clientId}") String clientId, @Value("${msft.tenantId}") String tenantId, @Value("${msft.redirectUri}") String redirect, @Value("${msft.scopes}") String scopes){ this.clientId=clientId; this.tenantId=tenantId; this.redirect=redirect; this.scopes=scopes; }
  @GetMapping("/msft/authorize") public Map<String,String> start(){ String url = "https://login.microsoftonline.com/"+tenantId+"/oauth2/v2.0/authorize?client_id="+clientId+"&response_type=code&redirect_uri="+URLEncoder.encode(redirect, StandardCharsets.UTF_8)+"&response_mode=query&scope="+URLEncoder.encode(scopes, StandardCharsets.UTF_8); return Map.of("url", url);} 
  @GetMapping("/callback") public ResponseEntity<String> callback(@RequestParam String code){ // Frontend will capture code; server can also exchange if needed.
    return ResponseEntity.ok("Code received"); }
}
