package com.java8.optional;

import com.java8.optional.Book;
import com.java8.optional.Chapter;
import com.java8.optional.Customer;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {
        Customer customer = new Customer(101, "Venu", null, Arrays.asList("12345", "34567"));

        //throws NPE if customer.getEmail() is null
        /*Optional<String> email = Optional.of(customer.getEmail());
        System.out.println(email);*/

        //returns value else Optional.empty
        Optional<String> OptionalOfNullableEmail1 = Optional.ofNullable(customer.getEmail());
        System.out.println(OptionalOfNullableEmail1);

        //return default If value not found
        Optional<String> defaultEmail = Optional.ofNullable(customer.getEmail());
        System.out.println(defaultEmail.orElse("Venu@gmail.com"));


        Optional<String> email = Optional.ofNullable(customer.getEmail());
        //return default value If value not found
        System.out.println(email.orElseGet(() -> "venu@gmail.com"));
        //throw exception If value not found
        /*String result = email.orElseThrow();
        System.out.println(result);*/

        List<Chapter> chapters = Arrays.asList(new Chapter("first"),new Chapter("two"));
        Book book = new Book(chapters);
        try {
            String summery = getSummary(book,0);
            System.out.println(summery);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static String getSummary(Book book, int index) throws Exception {
        return Optional.ofNullable(book).orElseThrow().getChapter(index).orElseThrow().getSummery().toUpperCase();
    }
}
