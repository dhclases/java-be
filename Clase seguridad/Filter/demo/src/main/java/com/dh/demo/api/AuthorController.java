package com.dh.demo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/private/api/v1/author")
public class AuthorController {

    @GetMapping()
    public String getAuthor() {
        return "Author Ok";
    }
}
