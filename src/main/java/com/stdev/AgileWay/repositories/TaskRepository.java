package com.stdev.AgileWay.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stdev.AgileWay.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	Optional<Task> findByTitle(String title);
}
