/* package com.tasklistie.todosservice.resources;

import com.tasklistie.todosservice.models.Info;
import com.tasklistie.todosservice.models.RegisterItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/register")
public class TodosListe {

    @RequestMapping("/{userID}")
    public List<RegisterItem> getRegister(@PathVariable("userID") String userID){

        RestTemplate restTemplate = new RestTemplate();

        //get all task IDs
        List<Info> infos = Arrays.asList(
            new Info(1, home, false),
            new Info(3, work, false)
        );

        return infos.stream().map(info -> {
            Info info = restTemplate.getForObject("http://localhost:8082/todosinfo/" + info.getTodoID(), Info.class);
            return new RegisterItem(info.getTodoID(), "This is my first task", false);
        })
            .collect(Collectors.toList());

        //for each task ID, call todos infos service and get details

        //put them all together
        /*return Collections.singletonList(
                new RegisterItem(4, "This is my first task", false)
        );

    }
}
*/