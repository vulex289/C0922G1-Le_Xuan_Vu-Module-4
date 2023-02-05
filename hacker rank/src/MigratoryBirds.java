import java.util.*;

public class MigratoryBirds {
    public static void main(String[] args) {
        List<Integer>integers = new ArrayList<>();
        integers.add(1);
        integers.add(1);
        integers.add(2);
        integers.add(2);
        integers.add(3);
        System.out.println(migratoryBirds(integers));
    }
    public static int migratoryBirds(List<Integer> arr) {
        Set<Integer> integers = new TreeSet<>(arr);
        List<Integer> integers1 = new ArrayList<>(integers);
        int [] integers2 = new int[integers1.size()];
        for (int i = 0; i < integers1.size(); i++) {
            for (int j = 0; j < arr.size(); j++) {
                if (Objects.equals(integers1.get(i), arr.get(j))){
                    integers2[i]++;
                }
            }
        }
        int max = 0;
        int index =0;
        for (int i = 0; i < integers2.length; i++) {
            if (integers2[i]>max){
                max=integers2[i];
                index = i;
            }
        }
return integers1.get(index);
    }

}