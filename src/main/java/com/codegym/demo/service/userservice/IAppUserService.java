package com.codegym.demo.service.userservice;

import com.codegym.demo.model.AppUser;
import com.codegym.demo.service.GeneralService;

public interface IAppUserService{
    AppUser getUserByUsername(String username);
    AppUser getCurrentUser();
}
