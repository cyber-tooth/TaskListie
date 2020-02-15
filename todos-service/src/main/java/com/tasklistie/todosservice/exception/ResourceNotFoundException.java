package com.tasklistie.todosservice.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

  public ResourceNotFoundException(String resource, Long id) {
    super(String.format("Could not find resource %s with identifier %d", resource, id));
  }
}