package com.springframework.SpringWebApp.bootstrap;

import com.springframework.SpringWebApp.model.*;
import com.springframework.SpringWebApp.repositories.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>
{
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository; 

    //Constructor
    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository)
    {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        initData();
    }

    private void initData()
    { 
        Publisher bloomberg = new Publisher();
        bloomberg.setName("Bloomberg");
        bloomberg.setAddress("200,Main Dr,Makati");
        publisherRepository.save(bloomberg);
        
        Publisher ladybug = new Publisher();
        ladybug.setName("Ladybug");
        ladybug.setAddress("100,Main Dr,Colombo");
        publisherRepository.save(ladybug);
        
        //-----Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Data Driven Design", "144BN121957", bloomberg);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        //Saving entities to database
        authorRepository.save(eric);
        bookRepository.save(ddd);

        //-----Rob
        Author rob = new Author("Rob", "Davidson");
        Book noEJB = new Book("J2EE with no EJB", "339BN554422", ladybug);
        rob.getBooks().add(noEJB);
        noEJB.getAuthors().add(rob);

        //Saving entities to database
        authorRepository.save(rob);
        bookRepository.save(noEJB);

    }

}
