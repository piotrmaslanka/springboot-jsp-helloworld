package com.hellokoding.springboot.view;

import com.hellokoding.springboot.db.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class HelloController {
    @Autowired
    EntityManagerCreator emc;

    @GetMapping({"/", "/book"})
    public String hello2(Model model) {

        EntityManager em = emc.create();

        List<Book> query = em.createQuery("SELECT book FROM Book book", Book.class).getResultList();

        emc.close(em);

        model.addAttribute("books", query);

        return "hello";
    }

    @DeleteMapping({"/", "/book"})
    @ResponseStatus(value = HttpStatus.OK)
    public void hello3(@RequestParam(value="id", required=true) int id) {
        EntityManager em = emc.create();

        Book book = new Book();
        book.setId(id);
        em.remove(em.merge(book));

        emc.close(em);
    }

    @PostMapping({"/", "/book"})
    public ResponseEntity<Book> hello(@RequestParam(value="title", required=true) String title) {
        EntityManager em = emc.create();

        Book book = new Book();
        book.setTitle(title);

        em.persist(book);

        emc.close(em);

        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}
