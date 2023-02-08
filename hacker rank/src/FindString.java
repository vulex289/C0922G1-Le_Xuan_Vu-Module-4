package giaiThuat;

import java.util.*;

public class FindString {
    public static void main(String[] args) {
        // strs = ["flower","flow","flight"]
        //Viết hàm tìm chuỗi tiền tố chung dài nhất trong một mảng các chuỗi.
        //Nếu không có tiền tố chung, hãy trả về một chuỗi trống
//        String[] arr = {"flower", "flow", "flight"};
        String a = "abcdbcef";
//        for (int i = 0; i < arr.length; i++) {
//            a += arr[i];
//        }
        String[] line = a.split("");
        Map<String, Integer> map = new LinkedHashMap<>();
        int count[] = new int[128];
        int countS = 0;
        for (int i = 0; i < line.length; i++) {
            if (map.containsKey(line[i])) {
                count[a.codePointAt(i)]++;
            } else {
                count[a.codePointAt(i)] = 1;
            }
            map.put(line[i], count[a.codePointAt(i)]);
        }
        String[] arrB = new String[2];
        int i = 0;
        while (i < 2) {
            for (Map.Entry m : map.entrySet()) {
                if (m.getValue().equals(1)) {
                    countS++;
                } else {
                    arrB[i] = (String) m.getKey();
                    i++;
                }
            }
        }
        if (countS == 3) {
            System.out.println(Arrays.toString(arrB));
        }
        else {
            System.out.println(Arrays.toString(arrB));
        }
        System.out.println(countS);
    }
}
