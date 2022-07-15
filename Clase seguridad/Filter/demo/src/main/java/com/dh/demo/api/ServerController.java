package com.dh.demo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/public/api/v1/server")
public class ServerController {

    @GetMapping("/status")
    public String login() {
        return "Server Ok";
    }
}
