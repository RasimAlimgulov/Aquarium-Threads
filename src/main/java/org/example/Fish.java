package org.example;

import java.util.Random;

public class Fish implements Runnable{
    private Gender gender;
    private String name;
    private int lifetime;
    private Random random=new Random();

    public Fish(Gender gender, String name) {
        this.gender = gender;
        this.name = name;
        this.lifetime=random.nextInt(10)+1;
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(lifetime*1000);
            System.out.println(name+" dead");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
