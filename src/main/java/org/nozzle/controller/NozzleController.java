package org.nozzle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NozzleController {

    @RequestMapping("/nozzle")
    public String index() {
        return "Hello, Nozzle!";
    }

}
