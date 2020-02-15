package com.tasklistie.todosinfosservice.service;

import com.tasklistie.todosinfosservice.models.CategoryEntity;
import com.tasklistie.todosinfosservice.models.FavoriteEntity;
import com.tasklistie.todosinfosservice.repository.CategoryRepository;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public List<CategoryEntity> getAllUserCategory(Integer userId){
        return categoryRepository.findAllByUserId(userId);
    }

    public void addTaskToCategorie(Integer userId, Integer taskId) {
        categoryRepository.save(new CategoryEntity(userId, taskId));
    }
    public void deleteTaskToCategorie(Integer userId, Integer taskId) {
        Optional<CategoryEntity> favorite = categoryRepository.findByUserIdAndTaskId(userId, taskId);
        favorite.ifPresent(categoryRepository::delete);
    }
}
