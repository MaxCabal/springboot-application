package com.max.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.max.spring.entity.Region;

@Repository
public interface RegionRepository extends CrudRepository<Region, Integer> {

}
