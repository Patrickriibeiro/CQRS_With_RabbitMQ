package com.patrickriibeiro.cqrs.proto_api.service.impl;

import com.github.javafaker.Faker;
import com.patrickriibeiro.cqrs.proto_api.models.Person;
import com.patrickriibeiro.cqrs.proto_api.service.PeopleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PeopleServiceImpl implements PeopleService {

    private final List<Person> listOfPeople = new ArrayList<>();

    private final Faker faker = new Faker();

    @Override
    public List<Person> getPeople() {
        return listOfPeople;
    }

    @Override
    public Optional<Person> getPersonById(String id) {
        return Optional.empty();
    }

    @Override
    public Person createPerson(Person person) {
        return null;
    }

    @Override
    public Person updatePerson(String id, Person person) {
        return null;
    }

    @Override
    public void deletePerson(String id) {

    }

    @Override
    public List<Person> getPeopleByName(String name) {
        return List.of();
    }

    @Override
    public void generatePeople(Integer quantity) {
        if (quantity <= 0) return;
        listOfPeople.clear();

        for (int i = 0; i < quantity; i++) {
            Person person = Person.builder()
                    .id(faker.idNumber().valid())
                    .fullName(faker.name().fullName())
                    .birthDate(faker.date().birthday().toString())
                    .age(faker.number().numberBetween(1, 100))
                    .build();
            listOfPeople.add(person);
        }
    }
}
