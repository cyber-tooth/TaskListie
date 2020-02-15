package com.frontend.frontend.controller;

import com.tasklistie.todosservice.DTO.TaskDTO;
import com.tasklistie.todosservice.exception.ResourceNotFoundException;
import com.tasklistie.todosservice.models.TaskItem;
import com.tasklistie.todosservice.repo.TaskRepo;
import com.tasklistie.todosservice.resources.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private TaskService service;

    @GetMapping // GET to return all Tasks as list, which is also using JpaRepo extension
    public List<TaskItem> findAll(Model model){
        model.addAttribute("tasks", service.findAll());
        model.addAttribute("newTask", new TaskDTO());
        return "tasks";
    }

    @PostMapping // POST, make sure that the saved task is not null and fulfills the restriction we made - not to be empty
    public TaskItem save(@Valid @NotNull @RequestBody TaskItem taskItem){ //specify the type&format TaskItem for saving on POST
        return taskRepo.save(taskItem);
    }

    @PutMapping("/{id}")
    public TaskItem update(@Valid @NotNull @RequestBody TaskItem updateTaskItem, @PathVariable Long id) {
        return taskRepo.findById(id)
            .map(taskItem -> {
                taskItem.setText(updateTaskItem.getText());
                taskItem.setDone(updateTaskItem.isDone());
                taskItem.setUserID(updateTaskItem.getUserID());
                return taskRepo.save(taskItem);
            })
            .orElseThrow(() -> new ResourceNotFoundException("TaskItem", id));
      }

    @DeleteMapping("/{taskID}")
    public void delete(@PathVariable Long taskID){
        taskRepo.deleteById(taskID);
    }

}
