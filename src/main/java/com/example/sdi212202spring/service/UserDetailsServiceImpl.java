package com.example.sdi212202spring.service;

import com.example.sdi212202spring.repository.UsersRepository;
import org.springframework.stereotype.Service;
import com.example.sdi212202spring.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.*;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException {
        User user = usersRepository.findByDni(dni);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        //grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_STUDENT"));
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));
        if (user == null) {
            throw new UsernameNotFoundException(dni);
        }
        return new org.springframework.security.core.userdetails.User(user.getDni(), user.getPassword(), grantedAuthorities);
    }
}