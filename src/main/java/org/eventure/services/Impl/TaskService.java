//package org.eventure.services.Impl;
//
//
//
//import org.eventure.datamodel.Task;
//import org.eventure.repository.TaskRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class TaskService {
//
//    @Autowired
//    private TaskRepository taskRepository;
//
//    public Task createTask(Task task) {
//        return taskRepository.save(task);
//    }
//
//    public List<Task> getAllTasks() {
//        return taskRepository.findAll();
//    }
//
//    public Task getTaskById(String taskId) {
//        return taskRepository.findById(taskId).orElse(null);
//    }
//
//    public void deleteTask(String taskId) {
//        taskRepository.deleteById(taskId);
//    }
//
//    public Task updateTask(Task task) {
//        return taskRepository.save(task);
//    }
//}
//
