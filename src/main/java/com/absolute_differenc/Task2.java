package com.absolute_differenc;

public class Task2 {
    public static void main(String[] args) {
        System.out.println(two_strings1("Hallo", "World"));
        System.out.println(two_strings1("Hi", "World"));
        System.out.println("-----------------------SecondTest-----------------------");
        System.out.println(two_strings2("Hallo", "World"));
        System.out.println(two_strings2("Hi", "World"));
    }


    public static boolean two_strings1(String s1, String s2) {

        for (int i = 0; i < s2.length(); i++) {

            if (s1.contains(Character.toString(s2.toCharArray()[i]))) {
                return true;
            }

        }
        return false;

        //  another solution
    } public static boolean two_strings2(String s1, String s2) {

        for (int i = 0; i < s2.length(); i++) {

            if (s1.indexOf(s2.toCharArray()[i])!= -1){
                return true;
            }
        }
        return false;

    }
}