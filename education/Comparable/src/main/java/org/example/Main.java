package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Person> peopleList = new ArrayList<>();
        Set<Person> peopleSet = new TreeSet<>();

        addElements(peopleList);
        addElements(peopleSet);

        Collections.sort(peopleList);
        System.out.println(peopleList);
    }

    private static void addElements (Collection collection) {
        collection.add(new Person(2, "Bob"));
        collection.add(new Person(1, "Tomm"));
        collection.add(new Person(1, "Stasya"));
    }
}

class Person implements Comparable<Person> {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
//создаем свою сортировку для объектов в compareTo
    @Override
    public int compareTo(Person o) {
        if (this.name.length() > o.getName().length()) {
            return 1;
        }
        else if (this.name.length() < o.getName().length()) {
            return -1;
        }
        else return 0;
    }
}