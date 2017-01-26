package com.caloriecounter.services;

import com.caloriecounter.models.FoodItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemRepository extends CrudRepository<FoodItem, Long> {
}
