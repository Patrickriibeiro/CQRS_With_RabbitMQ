package com.patrickriibeiro.cqrs.proto_api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private String id;

    private String fullName;

    private String birthDate;

    private Integer age;
}
