package com.yafimchyk.draft.service;

import com.yafimchyk.draft.entity.MyUser;
import com.yafimchyk.draft.repository.MyUserRepository;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@AllArgsConstructor
public class MyUserService implements UserDetailsService {

    @Autowired
    private final MyUserRepository myUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<MyUser> myUser = myUserRepository.findByUsername(username);
        if(myUser.isPresent()) {
            MyUser userObj = myUser.get();
            return User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .build();
        }
        throw new UsernameNotFoundException(username);
    }
}
