import java.util.ArrayList;
import java.util.List;

public class SubarrayDivision {
    public static void main(String[] args) {
List<Integer>list=new ArrayList<>();
//list.add(2);
//list.add(5);
//list.add(1);
//list.add(3);
//list.add(4);
//list.add(4);
//list.add(3);
//list.add(5);
//list.add(1);
//list.add(1);
//list.add(2);
//list.add(1);
//list.add(4);
//list.add(1);
//list.add(3);
//list.add(3);
//list.add(4);
//list.add(2);
list.add(4);
//        list.add(5);
//        list.add(2);
//        list.add(2);
//        list.add(1);
//        list.add(5);
//        list.add(3);
//        list.add(2);
        System.out.println(birthday(list,4,1));
    }
    public static int birthday(List<Integer> s, int d, int m) {
        // Write your code here
        int count =0;
        int countA=0;
        for (int i=0;i<=s.size()-m;i++){
            for (int j = i; j < m+i; j++) {

                countA+=s.get(j) ;
            }
            if (countA==d){
                count++;
            }
            countA=0;
            }

return count;
    }
}
