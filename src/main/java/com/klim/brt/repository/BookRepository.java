package com.klim.brt.repository;

import com.klim.brt.entity.Books;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Books, Long> {
}
