package com.springframework.SpringWebApp.repositories;

import com.springframework.SpringWebApp.model.Book;
import org.springframework.data.repository.CrudRepository;

//Long is the Data type of ID of Book
public interface BookRepository extends CrudRepository<Book, Long>
{
    
}
