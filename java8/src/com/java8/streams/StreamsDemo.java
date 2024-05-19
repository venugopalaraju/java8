package com.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsDemo {

    static class Person {
        String name;
        int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("venu",30),
                new Person("tom",34),
                new Person("sunny",30),
                new Person("Srinu",54),
                new Person("Bharathi",48),
                new Person("Raju",30));

        //print total of persons age whose age greater than 30
        int totalAge = people.stream().filter(person -> person.getAge()>30).map(Person::getAge).reduce(0,(total,age)->total+age);
        System.out.println(totalAge);
        //Print Person names
        people.stream().filter(person -> person.getAge()>30).map(Person::getName).forEach(System.out::println);
        //List the name whose age greater than 30
        List<String> personsGreaterThan30 = people.stream().filter(person -> person.getAge()>30).map(Person::getName).collect(Collectors.toList());
        System.out.println(personsGreaterThan30);
        //List To Map
        Map<String,Integer> peoplesMap = people.stream().collect(Collectors.toMap(Person::getName,Person::getAge));
        System.out.println(peoplesMap);
        //Joining
        String personNamesWithCommaSeparated = people.stream().map(Person::getName).map(String::toUpperCase).collect(Collectors.joining(","));
        System.out.println(personNamesWithCommaSeparated);
        //PartitioningBy
        Map<Boolean, List<Person>> partitionMap = people.stream().collect(Collectors.partitioningBy(person -> person.getAge() > 30));
        System.out.println(partitionMap);
        //GroupBy
        Map<Integer, List<Person>> groupByMap = people.stream().collect(Collectors.groupingBy(Person::getAge));
        //System.out.println(groupByMap);
        System.out.println("=================`");
        System.out.println(people.stream().collect(Collectors.groupingBy(Person::getName,Collectors.mapping(Person::getAge,Collectors.toList()))));
        //people.stream().sorted(Comparator.comparing(Person::getName)).forEach(System.out::println);
    }

}
