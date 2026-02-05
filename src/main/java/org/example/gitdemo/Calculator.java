package org.example.gitdemo;

public class Calculator {

    public static int add(int a, int b) {
        return a + b;
    }
    public static int add(int a, int b, int c) {
        return a + b + c;
    }

//    public static int add(int... numbers){
//
//    }

    public static float div(int a, int b){
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return (float) a / b;
    }
}
