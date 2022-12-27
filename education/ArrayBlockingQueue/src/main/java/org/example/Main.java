package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {
        public static void main(String[] args) {

            // класс полезен для ограничения очереди и многопоточности
            Person person1 = new Person(17);
            Person person2 = new Person(4);
            Person person3 = new Person(6);

            Queue<Person> people = new ArrayBlockingQueue<Person>(10);

            people.add(person2);
            people.add(person1);
            people.add(person3);

            System.out.println(people.remove());
            // peek - метод для того, чтобы посмотреть на 1-ый элемент в очереди и не удалять его
            System.out.println(people.peek());

            // throw exceptions: add - remove - elments (в случае ошибки - исключения)
            // returns special value: offer - pool - peek (в случае ошибки - спец значения)
        }
    }

    class Person {
        int id;

        public Person(int id) {
            this.id = id;
        }
    }