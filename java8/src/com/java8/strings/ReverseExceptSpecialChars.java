package com.java8.strings;

public class ReverseExceptSpecialChars {
    public static void main(String[] args) {
        System.out.println("/sdd*rr% after reversed "+reverseExceptSpecialChars("/sdd*rr%6"));
    }

    private static String reverseExceptSpecialChars(String s) {
        char[] chars = s.toCharArray();
        int i=0;
        int j=chars.length-1;
        while(i<j){
            if((int)chars[i]<65||(int)chars[i]>117){
                i++;
            }else if((int)chars[j]<65||(int)chars[j]>117){
                j--;
            }else{
                char c = chars[i];
                chars[i]=chars[j];
                chars[j]=c;
                i++;
                j--;
            }
        }
        return  String.valueOf(chars);
    }
}
