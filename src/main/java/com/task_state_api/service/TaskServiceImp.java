package com.task_state_api.service;

import com.task_state_api.entity.State;
import com.task_state_api.entity.Task;
import com.task_state_api.exception.ApiRequestException;
import com.task_state_api.reposotiry.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskServiceImp implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    TaskValidation taskValidation;

    @Override
    public void addNewTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long taskId) throws ApiRequestException {
        if (taskRepository.existsById(taskId)) {
            taskRepository.deleteById(taskId);
        } else throw new ApiRequestException("This Task _id not exist");


    }

    @Override
    public void updateTask(Task task) throws ApiRequestException {
        if (taskRepository.existsById(task.getId())) {
            State oldState = taskRepository.getById(task.getId()).getState();
            int oldStateOrder = taskValidation.getStateOrder(oldState);
            State newState = task.getState();
            int newStateOrder = taskValidation.getStateOrder(newState);

            if (newStateOrder > oldStateOrder) {
                if (newStateOrder == 3 || newStateOrder == oldStateOrder + 1) {
                    taskRepository.save(task);
                } else {
                    throw new ApiRequestException("Not Allowed State ");
                }
            } else {
                throw new ApiRequestException("Not Allowed State ");

            }
        } else throw new ApiRequestException("This Task _id not exist");
    }

    @Override
    public Task getTasks(Long id) throws ApiRequestException {
        if (taskRepository.existsById(id)) {
            return taskRepository.getById(id);
        } else throw new ApiRequestException("This Task _id not exist");

    }

    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }
}
