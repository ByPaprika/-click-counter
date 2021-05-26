package com.task.demo.repo;

import com.task.demo.model.Count;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CountRepository extends JpaRepository<Count, Long> {
}
