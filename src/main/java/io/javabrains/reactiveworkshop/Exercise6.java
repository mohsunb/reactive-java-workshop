package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.time.Duration;

public class Exercise6 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.unresponsiveFlux() and ReactiveSources.unresponsiveMono()

        System.out.println("Waiting 5 seconds for the String variable:");
        // Get the value from the Mono into a String variable but give up after 5 seconds
        String variable = ReactiveSources.unresponsiveMono().block(Duration.ofSeconds(5));
        System.out.printf("Gave up after 5 seconds; String: %s\n", variable);

        // Get the value from unresponsiveFlux into a String list but give up after 5 seconds
        // Come back and do this when you've learnt about operators!
        // TODO: Write code here

        System.out.println("Press a key to end");
        System.in.read();
    }

}
