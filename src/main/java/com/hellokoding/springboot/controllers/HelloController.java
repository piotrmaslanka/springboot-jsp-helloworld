package com.hellokoding.springboot.controllers;

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

    @GetMapping({"/"})
    public String hello(Model model) {
        return "bookshelf";
    }
}
