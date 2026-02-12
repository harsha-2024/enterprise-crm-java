package com.example.crm.service;

import com.opencsv.CSVReader; import com.opencsv.CSVWriter; import org.springframework.stereotype.Service; import java.io.*; import java.util.*;

@Service public class ImportExportService { public int importCsv(InputStream in, java.util.function.Function<Map<String,String>, Boolean> handler) throws Exception { try (CSVReader r = new CSVReader(new InputStreamReader(in))){ String[] h = r.readNext(); if(h==null) return 0; String[] row; int count=0; while((row=r.readNext())!=null){ Map<String,String> m = new HashMap<>(); for(int i=0;i<Math.min(h.length,row.length);i++){ m.put(h[i], row[i]); } if (handler.apply(m)) count++; } return count; } } public byte[] exportCsv(String[] header, Iterable<String[]> rows) throws Exception { ByteArrayOutputStream out = new ByteArrayOutputStream(); try (CSVWriter w = new CSVWriter(new OutputStreamWriter(out))){ w.writeNext(header); for(String[] r : rows){ w.writeNext(r);} } return out.toByteArray(); } }
