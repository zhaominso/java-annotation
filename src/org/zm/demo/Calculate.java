package org.zm.demo;

public class Calculate {

    private int a;
    private int b;

    public Calculate(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Color(colors = {"red","blue"},num = 3)
    @MyTest
    public int add() {
        return a + b;
    }

    @MyTest
    public int subtract() {
        return a - b;
    }

    @MyTest
    public int multiply() {
        return a * b;
    }

    @MyTest
    public int divide() {
        return a / b;
    }
}
