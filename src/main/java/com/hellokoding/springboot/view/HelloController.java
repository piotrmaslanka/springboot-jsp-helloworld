package com.hellokoding.springboot.view;

import com.hellokoding.springboot.db.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    @Autowired
    IDAllocator idAllocator;

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

    @PostMapping({"/", "/book"})
    public void hello(HttpServletResponse httpServletResponse, @RequestParam(value="id", required=true) int id,
                      @RequestParam(value="title", required=true) String title) {
        EntityManager em = emc.create();

        Book book = new Book();
        book.setId((long)id);
        book.setTitle(title);

        em.persist(book);

        emc.close(em);

        httpServletResponse.setHeader("Location", "/book");
        httpServletResponse.setStatus(302);
    }
}
