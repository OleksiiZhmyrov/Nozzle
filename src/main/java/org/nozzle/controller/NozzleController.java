package org.nozzle.controller;

import org.nozzle.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NozzleController {

    private @Autowired MessageService messageService;

    @RequestMapping("/nozzle")
    public String index() {
        return String.format("Value is %s", messageService.getLatest().getPayload());
    }

}
