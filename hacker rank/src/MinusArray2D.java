package giaiThuat;

import sun.plugin.javascript.navig.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MinusArray2D {
    public static void main(String[] args) {
        List<Integer>arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        List<Integer>arr2 = new ArrayList<>();
        arr2.add(2);
        arr2.add(4);
        arr2.add(5);
        List<Integer>arr3 = new ArrayList<>();
        arr3.add(2);
        arr3.add(4);
        arr3.add(5);
    List<List<Integer>>arr  = new ArrayList<>();
    arr.add(arr1);
    arr.add(arr2);
    arr.add(arr3);
        System.out.println(diagonalDifference(arr));
    }
    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int sum1 = 0;
        int sum2 = 0;
        int minus = 0;

        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).size(); j++) {
                if (i == j) {
                    sum1+=(arr.get(i).get(j)) ;
                }
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).size(); j++) {
                if (i + j == arr.size()-1) {
                    sum2+=(arr.get(i).get(j)) ;
                }
            }
        }
        minus = Math.abs(sum1-sum2);
        return minus;
    }

}
