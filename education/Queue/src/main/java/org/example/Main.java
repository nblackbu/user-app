package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        //FIFO
        Person person1 = new Person(17);
        Person person2 = new Person(4);
        Person person3 = new Person(6);

        Queue<Person> people = new LinkedList<Person>();

        people.add(person2);
        people.add(person1);
        people.add(person3);

        for (Person person : people) {
            System.out.println(person);
        }
    }
}

class Person {
    int id;

    public Person(int id) {
        this.id = id;
    }
}