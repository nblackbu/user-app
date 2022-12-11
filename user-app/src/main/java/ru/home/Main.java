package ru.home;

import ru.home.controller.UserController;
import ru.home.controller.UserControllerImpl;
import ru.home.dao.UserDaoImpl;
import ru.home.model.User;
import ru.home.service.UserServiceImpl;
import ru.home.ui.WebUserInterface;

import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        WebUserInterface webUserInterface = new WebUserInterface();
        System.out.println(webUserInterface.getUser(7L));
    }
}