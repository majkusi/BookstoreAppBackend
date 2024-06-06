package com.example.fitnessapp.repository;

import com.example.fitnessapp.model.BookModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends CrudRepository<BookModel, Long> {

}
