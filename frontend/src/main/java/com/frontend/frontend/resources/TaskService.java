package com.frontend.frontend.resources;

import com.tasklistie.todosservice.DTO.TaskDTO;
import com.tasklistie.todosservice.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TaskRepo repository;

    //http://localhost:8080/api/tasks and "http://localhost:8080/api/tasks/{id}"

  /*  private String baseUrl;

    @Autowired
    public RemoteAccessService(RestTemplate restTemplate, @Value("${service.url}") baseUrl){
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
    }

    public String grabResult(){
        return restTemplate.getForObject(baseUrl+"/hotels/{hotel}/bookings/{booking}", String.class, "42", "21");
    }

    @Value("${resource.tasks}")
    private String resource;
    @Value("${resource.tasks}/{id}")
    private String idResource; */


    public List<TaskDTO> findAll() {
        return Arrays.stream(restTemplate.getForObject("http://localhost:8080/api/tasks", TaskDTO[].class)).collect(Collectors.toList());
    }

    public TaskDTO update(Long id, TaskDTO task) {
        return restTemplate.exchange("http://localhost:8080/api/tasks/{id}", HttpMethod.PUT, new HttpEntity<>(task), TaskDTO.class, id).getBody();
    }

    public void delete(Long id) {
        restTemplate.delete("http://localhost:8080/api/tasks/{id}", id);
    }

    public TaskDTO create(TaskDTO task) {
        return restTemplate.postForObject("http://localhost:8080/api/tasks", task, TaskDTO.class);
    }
}
