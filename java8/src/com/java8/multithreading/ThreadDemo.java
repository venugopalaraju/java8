package com.java8.multithreading;

import java.util.concurrent.Callable;

public class ThreadDemo {
     static class Thread1 extends Thread {

         @Override
         public void run() {
             for (int i=0;i<10;i++){
                 System.out.println("Thread class Child Thread"+i);
             }
         }
     }

     static class Thread2 implements Runnable {

         @Override
         public void run() {
             for (int i=0;i<10;i++){
                 System.out.println("Runnable Child Thread"+i);
             }
         }
     }

     static class Thread3 implements Callable{

         @Override
         public Object call() throws Exception {
             for (int i=0;i<10;i++){
                 System.out.println("Callable Child Thread"+i);
             }
             return "call Thread Executed Successfully";
         }
     }

    public static void main(String[] args) throws Exception {
        Thread1 t = new Thread1();
        t.start();
        Thread2 t2 = new Thread2();
        t2.run();
         for (int i=0;i<10;i++){
             System.out.println("Main Thread"+i);
         }
        Thread3 t3 = new Thread3();
        String s = (String) t3.call();
        System.out.println(s);
    }
}
