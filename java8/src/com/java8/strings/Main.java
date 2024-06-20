package com.java8.strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        String string = "venu gopala raju";
        System.out.println(findLongestWordInString(string));
        System.out.println(countTheFrequencyOfEachCharacter(string));
        System.out.println(findMaxOccurenceOfEachCharacter(string));
        System.out.println(reverseEachWordInString(string));
        System.out.println(removeDuplicateCharacters(string));
        System.out.println(isAnagram("silent","listen"));
        System.out.println(convertSentenceToTitleCase(string));
        System.out.println(findTheMostFrequestWordInString("venu gopala gopala"+string));
        System.out.println(removeAllVowelsFromString(string));
        System.out.println(isNumeric("123"));
        System.out.println(countWords(string));
        System.out.println(countVowels(string));
        System.out.println(countConsonents(string));
        System.out.println(findShortestWord(string));
        System.out.println(toUppercase(string));
        System.out.println(removeSpaces(string));
        System.out.println(checkPalindrome("mtm"));
        System.out.println();
    }

    private static boolean checkPalindrome(String string) {
        return IntStream.range(0,string.length()/2).allMatch(i->string.charAt(i)==string.charAt(string.length()-1-i));
    }

    private static String removeSpaces(String string) {
        return string.chars()
                .mapToObj(c->(char)c)
                .filter(c->!Character.isWhitespace(c))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private static String toUppercase(String string) {
        return string.chars()
                .mapToObj(c->(char)c)
                .map(Character::toUpperCase)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private static String findShortestWord(String string) {
        return Arrays.asList(string.split(" "))
                .stream()
                .min(Comparator.comparing(String::length))
                .orElse("");
    }

    private static long countConsonents(String string) {
        return string.chars()
                .filter(c -> "AEIOUaeiou".indexOf(c) == -1)
                .count();
    }

    private static long countVowels(String string) {
        return string.chars()
                .filter(c -> "AEIOUaeiou".indexOf(c) != -1)
                .count();
    }

    private static int countWords(String string) {
        return string.split(" ").length;
    }

    private static boolean isNumeric(String s) {
        return s.chars()
                .allMatch(Character::isDigit);
    }

    private static String removeAllVowelsFromString(String string) {
        return string.chars()
                .mapToObj(c -> (char)c)
                .filter(c -> "AEIOUaeiou".indexOf(c)==-1)
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }

    private static String findTheMostFrequestWordInString(String s) {
        return Arrays.asList(s.split(" "))
                .stream()
                .collect(Collectors.groupingBy(w->w,Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");
    }

    private static String convertSentenceToTitleCase(String string) {
        return Arrays.asList(string.split(" "))
                .stream()
                .map(word -> word.substring(0,1).toUpperCase()+word.substring(1))
                .collect(Collectors.joining(" "));
    }

    private static boolean isAnagram(String s1, String s2) {
        return s1.chars().sorted().boxed().collect(Collectors.toList())
                .equals(s2.chars().sorted().boxed().collect(Collectors.toList()));
    }

    private static String removeDuplicateCharacters(String string) {
        return string.chars()
                .distinct()
                .mapToObj(c->String.valueOf((char)c))
                .collect(Collectors.joining(""));
    }

    private static String reverseEachWordInString(String string) {
        return Arrays.asList(string.split(" "))
                .stream()
                .map(s -> new StringBuffer(s).reverse().toString())
                .collect(Collectors.joining(" "));
    }

    private static Character findMaxOccurenceOfEachCharacter(String string) {
        return string.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(c->c,Collectors.counting()))
                .entrySet()
                .stream().max(Comparator.comparing(Map.Entry::getValue))
                .get()
                .getKey();
    }
    private static Map<Character,Long> countTheFrequencyOfEachCharacter(String string) {
        return string.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(c->c,Collectors.counting()));
    }

    private static String findLongestWordInString(String string) {
        return Arrays.asList(string.split(" "))
                .stream()
                .max(Comparator.comparing(String::length))
                .get();
    }
}
