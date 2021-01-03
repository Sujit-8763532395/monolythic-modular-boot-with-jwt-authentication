package com.aashdit.wcd.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aashdit.wcd.user.model.User;
import com.aashdit.wcd.user.model.UserRole;
import com.aashdit.wcd.user.repository.UserRepository;
import com.aashdit.wcd.user.service.UserService;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
    @Autowired
    private UserRepository repository;
    
    @Autowired
    private UserService userService; 

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUserName(username);
        UserRole userRole = userService.getPrimaryRoleByUserId(user.getId());  
        String roleCode = userRole.getRole().getRoleName();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(roleCode));
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), grantedAuthorities);
    }
    
}
	