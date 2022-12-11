package ru.home.model;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class User {
    private final Long id;
    private final String name;
    private final Set<String> citiesLived;
    private final Set<String> citiesWorked;

    //request
    public User(String name, Set<String> citiesLive, Set<String> citiesWork) {
        this(null, name, citiesLive, citiesWork);
    }

    //response
    public User(Long id, String name, Set<String> citiesLived, Set<String> citiesWorked) {
        this.id = id;
        this.name = Objects.requireNonNull(name);
        this.citiesLived = Objects.requireNonNull(citiesLived);
        this.citiesWorked = Objects.requireNonNull(citiesWorked);
    }

    public Optional<Long> getId() {
        return Optional.ofNullable(id);
    }

    public String getName() {
        return name;
    }

    public Set<String> getCitiesLived() {
        return citiesLived;
    }

    public Set<String> getCitiesWorked() {
        return citiesWorked;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + citiesLived +
                ", work=" + citiesWorked +
                '}';
    }
}
