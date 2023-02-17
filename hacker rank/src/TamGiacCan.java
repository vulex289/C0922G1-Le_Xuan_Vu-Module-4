import java.util.Scanner;

public class TamGiacCan {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào chiều cao : ");
        int height = Integer.parseInt(sc.nextLine());
        int n = height / 2;
        System.out.println(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (i > 1 && j % i != 0) {
                    System.out.print(" ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.print("\n");
        }
        for (int e = n-1; e >= 1; e--) {
            for (int f = e; f >= 0; f--) {
                if (f == 1 || f == e) {
                    System.out.print("* ");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }
}



