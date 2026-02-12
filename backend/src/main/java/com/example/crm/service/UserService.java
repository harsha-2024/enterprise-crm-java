package com.example.crm.service;

import com.example.crm.model.User; import com.example.crm.repository.UserRepository; import com.example.crm.tenant.TenantContext;
import org.springframework.security.core.GrantedAuthority; import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails; import org.springframework.security.core.userdetails.UserDetailsService; import org.springframework.security.core.userdetails.UsernameNotFoundException; import org.springframework.security.crypto.password.PasswordEncoder; import org.springframework.stereotype.Service;
import java.util.List; import java.util.Set; import java.util.stream.Collectors;

@Service public class UserService implements UserDetailsService {
  private final UserRepository repo; private final PasswordEncoder encoder;
  public UserService(UserRepository r, PasswordEncoder e){this.repo=r; this.encoder=e;}
  public User createUser(String email, String password, String fullName, Set<String> roles){ User u = new User(); u.setEmail(email); u.setPasswordHash(encoder.encode(password)); u.setFullName(fullName); u.setRoles(roles); u.setTenantId(TenantContext.getTenantId()); return repo.save(u);}  
  public User findByEmailOrThrow(String email){ return repo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found")); }
  @Override public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { User u = findByEmailOrThrow(username); List<GrantedAuthority> auth = u.getRoles().stream().map(r-> new SimpleGrantedAuthority("ROLE_"+r)).collect(Collectors.toList()); return new org.springframework.security.core.userdetails.User(u.getEmail(), u.getPasswordHash(), auth);}  
}
