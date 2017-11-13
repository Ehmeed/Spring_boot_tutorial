package com.ehmeed.springframework.spring5webapp.bootstrap;

import com.ehmeed.springframework.spring5webapp.model.Author;
import com.ehmeed.springframework.spring5webapp.model.Book;
import com.ehmeed.springframework.spring5webapp.model.Publisher;
import com.ehmeed.springframework.spring5webapp.repositories.AuthorRepository;
import com.ehmeed.springframework.spring5webapp.repositories.BookRepository;
import com.ehmeed.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        //publisher
        Publisher pub1 = new Publisher("KKs", "Tasov 123");
        ddd.setPublisher(pub1);

        publisherRepository.save(pub1);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Develepment without EJB", "23444");
        rod.getBooks().add(noEJB);
        noEJB.setPublisher(pub1);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
