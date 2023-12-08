package com.example.performanceopt.memoryleak;

public class OutterClass {
    private String name;

    class Inner{
        public void list(){
            System.out.println("outter name is " + name);
        }
    }
}
