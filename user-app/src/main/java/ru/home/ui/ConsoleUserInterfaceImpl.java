package ru.home.ui;

import ru.home.controller.UserController;
import ru.home.controller.UserControllerImpl;
import ru.home.model.User;
import ru.home.service.UserServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class ConsoleUserInterfaceImpl {
    public void start() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Привет, введи свою первую команду");
            String command = "";
            UserController request = new UserControllerImpl(new UserServiceImpl());
            Long userId;
            User user;

            while (!(command = bufferedReader.readLine()).equals("exit")) {
                switch (command) {
                    case "help":
                        System.out.println("1 - createUser");
                        System.out.println("2 - getUser by ID");
                        System.out.println("3 - getAllUsers");
                        break;
                    case "1":
                        System.out.println("Create user and enter user name, user city live and user city work");
                        String name = bufferedReader.readLine();
                        Set<String> citiesLive = addCitiesToSet();
                        Set<String> citiesWork = addCitiesToSet();
                        userId = request.createUser(name, citiesLive, citiesWork);
                        System.out.println(userId);
                        break;
                    case "2":
                        System.out.println("Get User and enter ID user");
                        userId = Long.parseLong(bufferedReader.readLine());
                        user = request.getUser(userId);
                        System.out.println(user);
                        break;
                    case "3":
                        System.out.println("Get all user");
                        request.getAllUsers().forEach(System.out::println);
                        break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Set<String> addCitiesToSet() {

        Set<String> cities = new HashSet<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Привет, введи название города, когда закончишь - введи exit");
            String city;
            while (!(city = bufferedReader.readLine()).equals("exit")) {
                cities.add(city);
            }
            return cities;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cities;
    }
}
