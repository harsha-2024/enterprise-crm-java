package com.example.crm.service;

import com.example.crm.model.WebhookSubscription; import com.example.crm.repository.WebhookSubscriptionRepository; import com.example.crm.tenant.TenantContext; import org.springframework.http.HttpEntity; import org.springframework.http.HttpHeaders; import org.springframework.http.MediaType; import org.springframework.stereotype.Service; import org.springframework.web.client.RestTemplate; import java.nio.charset.StandardCharsets; import javax.crypto.Mac; import javax.crypto.spec.SecretKeySpec; import java.util.*; import com.fasterxml.jackson.databind.ObjectMapper;

@Service public class WebhookService {
  private final WebhookSubscriptionRepository repo; private final RestTemplate http = new RestTemplate(); private final ObjectMapper mapper = new ObjectMapper();
  public WebhookService(WebhookSubscriptionRepository r){this.repo=r;}
  public void publish(String event, Map<String,Object> payload){ List<WebhookSubscription> subs = repo.findByTenantIdAndActiveTrue(TenantContext.getTenantId()); for (WebhookSubscription s: subs){ if(!s.getEvents().contains(event)) continue; try{ String body = mapper.writeValueAsString(payload); HttpHeaders headers = new HttpHeaders(); headers.setContentType(MediaType.APPLICATION_JSON); if(s.getSecret()!=null){ headers.set("X-Signature", hmacSha256Hex(s.getSecret(), body)); } http.postForEntity(s.getUrl(), new HttpEntity<>(body, headers), String.class); } catch(Exception ignored){} }
  }
  private String hmacSha256Hex(String secret, String data) throws Exception { Mac mac = Mac.getInstance("HmacSHA256"); mac.init(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256")); byte[] raw = mac.doFinal(data.getBytes(StandardCharsets.UTF_8)); StringBuilder sb = new StringBuilder(); for(byte b: raw){ sb.append(String.format("%02x", b)); } return sb.toString(); }
}
