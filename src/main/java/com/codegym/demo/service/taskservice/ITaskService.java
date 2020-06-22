package com.codegym.demo.service.taskservice;

import com.codegym.demo.model.AppUser;
import com.codegym.demo.model.Task;
import com.codegym.demo.service.GeneralService;

public interface ITaskService extends GeneralService<Task> {
    Iterable<Task> findAllByUser(AppUser user);
}
