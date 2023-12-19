package com.bennett.spring6webapp.bootstrap;

import com.bennett.spring6webapp.domain.Author;
import com.bennett.spring6webapp.domain.Book;
import com.bennett.spring6webapp.domain.Publisher;
import com.bennett.spring6webapp.repository.AuthorRepository;
import com.bennett.spring6webapp.repository.BookRepository;
import com.bennett.spring6webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("12345");

        Publisher awp = new Publisher();
        awp.setPublisherName("Addison-Wesley Professional");
        awp.setAddress("1900 E Lake Ave");
        awp.setCity("Glenview");
        awp.setState("Illinois");
        awp.setZip("60025");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);
        Publisher awpSaved = publisherRepository.save(awp);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development Without EJB");
        noEJB.setIsbn("67890");

        Publisher wrox = new Publisher();
        wrox.setPublisherName("Wrox");
        wrox.setAddress("111 River Street");
        wrox.setCity("Hoboken");
        wrox.setState("New Jersey");
        wrox.setZip("07030");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);
        Publisher wroxSaved = publisherRepository.save(wrox);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);
        wroxSaved.getBooks().add(noEJBSaved);
        awpSaved.getBooks().add(dddSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        publisherRepository.save(wroxSaved);
        publisherRepository.save(awpSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
        System.out.println("Publisher count: " + publisherRepository.count());
    }
}
