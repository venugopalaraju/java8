package com.java8.interfaces;

public class DefaultDemo implements Left,Right{

    @Override
    public void m1() {
        Left.super.m1();
    }

    public static void main(String[] args) {
        DefaultDemo defaultDemo = new DefaultDemo();
        defaultDemo.m1();
    }
}
