package com.klim.brt.repository;

import com.klim.brt.entity.Authors;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Authors, Long> {
}
