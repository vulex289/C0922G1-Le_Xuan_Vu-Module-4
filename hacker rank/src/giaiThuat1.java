package giaiThuat;

import java.util.Arrays;
import java.util.Scanner;

public class giaiThuat1 {
    public static void main(String[] args) {
        int []arr={8, 7,3, 2, 5, 1,5};
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập vào một số");
        int num=sc.nextInt();

        int size1=arr.length;
        for(int i=0;i<size1;i++) {
            for (int j = i+1; j < size1; j++) {
                    if (arr[i] + arr[j] == num) {
                        System.out.println("["+arr[i] + "]" +"["+ arr[j]+"]");
                    }
            }
        }
    }
}
