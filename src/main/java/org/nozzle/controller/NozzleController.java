package org.nozzle.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NozzleController {

    @RequestMapping("/")
    public String index() {
        return "Hello, Nozzle!";
    }

}
