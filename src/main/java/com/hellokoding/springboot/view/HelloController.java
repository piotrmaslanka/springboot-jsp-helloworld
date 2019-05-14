package com.hellokoding.springboot.view;

import com.hellokoding.springboot.db.Book;
import com.hellokoding.springboot.db.EntityManagerCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping({"/", "/book"})
    public void hello(HttpServletResponse httpServletResponse,
                      @RequestParam(value="title", required=true) String title) {
        EntityManager em = emc.create();

        Book book = new Book();
        book.setTitle(title);

        em.persist(book);

        emc.close(em);

        httpServletResponse.setStatus(200);
    }
}
