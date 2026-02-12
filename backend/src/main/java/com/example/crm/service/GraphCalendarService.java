package com.example.crm.service;

import com.microsoft.graph.models.*; import com.microsoft.graph.serviceclient.GraphServiceClient; import org.springframework.stereotype.Service; import java.time.OffsetDateTime; import java.time.ZoneOffset; 

@Service public class GraphCalendarService { private final GraphClientFactory factory; public GraphCalendarService(GraphClientFactory f){this.factory=f;} public void upsertTaskEvent(String userEmail, String subject, java.time.LocalDateTime when){ GraphServiceClient g = factory.appClient(); Event ev = new Event(); ev.setSubject(subject); DateTimeTimeZone start = new DateTimeTimeZone(); start.setDateTime(OffsetDateTime.of(when, ZoneOffset.UTC).toString()); start.setTimeZone("UTC"); ev.setStart(start); DateTimeTimeZone end = new DateTimeTimeZone(); end.setDateTime(OffsetDateTime.of(when.plusHours(1), ZoneOffset.UTC).toString()); end.setTimeZone("UTC"); ev.setEnd(end); g.users().byUserId(userEmail).events().post(ev); } }
