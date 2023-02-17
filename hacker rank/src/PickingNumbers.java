import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PickingNumbers {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(4);
        a.add(4);
        a.add(4);
        a.add(4);
        a.add(4);
//    a.add(5);
//    a.add(5);
//    a.add(5);
        System.out.println(pickingNumbers(a));
    }

    public static int pickingNumbers(List<Integer> a) {
        Set<Integer> set = new TreeSet<>(a);
        List<Integer> list = new ArrayList<>(set);
        if (list.size() == 1) {
            return a.size();
        }
        int countA = 0;
        int max = 0;
        for (int k = 0; k < list.size(); k++) {
            if (max <= countA) {
                max = countA;
            }
            countA = 0;
            for (int j = 0; j < a.size() - 1; j++) {
                if (list.get(k) - a.get(j) == 1 || list.get(k) - a.get(j) == 0) {
                    countA++;
                }
            }
        }
        return max;
    }
}
