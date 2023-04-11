package com.raymetrics.admin.web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;

@RequiredArgsConstructor
@Service
public class LoginSerivce implements UserDetailsService {
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        System.out.println("service들어옴");
        return null;
    }
}
