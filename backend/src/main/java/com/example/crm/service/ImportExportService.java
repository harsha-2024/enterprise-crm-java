package com.example.crm.service;

import com.example.crm.model.Contact; import com.example.crm.repository.ContactRepository; import com.example.crm.tenant.TenantContext; import com.opencsv.CSVReader; import com.opencsv.CSVWriter; import org.springframework.stereotype.Service; import java.io.*; import java.util.*; import org.springframework.data.domain.PageRequest;

@Service public class ImportExportService {
  private final ContactRepository contacts; public ImportExportService(ContactRepository c){this.contacts=c;}
  public int importContactsCsv(InputStream in) throws Exception { try (CSVReader reader = new CSVReader(new InputStreamReader(in))){ String[] header = reader.readNext(); if(header==null) return 0; String[] row; int count=0; while((row=reader.readNext())!=null){ Map<String,String> m = new HashMap<>(); for(int i=0;i<Math.min(header.length,row.length);i++){ m.put(header[i], row[i]); } Contact c = new Contact(); c.setTenantId(TenantContext.getTenantId()); c.setFirstName(m.getOrDefault("firstName","")); c.setLastName(m.getOrDefault("lastName","")); c.setEmail(m.getOrDefault("email","")); c.setPhone(m.getOrDefault("phone","")); contacts.save(c); count++; } return count; } }
  public byte[] exportContactsCsv() throws Exception { ByteArrayOutputStream out = new ByteArrayOutputStream(); try (CSVWriter w = new CSVWriter(new OutputStreamWriter(out))){ w.writeNext(new String[]{"firstName","lastName","email","phone"}); contacts.findByTenantId(TenantContext.getTenantId(), PageRequest.of(0, 1000)).forEach(c -> { w.writeNext(new String[]{c.getFirstName(),c.getLastName(),c.getEmail(),c.getPhone()}); }); } return out.toByteArray(); }
}
