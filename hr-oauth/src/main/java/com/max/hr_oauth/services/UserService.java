package com.max.hr_oauth.services;

import com.max.hr_oauth.feignClient.UserFeignClient;
import com.max.hr_oauth.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserFeignClient userFeignClient;

    private static Logger Logger = LoggerFactory.getLogger(UserService.class);

    public User findByEmail(String email){
        User user = userFeignClient.findByEmail(email).getBody();
        if (user == null){
            Logger.error("Email não encontrado");
            throw new UsernameNotFoundException("Email não encontrado");
        }
        Logger.info("email encontrado: "+ email);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return findByEmail(s);
    }
}
