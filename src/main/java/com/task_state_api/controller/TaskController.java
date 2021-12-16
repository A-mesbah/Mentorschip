package com.task_state_api.controller;
import com.task_state_api.entity.Task;
import com.task_state_api.exception.ApiRequestException;
import com.task_state_api.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("v1/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/add")
    public ResponseEntity addNewTask(@RequestBody Task task) {
        taskService.addNewTask(task);
        return ResponseEntity.status(HttpStatus.OK).body(task);

    }

    @PutMapping("/")
    public ResponseEntity updateTask(@RequestBody Task task) throws ApiRequestException {
        taskService.updateTask(task);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

    @GetMapping("/")
    public ResponseEntity getAllTasks() {

        return ResponseEntity.status(HttpStatus.OK).body(taskService.getTasks());

    }
}
