package com.raymetrics.admin.web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Collection;

@RequiredArgsConstructor
@Service
public class LoginSerivce implements UserDetailsService {
//    private final User user;
//    public LoginSerivce(User user){this.user = user;}
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{

        System.out.println("service들어옴");
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new SimpleGrantedAuthority("ADMIN"));
        collect.add(new SimpleGrantedAuthority("USER"));
        User user = new User("admin", BCrypt.hashpw("admin", BCrypt.gensalt()) , collect);
        return user;
    }

}
