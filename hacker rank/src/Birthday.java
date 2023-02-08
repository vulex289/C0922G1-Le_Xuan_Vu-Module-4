package giaiThuat.hackerRank;

import java.util.ArrayList;
import java.util.List;

public class Birthday {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(4);
        a.add(1);
        a.add(1);
        a.add(2);
        a.add(1);
        int array[] = {1,4,1,1,2,1};
        System.out.println(array[6]);
        System.out.println(birthday(a,4,3));

    }
    public static int birthday(List<Integer> s, int d, int m) {
        // Write your code here
    int count = 0;
        for (int i = m-1; i <s.size() ; i++) {
            if (s.get(i)+s.get(i-1)+s.get(i-2) == d){
                count ++;
            }
        }
    return count;
    }
}
