package giaiThuat.hackerRank;

public class Kangaroo {
    public static void main(String[] args) {
        System.out.println(kangaroo(0,3,4,2));
    }
    public static String kangaroo(int x1, int v1, int x2, int v2) {
        // Write your code here
        String result = "No";
        if (x2>x1 && v2>v1 || x1>x2 && v1>v2){
             result = "No";
        }
        if (x1<x2) {
            while (x1 < x2) {
                x1 += v1;
                x2 += v2;
            }
            if (x2 == x1) {
                result = "Yes";
            }
        }
        if (x2<x1) {
            while (x2 < x1) {
                x1 += v1;
                x2 += v2;
            }
            if (x2 == x1) {
                result = "Yes";
            }
        }
return result;
    }
}
