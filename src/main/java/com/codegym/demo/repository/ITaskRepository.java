package com.codegym.demo.repository;

import com.codegym.demo.model.AppUser;
import com.codegym.demo.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface ITaskRepository extends CrudRepository<Task,Long> {
    Iterable<Task> findAllByUser(AppUser user);
}
