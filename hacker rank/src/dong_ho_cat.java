package giaiThuat.hackerRank;

import java.util.Scanner;

public class dong_ho_cat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào chiều cao : ");
        int height = Integer.parseInt(sc.nextLine());
        int n=height/2;
        for (int i = n; i >= 1; i--) {
            for (int space = 1; space <= n - i; ++space) {
                    System.out.print("  ");
            }
            for (int j = i; j <= 2 * i; j++) {
                    System.out.print("* ");

            }
            for(int j = 0; j < i - 1; j++) {
                System.out.print("* ");
            }
                System.out.println();
            }
        for (int i = 1; i <= n; i++) {
            for (int space = 0; space <n-i; space++) {
                System.out.print("  ");
            }
            for (int j = i; j <2*i ; j++) {
                System.out.print("* ");
            }
            for(int j = 0; j <= i - 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        }
    }

