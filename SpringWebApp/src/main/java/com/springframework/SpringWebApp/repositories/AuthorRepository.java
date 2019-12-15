package com.springframework.SpringWebApp.repositories;

import com.springframework.SpringWebApp.model.Author;
import org.springframework.data.repository.CrudRepository;

//Long is the Data type of ID of Author
public interface AuthorRepository extends CrudRepository<Author, Long>
{
    
}
