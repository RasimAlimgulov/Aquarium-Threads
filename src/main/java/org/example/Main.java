package org.example;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Aquarium aquarium=new Aquarium();
        Random random=new Random();
        int man_count=random.nextInt(5)+1;
        int woman_count=random.nextInt(5)+1;
        for (int i=1; i<=man_count;i++){
            aquarium.addFish(new Fish(Gender.MAN,"Рыбка мальчик "+i));
            System.out.println("Добавили Рыбка мальчик "+i );
        }

        for (int i=1; i<=woman_count;i++){
            aquarium.addFish(new Fish(Gender.WOMAN,"Рыба девочка "+i));
            System.out.println("Добавили Рыбку девочку "+i );
        }
        aquarium.startLife();
        new Thread(()->{
            while (true){
                aquarium.bornFish();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}