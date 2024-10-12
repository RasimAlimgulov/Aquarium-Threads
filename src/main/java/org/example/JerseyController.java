package org.example;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Random;

@Path("/aquarium")
public class JerseyController {

    private Aquarium aquarium = new Aquarium();

    @POST
    @Path("/start")
    @Produces(MediaType.TEXT_PLAIN)
    public Response startAquarium() {
        Random random = new Random();
        int manCount = random.nextInt(5) + 1;
        int womanCount = random.nextInt(5) + 1;

        for (int i = 1; i <= manCount; i++) {
            aquarium.addFish(new Fish(Gender.MAN, "fish men " + i));
            System.out.println("added fish men "+i );
        }

        for (int i = 1; i <= womanCount; i++) {
            aquarium.addFish(new Fish(Gender.WOMAN, "fish women " + i));
            System.out.println("added fish women "+i );
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

        return Response.ok("Аквариум запущен с " + manCount + " самцами и " + womanCount + " самками.").build();
    }


    }
