package com.hellokoding.springboot.controllers;

import com.hellokoding.springboot.db.Book;
import com.hellokoding.springboot.db.EntityManagerCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    EntityManagerCreator emc;

    @GetMapping({"/book"})
    public ResponseEntity<List<Book>> listAllBooks() {

        EntityManager em = emc.create();

        List<Book> query = em.createQuery("SELECT book FROM Book book", Book.class).getResultList();

        emc.close(em);

        return new ResponseEntity<List<Book>>(query, HttpStatus.OK);
    }

    @GetMapping({"/book/{id}"})
    public ResponseEntity<Book> getSingleBook(@PathVariable(value = "id") int id) {

        EntityManager em = emc.create();

        Book output = em.find(Book.class, id);

        emc.close(em);

        return new ResponseEntity<>(output, HttpStatus.OK);
    }

    @PatchMapping({"/book/{id}"})
    @ResponseStatus(value = HttpStatus.OK)
    public void updateBook(@PathVariable(value = "id") int id,
                           @RequestParam(value = "title", required = true) String new_title) {
        EntityManager em = emc.create();

        Book output = em.find(Book.class, id);
        output.setTitle(new_title);

        emc.close(em);
    }

    @DeleteMapping({"/book/{id}"})
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteBook(@PathVariable(value = "id") int id) {
        EntityManager em = emc.create();

        Book book = new Book();
        book.setId(id);
        em.remove(em.merge(book));

        emc.close(em);
    }

    @PutMapping({"/book"})
    public ResponseEntity<Book> addBook(@RequestParam(value = "title", required = true) String title) {
        EntityManager em = emc.create();

        Book book = new Book();
        book.setTitle(title);

        em.persist(book);

        emc.close(em);

        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}
