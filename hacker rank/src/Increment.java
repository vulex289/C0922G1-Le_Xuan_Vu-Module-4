package giaiThuat.hackerRank;

import java.util.ArrayList;
import java.util.List;

public class Increment {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
//        arr.add(9);
//        arr.add(8);
//        arr.add(9);
//        arr.add(10);
        arr.add(1);
        arr.add(2);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        System.out.println(modifySequence(arr));
    }

    public static int modifySequence(List<Integer> arr) {
        // Write your code here
        int count = 0;
        int x = 0;
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) - arr.get(i - 1) < 1) {
                x = arr.get(i);
                count = 1;
                break;
            }
        }
            for (int j = x; j < arr.size(); j++) {
                if (arr.get(j) - x < j - 1) {
                    count++;
                }
            }

        return count;
    }
}
