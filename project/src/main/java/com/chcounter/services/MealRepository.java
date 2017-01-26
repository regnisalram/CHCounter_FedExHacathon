package com.chcounter.services;

import com.chcounter.models.Meal;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by regnisalram on 1/9/17.
 */
public interface MealRepository extends PagingAndSortingRepository<Meal, Long> {

//    Page<Meal> findAllByOrderByScoreDesc(Pageable pageable);
}