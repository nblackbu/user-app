package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        // before Java 5. Курсор итератора указывает на пространство до 1-го объекта
//        Iterator<Integer> iterator = list.listIterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        int idX = 0;
        // если хотим в момент итерирования по листу удалять элементы. в foreach такое сделать нельзя
        Iterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            if (idX == 1) {
            iterator.remove();}
            System.out.println(iterator.next());
            idX++;
        }

        // after Java 5
        for (int x : list) {
            System.out.println(x);
        }
    }
}