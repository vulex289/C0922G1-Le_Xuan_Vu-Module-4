import java.util.*;

public class SalesByMatch {
    public static void main(String[] args) {
List<Integer>integers=new ArrayList<>();
integers.add(1);
integers.add(2);
integers.add(1);
integers.add(2);
integers.add(1);
integers.add(3);
integers.add(2);
        System.out.println(sockMerchant(integers.size(),integers));
    }
    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        int count =0;
        int result=0;
        Set<Integer>integers=new TreeSet<>(ar);
        List<Integer>integers1=new ArrayList<>(integers);
        for (int i = 0; i < integers1.size(); i++) {
            for (int j = 0; j < ar.size(); j++) {
                if (Objects.equals(integers1.get(i), ar.get(j))) {
                    count++;
                }
            }
            result += count / 2;
            count=0;
        }

        return result;
    }
}
