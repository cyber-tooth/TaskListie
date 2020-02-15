package com.frontend.frontend.repo;

import com.tasklistie.todosservice.models.TaskItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<TaskItem, Long> {
}
