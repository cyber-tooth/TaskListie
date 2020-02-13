package com.tasklistie.todosinfosservice.repository;

import com.tasklistie.todosinfosservice.models.FavoriteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoritesRepository extends CrudRepository<FavoriteEntity, Integer> {
    Optional<FavoriteEntity> findByUserIdAndTaskId(Integer userId, Integer taskId);
    List<FavoriteEntity> findAllByUserId(Integer userId);
}
