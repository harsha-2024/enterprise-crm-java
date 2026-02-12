package com.example.crm.service;

import com.example.crm.model.EmailMessage; import com.example.crm.repository.EmailMessageRepository; import com.example.crm.tenant.TenantContext; import org.springframework.mail.javamail.JavaMailSender; import org.springframework.mail.javamail.MimeMessageHelper; import org.springframework.scheduling.annotation.Scheduled; import org.springframework.stereotype.Service; import jakarta.mail.internet.MimeMessage; import java.util.List;

@Service public class EmailService {
  private final JavaMailSender mail; private final EmailMessageRepository repo; public EmailService(JavaMailSender m, EmailMessageRepository r){this.mail=m; this.repo=r;}
  public void queue(String to, String subject, String html){ EmailMessage msg = new EmailMessage(); msg.setTenantId(TenantContext.getTenantId()); msg.setToEmail(to); msg.setSubject(subject); msg.setHtml(html); msg.setStatus("QUEUED"); repo.save(msg);}  
  @Scheduled(fixedDelay = 15000) public void sendQueued(){ List<EmailMessage> list = repo.findByTenantIdAndStatus(TenantContext.getTenantId(), "QUEUED"); for(EmailMessage m : list){ try{ MimeMessage mm = mail.createMimeMessage(); MimeMessageHelper h = new MimeMessageHelper(mm, true); h.setTo(m.getToEmail()); h.setSubject(m.getSubject()); h.setText(m.getHtml(), true); mail.send(mm); m.setStatus("SENT"); } catch(Exception ex){ m.setStatus("FAILED"); m.setError(ex.getMessage()); } repo.save(m); } }
}
