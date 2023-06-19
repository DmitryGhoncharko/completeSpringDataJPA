package com.example.musa.util;

import com.example.musa.model.Person;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class PersonUtil {
    public Person findPersonWithMaxSize(List<Person> personList) {
        personList.sort(Comparator.comparingInt(Person::getSize));
        return personList.get(0);
    }

    public int getAverageSize(List<Person> personList) {
      List<Person> personList1 = personList.stream().filter(x->x.getAge()>40).toList();
     int allSize = personList1.stream().mapToInt(Person::getSize).sum();
     return allSize/personList1.size();
    }

    public List<Person> sortBySize(List<Person> personList){
        personList.sort(Comparator.comparing(Person::getSize));
        return personList;
    }

}
