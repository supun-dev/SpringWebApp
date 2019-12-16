package com.springframework.SpringWebApp.repositories;

import com.springframework.SpringWebApp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long>
{
    
}
