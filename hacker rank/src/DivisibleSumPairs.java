import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DivisibleSumPairs {
    public static void main(String[] args) {
List<Integer>integers = new ArrayList<>();
integers.add(1);
integers.add(3);
integers.add(2);
integers.add(6);
integers.add(1);
integers.add(2);
        System.out.println(divisibleSumPairs(6,3,integers));
    }
    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        // Write your code here
        int count = 0;
        for (int i = 0; i < ar.size(); i++) {
            for (int j = i+1; j < ar.size(); j++) {
                if ((ar.get(i)+ar.get(j))%k==0){
                    count++;
                }
            }
        }
        return count;
    }
}
