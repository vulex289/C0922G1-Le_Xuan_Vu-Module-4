package giaiThuat.hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BreakingRecord {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(4);
        a.add(21);
        a.add(36);
        a.add(10);
        a.add(28);
        a.add(35);
        a.add(5);
        a.add(24);
        a.add(42);
        int ar[]  = new int[a.size()];
        for (int i = 0; i <a.size() ; i++) {
            ar[i] = a.get(i);
        }
        System.out.println(Arrays.toString(ar));
        System.out.println(breakingRecords(a));
    }
    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Write your code here
List<Integer> ac = new ArrayList<>();
int max = scores.get(0);
int countMax = 0;
int countMin = 0;
int min = scores.get(0);
        for (int i = 0; i <scores.size() ; i++) {
            if (scores.get(i)< min){
                min = scores.get(i);
                countMin++;
            }
            if (scores.get(i)> max){
                max = scores.get(i);
                countMax++;
            }
        }
        ac.add(countMax);
        ac.add(countMin);
return ac;
    }
}
