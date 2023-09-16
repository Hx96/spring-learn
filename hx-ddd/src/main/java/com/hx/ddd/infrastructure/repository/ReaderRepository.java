package com.hx.ddd.infrastructure.repository;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ReaderRepository {
    Map<String, User> userMap = new HashMap<>();
    {
        User user = new User(
                "admin", new BCryptPasswordEncoder().encode("123456"), Collections.singleton(new SimpleGrantedAuthority("ROLE_READER"))
        );
        userMap.put("307094", user);
    }
    public UserDetails findOne(String username) {
        return userMap.get(username);
    }
}
