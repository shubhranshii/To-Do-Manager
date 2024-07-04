package com.shubhranshi.todo.controller;

import com.shubhranshi.todo.model.Task;
import com.shubhranshi.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("home")
    public String viewHomePage(Model model) {
        model.addAttribute("allTasksList", taskService.getAllTasks());
        return "index";
    }

    @GetMapping("/addTask")
    public String addNewTask(Model model) {
        Task task= new Task();
        model.addAttribute("task", task);
        return "newTask";
    }

    @PostMapping("/save")
    public String saveTask(@ModelAttribute("task") Task task) {
        taskService.saveTask(task);
        return "redirect:/home";
    }

    @GetMapping("/showTaskForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") int id, Model model) {
        Task task = taskService.getById(id);
        model.addAttribute("task", task);
        return "update";
    }

    @GetMapping("/deleteTask/{id}")
    public String deleteThroughId(@PathVariable(value = "id") int id) {
        taskService.deleteViaId(id);
        return "redirect:/home";
    }

    @GetMapping("/markCompleted/{id}")
    public String markComplete(@PathVariable(value = "id") int id){
        taskService.markComplete(id);
        return "redirect:/home";
    }
}
