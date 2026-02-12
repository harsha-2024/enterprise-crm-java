package com.example.crm.security;

import io.jsonwebtoken.*; import io.jsonwebtoken.security.Keys; import org.springframework.beans.factory.annotation.Value; import org.springframework.stereotype.Component; import javax.crypto.SecretKey; import java.util.Date; import java.util.Map;

@Component public class JwtUtil { private final SecretKey key; private final long expirationMs; public JwtUtil(@Value("${app.jwt.secret}") String secret, @Value("${app.jwt.expiration-seconds}") long expSec){ this.key = Keys.hmacShaKeyFor(secret.getBytes()); this.expirationMs = expSec*1000; } public String generateToken(String subject, Map<String,Object> claims){ Date now = new Date(); return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(now).setExpiration(new Date(now.getTime()+expirationMs)).signWith(key, SignatureAlgorithm.HS256).compact(); } public Jws<Claims> parse(String token){ return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);} }
