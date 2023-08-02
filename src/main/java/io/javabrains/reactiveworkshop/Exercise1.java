package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream()
                .forEach(System.out::println);
        System.out.println("=".repeat(40));

        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream()
                .filter(i -> i < 5)
                .forEach(System.out::println);
        System.out.println("=".repeat(40));

        // Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumbersStream()
                .filter(i -> i > 5)
                .skip(1)
                .limit(2)
                .forEach(System.out::println);
        System.out.println("=".repeat(40));

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        System.out.println(StreamSources.intNumbersStream()
                .filter(i -> i > 5)
                .findFirst()
                .orElse(-1));
        System.out.println("=".repeat(40));

        // Print first names of all users in userStream
        StreamSources.userStream()
                .forEach(user -> System.out.println(user.getFirstName()));
        System.out.println("=".repeat(40));

        // Print first names in userStream for users that have IDs from number stream
        StreamSources.userStream()
                .filter(user -> StreamSources.intNumbersStream().toList().contains(user.getId()))
                .forEach(user -> System.out.println(user.getFirstName()));
        System.out.println("=".repeat(40));

    }

}
