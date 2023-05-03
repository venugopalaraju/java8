package com.java8.multithreading;

public class ExecuteChildThreadAfterMainThread {
    static class ChildThread extends Thread {
        static Thread mainThread;

        @Override
        public void run(){
            try {
                mainThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i=0;i<5;i++){
                System.out.println("Child Thread "+i);
            }
        }

        public static void main(String[] args) {
            ChildThread.mainThread = Thread.currentThread();
            ChildThread childThread = new ChildThread();
            childThread.start();
            for (int i=0;i<5;i++){
                System.out.println("Main Thread "+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
