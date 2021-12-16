package com.absolute_differenc;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        Integer[] indexes = getInputFromUser();
        Arrays.sort(indexes);
        System.out.println("Array after sorting ");
        for (Integer integer : indexes
        ) {
            System.out.println(integer);
        }
        System.out.println("The Minimum absolute Difference  is :" + findMinimumDifference(indexes));
    }

    public static Integer findMinimumDifference(Integer[] input) {
        int diff = 0;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < input.length - 1; i++) {
            diff = Math.abs(input[i + 1] - input[i]);
            if (minDiff > diff) {
                minDiff = diff;
            }
        }
        return minDiff;
    }

    public static Integer[] getInputFromUser() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\\s");
        System.out.println("Please Enter The Size of The Array");
        int size = scanner.nextInt();
        Integer[] indexes = new Integer[size];
        System.out.println("Please Enter your values with space between every two numbers");
        for (int i = 0; i < size; i++) {
            indexes[i] = scanner.nextInt();
        }
        return indexes;
    }


}
