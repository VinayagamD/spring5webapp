package com.vinaylogics.spring5webapp.bootstrap;

import com.vinaylogics.spring5webapp.model.Author;
import com.vinaylogics.spring5webapp.model.Book;
import com.vinaylogics.spring5webapp.model.Publisher;
import com.vinaylogics.spring5webapp.repositories.AuthorRepository;
import com.vinaylogics.spring5webapp.repositories.BookRepository;
import com.vinaylogics.spring5webapp.repositories.PublisherRespository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRespository publisherRespository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRespository publisherRespository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRespository = publisherRespository;
    }

    private void initData(){
//        Eric
        Author eric = new Author("Eric","Evans");
        Publisher pub1 =  new Publisher("Harper Collins","");
        Book ddd = new Book("Domain Driven Design", "1234", pub1);
        eric.getBooks().add(ddd);
        authorRepository.save(eric);
        publisherRespository.save(pub1);
        bookRepository.save(ddd);

//        Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher pub2 = new Publisher("Worx","");
        Book nodEJB = new Book("J2EE Development without EJB", "23444", pub2);
        rod.getBooks().add(nodEJB);
        authorRepository.save(rod);
        publisherRespository.save(pub2);
        bookRepository.save(nodEJB);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
