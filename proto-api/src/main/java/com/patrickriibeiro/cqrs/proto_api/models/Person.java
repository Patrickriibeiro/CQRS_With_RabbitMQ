package com.patrickriibeiro.cqrs.proto_api.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {

    private String id;

    private String fullName;

    private String birthDate;

    private Integer age;

}
