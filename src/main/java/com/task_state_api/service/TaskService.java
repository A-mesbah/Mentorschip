package com.task_state_api.service;

import com.task_state_api.entity.Task;
import com.task_state_api.exception.ApiRequestException;

import java.util.List;

public interface TaskService {
    void addNewTask(Task task);

    void deleteTask(Long taskId) throws ApiRequestException;

    void updateTask(Task task) throws ApiRequestException;

    Task getTasks(Long id) throws ApiRequestException;

    List<Task> getTasks();
}
