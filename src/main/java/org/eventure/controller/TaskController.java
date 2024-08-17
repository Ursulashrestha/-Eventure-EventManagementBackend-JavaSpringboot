//package org.eventure.controller;
//
//
//
//import org.eventure.datamodel.Task;
//import org.eventure.services.Impl.TaskService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/tasks")
//public class TaskController {
//
//    @Autowired
//    private TaskService taskService;
//
//    @PostMapping
//    public ResponseEntity<Task> createTask(@RequestBody Task task) {
//        Task createdTask = taskService.createTask(task);
//        return ResponseEntity.ok(createdTask);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Task>> getAllTasks() {
//        return ResponseEntity.ok(taskService.getAllTasks());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Task> getTaskById(@PathVariable String id) {
//        return ResponseEntity.ok(taskService.getTaskById(id));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Task> updateTask(@PathVariable String id, @RequestBody Task task) {
//        task.setId(id);
//        return ResponseEntity.ok(taskService.updateTask(task));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteTask(@PathVariable String id) {
//        taskService.deleteTask(id);
//        return ResponseEntity.noContent().build();
//    }
//}
//
