package giaiThuat.hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetTotalX {
    public static void main(String[] args) {
    List<Integer> a = new ArrayList<>();
    List<Integer> b = new ArrayList<>();
    a.add(1);
//    a.add(6);
//    b.add(16);
//    b.add(72);
    b.add(100);
        System.out.println(getTotalX(a,b));

    }
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        int max = 0;
        for (int i = 0; i <a.size() ; i++) {
            if (a.get(i)>max){
                max = a.get(i);
            }
        }
        int count = 0;
        List<Integer>c = new ArrayList<>();
        for (int i = 1; i <=100 ; i++) {
            for (int j = 0; j < a.size(); j++) {
                if ((max*i) % (a.get(j)) == 0){
                    count ++;
                }
            }
            if (count == a.size()){
                c.add((max*i));
            }
            count = 0;
        }
        int countS = 0;
        for (int i = 0; i < c.size(); i++) {
            for (int j = 0; j < b.size(); j++) {
                if (b.get(j) % c.get(i) == 0){
                    count ++;
                }
            }
            if (count == b.size()){
                countS ++;
            }
            count = 0;
        }
        return countS;
    }
}
