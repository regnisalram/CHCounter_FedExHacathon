package com.chcounter.services;

import com.chcounter.models.FoodOption;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodOptionRepository extends CrudRepository<FoodOption, Long> {
}
