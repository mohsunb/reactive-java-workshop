package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        ReactiveSources.intNumbersFluxWithException()
                .subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Complete"));
        ReactiveSources.intNumbersFlux()
                .subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Complete"));

        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.intNumbersFlux().subscribe(new MyCustomSubscriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }

}

class MyCustomSubscriber<T> extends BaseSubscriber<T> {
    @Override
    public void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscribed; " + subscription.toString());
        request(1);
    }

    @Override
    public void hookOnNext(T value) {
        System.out.println("Received: " + value.toString());
        request(1);
    }
}
