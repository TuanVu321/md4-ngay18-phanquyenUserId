package com.codegym.demo.service.taskservice;

import com.codegym.demo.model.AppUser;
import com.codegym.demo.model.Task;
import com.codegym.demo.repository.ITaskRepository;
import com.codegym.demo.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TaskService implements ITaskService{
    @Autowired
    private ITaskRepository taskRepository;

    @Override
    public Iterable<Task> findAllByUser(AppUser user) {
        return taskRepository.findAllByUser(user);
    }

    @Override
    public Iterable<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void remove(Long id) {
        taskRepository.deleteById(id);
    }
}
