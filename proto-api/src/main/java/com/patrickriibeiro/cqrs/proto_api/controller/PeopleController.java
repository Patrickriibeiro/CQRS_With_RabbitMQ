package com.patrickriibeiro.cqrs.proto_api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/people")
public class PeopleController {

    @Value("${api.version}")
    private String apiVersion;

    @GetMapping("/version")
    public String getApiVersion(){
        return apiVersion;
    }

}
