package com.example.musa;

import com.example.musa.model.Person;
import com.example.musa.repository.PersonRepository;
import com.example.musa.util.PersonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class App {
    private final PersonRepository personRepository;

    private final PersonUtil personUtil;
    @Autowired
    public App(PersonRepository personRepository, PersonUtil personUtil) {
        this.personRepository = personRepository;
        this.personUtil = personUtil;
    }
    public void start(){
      savePersonInDatabase();
        List<Person> personList = personRepository.findAll();
        System.out.println("Average size: " + personUtil.getAverageSize(personList));
        System.out.println("Max size: \n" + personUtil.findPersonWithMaxSize(personList));
        System.out.println("Sorted list: \n" + personUtil.sortBySize(personList));
    }

    public void savePersonInDatabase(){
        Person person1 = Person.builder().name("Vasya").surName("Some").lastName("S").size(23).age(45).build();
        Person person2 = Person.builder().name("Vasya1").surName("Some1").lastName("S1").size(13).age(49).build();
        Person person3 = Person.builder().name("Vasya2").surName("Some2").lastName("S2").size(233).age(15).build();
        Person person4 = Person.builder().name("Vasya3").surName("Some3").lastName("S3").size(2321).age(35).build();
        personRepository.save(person1);
        personRepository.save(person2);
        personRepository.save(person3);
        personRepository.save(person4);
        personRepository.flush();
    }
}
