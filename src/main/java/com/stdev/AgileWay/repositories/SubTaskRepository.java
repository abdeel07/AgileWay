package com.stdev.AgileWay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stdev.AgileWay.entities.SubTask;

@Repository
public interface SubTaskRepository extends JpaRepository<SubTask, Long> {

}
