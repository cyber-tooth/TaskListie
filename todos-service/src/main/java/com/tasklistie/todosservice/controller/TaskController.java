package com.tasklistie.todosservice.controller;

import com.tasklistie.todosservice.models.TaskItem;
import com.tasklistie.todosservice.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskRepo taskRepo;

    @GetMapping // GET to return all Tasks as list, which is also using JpaRepo extension
    public List<TaskItem> findAll(){
        return taskRepo.findAll();
    }

    @PostMapping // POST, make sure that the saved task is not null and fulfills the restriction we made - not to be empty
    public TaskItem save(@Valid @NotNull @RequestBody TaskItem taskItem){ //specify the type&format TaskItem for saving on POST
        return taskRepo.save(taskItem);
    }

    @PutMapping // PUT to edit and save the data for the task, needs same validation as for POST, pass the ID
    public TaskItem update(@Valid @NotNull @RequestBody TaskItem taskItem){ //to update the data we need to send all the data back
        return taskRepo.save(taskItem);
    }

    @DeleteMapping("/{taskID}")
    public void delete(@PathVariable Long taskID){
        taskRepo.deleteById(taskID);
    }

}
