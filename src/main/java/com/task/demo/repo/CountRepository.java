package com.task.demo.repo;

import com.task.demo.model.Count;
import org.springframework.data.repository.CrudRepository;

public interface CountRepository extends CrudRepository<Count, Long> {
}
