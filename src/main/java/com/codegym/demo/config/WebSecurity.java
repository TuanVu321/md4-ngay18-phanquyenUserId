package com.codegym.demo.config;

import com.codegym.demo.model.AppUser;
import com.codegym.demo.repository.IAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class WebSecurity {
    @Autowired
    private IAppUserRepository userRepository;

    public boolean checkUserId(Authentication authentication, String id){
        String name = authentication.getName();
        AppUser result = userRepository.findByUsername(name);
        if(result!=null){
            if(result.getId().toString().equals(id)){
                return true;
            }
        }
        return false;
    }

}
