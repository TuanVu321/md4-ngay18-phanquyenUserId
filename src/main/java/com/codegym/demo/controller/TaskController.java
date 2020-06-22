package com.codegym.demo.controller;

import com.codegym.demo.model.AppUser;
import com.codegym.demo.model.Task;
import com.codegym.demo.service.taskservice.ITaskService;
import com.codegym.demo.service.userservice.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private ITaskService taskService;
    @Autowired
    private IAppUserService userService;

    @ModelAttribute("user")
    public AppUser user(){
        return userService.getCurrentUser();
    }

    @GetMapping("/")
    public ModelAndView listTask(){
        ModelAndView modelAndView = new ModelAndView("/task/list");
        List<Task> tasks = (List<Task>) taskService.findAllByUser(userService.getCurrentUser());
        modelAndView.addObject("task",tasks);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("/task/create");
        modelAndView.addObject("task", new Task());
        modelAndView.addObject("user", userService.getCurrentUser());
        return modelAndView;
    }

    @PostMapping("/create")
    public RedirectView creatTask(@ModelAttribute Task task){
        taskService.save(task);
        return new RedirectView("/");
    }



}
