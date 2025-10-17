package com.patrickriibeiro.cqrs.proto_api.controller;

import com.patrickriibeiro.cqrs.proto_api.service.PeopleService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Value("${api.version}")
    private String apiVersion;

    @GetMapping("/version")
    public String getApiVersion() {
        return apiVersion;
    }


    @GetMapping("/create-people/{quantity}")
    public String createPeople(@PathVariable("quantity") Integer quantity) {
        peopleService.generatePeople(quantity);
        return String.format("Created %d people", quantity);
    }

}
