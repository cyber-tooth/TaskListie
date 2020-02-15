package com.tasklistie.todosinfosservice.resources;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tasklistie.todosinfosservice.models.Info;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todosinfo")
public class TodosInfo {

    @RequestMapping("/{todoID}")
    @HystrixCommand(fallbackMethod = "getTodosInfo")
    public Info getTodosInfo(@PathVariable("todoID") String todoID){

        return new Info(todoID, "Arbeit", false);
    }
}
