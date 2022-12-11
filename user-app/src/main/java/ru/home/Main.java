package ru.home;

import ru.home.ui.WebUserInterfaceImpl;

public class Main {
    public static void main(String[] args) {
        WebUserInterfaceImpl webUserInterface = new WebUserInterfaceImpl();
        System.out.println(webUserInterface.getUser(7L));
    }
}