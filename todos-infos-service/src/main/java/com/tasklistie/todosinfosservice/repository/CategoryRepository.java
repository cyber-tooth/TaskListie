package com.tasklistie.todosinfosservice.repository;

import com.tasklistie.todosinfosservice.models.CategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer> {
    Optional<CategoryEntity> findByUserIdAndTaskId(Integer userId, Integer taskId);
    List<CategoryEntity> findAllByUserId(Integer userId);
}
