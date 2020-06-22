package com.codegym.demo.repository;

import com.codegym.demo.model.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppUserRepository extends CrudRepository<AppUser,Long> {
    AppUser findByUsername(String username);
}
