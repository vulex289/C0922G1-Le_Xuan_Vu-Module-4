import java.util.ArrayList;
import java.util.List;

public class BillDivision {
    public static void main(String[] args) {
List<Integer>integers=new ArrayList<>();
integers.add(3);
integers.add(10);
integers.add(2);
integers.add(9);
bonAppetit(integers,1,12);
    }
    public static void bonAppetit(List<Integer> bill, int k, int b) {
        // Write your code here
    int result=0;
        for (int i = 0; i <bill.size() ; i++) {
            result+=bill.get(i);
        }
        int result1=(result-bill.get(k))/2;
        if (result1==b){
            System.out.println("Bon Appetit");

        }
        else {
            System.out.println(b-result1);
        }
    }
}
