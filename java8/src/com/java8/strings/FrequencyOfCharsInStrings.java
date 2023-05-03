package com.java8.strings;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

//Check if frequency of character in one string is a factor or multiple of frequency of same character in other string
public class FrequencyOfCharsInStrings {
    public static void main(String[] args) {
        System.out.println(isFrequencyOfCharsInStringsAreEquals("aabccd","bbbaaaacc"));
        System.out.println(isFrequencyOfCharsInStringsAreEquals("hhdwjwqq","qwjdddhhh"));
    }

    private static String isFrequencyOfCharsInStringsAreEquals(String s, String s1) {
        Function<String,Map<String,Integer>> charMapByFrequency = string -> Stream.of(string.split("")).collect(groupingBy(e->e,collectingAndThen(counting(), Long::intValue)));
        Map<String,Integer> string1 = charMapByFrequency.apply(s);
        Map<String,Integer> string2 = charMapByFrequency.apply(s1);
        return string1.entrySet().stream().allMatch(e-> (null==string2.get(e.getKey())) || (string2.get(e.getKey())%(e.getValue())==0 || e.getValue()%string2.get(e.getKey())==0)) ? "YES" : "NO";
    }
}
