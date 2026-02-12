package com.example.crm.service;

import com.example.crm.model.Deal; import com.example.crm.repository.DealRepository; import com.example.crm.tenant.TenantContext; import org.springframework.stereotype.Service; import java.math.BigDecimal; import java.util.*; import org.springframework.data.domain.PageRequest;

@Service public class ReportService {
  private final DealRepository deals; public ReportService(DealRepository d){this.deals=d;}
  public Map<String,Object> pipelineSummary(){ var m = new HashMap<String,Object>(); var all = deals.findByTenantId(TenantContext.getTenantId(), PageRequest.of(0, 10_000)); int won=0,lost=0,open=0; BigDecimal openAmount = BigDecimal.ZERO; for(Deal d: all){ if(d.isWon()) won++; else if(d.isLost()) lost++; else {open++; if(d.getAmount()!=null) openAmount = openAmount.add(d.getAmount());} } m.put("wonCount", won); m.put("lostCount", lost); m.put("openCount", open); m.put("openAmount", openAmount); return m; }
}
