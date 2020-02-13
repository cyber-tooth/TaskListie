package com.tasklistie.todosinfosservice.service;

import com.tasklistie.todosinfosservice.models.FavoriteEntity;
import com.tasklistie.todosinfosservice.repository.FavoritesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoritesService {

    private final FavoritesRepository favoritesRepository;

    public FavoritesService(FavoritesRepository favoritesRepository) {
        this.favoritesRepository = favoritesRepository;
    }

    public List<FavoriteEntity> getAllUserFavorites(Integer userId) {
        return favoritesRepository.findAllByUserId(userId);
    }

    public void addTaskToFavorites(Integer userId, Integer taskId) {
        favoritesRepository.save(new FavoriteEntity(userId, taskId));
    }

    public void deleteTaskToFavorites(Integer userId, Integer taskId) {
        Optional<FavoriteEntity> favorite = favoritesRepository.findByUserIdAndTaskId(userId, taskId);
        favorite.ifPresent(favoritesRepository::delete);
    }
}
