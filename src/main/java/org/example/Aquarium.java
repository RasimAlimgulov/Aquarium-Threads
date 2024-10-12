package org.example;

import java.util.*;
import java.util.concurrent.*;

public class Aquarium {
    int count =1;
    private Queue<Fish> fishes = new ConcurrentLinkedQueue<>();
    private Random random=new Random();
    private ExecutorService service;
    public void addFish(Fish fish){
        fishes.add(fish);
    }

    public void startLife(){
        service=Executors.newCachedThreadPool();
        for (Fish fish: fishes){
            service.submit(fish);
        }
    }

    public void bornFish(){
        Fish man=null;
        Fish woman=null;

        for (Fish ob: fishes){
            if (ob.getGender().equals(Gender.MAN)){
                man=ob;
            }
            else {
                woman=ob;
            }

        if (man!=null && woman!=null){
               Gender gender=random.nextBoolean()?Gender.MAN:Gender.WOMAN;
               Fish fish=new Fish(gender, "child "+count);
               addFish(fish);
               service.submit(fish);
            System.out.println("Born "+fish.getName()+" " + fish.getGender());
           count++;
            man=null;
           woman=null;
        }
        }
    }

}
