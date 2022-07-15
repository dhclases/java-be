package com.dh.demo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/api/v1/book")
public class BookController {

    @GetMapping()
    public String getBook() {
        return "Book Ok";
    }
}
