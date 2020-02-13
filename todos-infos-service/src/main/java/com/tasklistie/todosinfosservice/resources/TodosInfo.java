package com.tasklistie.todosinfosservice.resources;

import com.tasklistie.todosinfosservice.models.Info;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todosinfo")
public class TodosInfo {

    @RequestMapping("/{todoID}")
    public Info getTodosInfo(@PathVariable("todoID") String todoID){

        return new Info(todoID, "Test name", false);

    }
}
