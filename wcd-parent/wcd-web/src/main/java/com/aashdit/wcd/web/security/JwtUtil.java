package com.aashdit.wcd.web.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.aashdit.wcd.web.service.CustomUserDetailsService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil {
	
	@Autowired
    private CustomUserDetailsService service;

    private String secret = "sujit_mishra";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(String username) { 
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    private String createToken(Map<String, Object> claims, String username) {
    	UserDetails userDetails = service.loadUserByUsername(username);
        return Jwts.builder().setClaims(claims).setSubject(username)
        	   .claim("authorities", userDetails.getAuthorities().stream()
        	   .map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
        	   .setIssuedAt(new Date(System.currentTimeMillis()))
               //.setExpiration(new Date(System.currentTimeMillis() + 10 * 60 * 60 * 10)) //10 Hours --> Default
               .setExpiration(new Date(System.currentTimeMillis() + 900000)) //15 Minutes
               .signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
    
}
	