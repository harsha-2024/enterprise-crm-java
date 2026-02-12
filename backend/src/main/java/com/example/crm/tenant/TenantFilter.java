package com.example.crm.tenant;

import jakarta.servlet.FilterChain; import jakarta.servlet.ServletException; import jakarta.servlet.http.HttpServletRequest; import jakarta.servlet.http.HttpServletResponse; import org.springframework.stereotype.Component; import org.springframework.web.filter.OncePerRequestFilter; import java.io.IOException;

@Component public class TenantFilter extends OncePerRequestFilter { @Override protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException { try { String t = req.getHeader("X-Tenant-ID"); TenantContext.setTenantId(t); chain.doFilter(req, res);} finally { TenantContext.clear(); } } }
