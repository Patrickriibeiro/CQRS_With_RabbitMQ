package com.patrickriibeiro.cqrs.proto_api.service.impl;

import com.github.javafaker.Faker;
import com.patrickriibeiro.cqrs.proto_api.models.Person;
import com.patrickriibeiro.cqrs.proto_api.service.PeopleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
        return listOfPeople.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public Person createPerson(Person person) {
        Person newPerson = Person.builder()
                .id(UUID.randomUUID().toString())
                .fullName(person.getFullName())
                .birthDate(person.getBirthDate())
                .age(person.getAge())
                .build();
        listOfPeople.add(newPerson);
        return person;
    }

    @Override
    public Person updatePerson(String id, Person person) {
        Optional<Person> findPerson = getPersonById(id);
        if (findPerson.isEmpty()) {
            throw new RuntimeException("Person not found");
        }
        listOfPeople.remove(findPerson.get());
        Person personUpdate = changePersom(person);
        listOfPeople.add(personUpdate);
        return personUpdate;
    }

    @Override
    public void deletePerson(String id) {
        listOfPeople.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst().ifPresent(listOfPeople::remove);
    }

    @Override
    public List<Person> getPeopleByName(String name) {
        return listOfPeople.stream()
                .filter(person -> person.getFullName().toLowerCase().contains(name.toLowerCase()))
                .toList();
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


    private Person changePersom(Person person){
        return Person.builder()
                .id(person.getId())
                .fullName(person.getFullName())
                .birthDate(person.getBirthDate())
                .age(person.getAge())
                .build();
    }
}
