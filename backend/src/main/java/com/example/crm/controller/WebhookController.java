package com.example.crm.controller;

import com.example.crm.model.WebhookSubscription; import com.example.crm.repository.WebhookSubscriptionRepository; import com.example.crm.service.WebhookService; import com.example.crm.tenant.TenantContext; import org.springframework.web.bind.annotation.*; import java.util.*;

@RestController @RequestMapping("/api/webhooks") public class WebhookController { private final WebhookSubscriptionRepository repo; private final WebhookService events; public WebhookController(WebhookSubscriptionRepository r, WebhookService e){this.repo=r; this.events=e;} @PostMapping("/subscriptions") public WebhookSubscription create(@RequestBody WebhookSubscription w){ w.setTenantId(TenantContext.getTenantId()); return repo.save(w);} @GetMapping("/subscriptions") public List<WebhookSubscription> list(){ return repo.findByTenantIdAndActiveTrue(TenantContext.getTenantId()); } // Inbound example for Zapier catch hook
  @PostMapping("/inbound/zapier") public Map<String,Object> zapierInbound(@RequestBody Map<String,Object> body){ // TODO: validate signature if configured
    // Echo for demo
    return Map.of("received", body, "tenant", TenantContext.getTenantId());
  }
}
