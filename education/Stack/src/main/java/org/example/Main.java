package org.example;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        //LIFO
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(3);
        stack.push(1);

        System.out.println(stack.peek());
        System.out.println(stack.pop()); //pop - удаляет
        System.out.println(stack);


    }
}