package test;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum = 0;
        int a = in.nextInt();
        if (a == 1) {
            System.out.println(0);
        } else {
            for (int j = 2; j <= a; j++) {
                int temp = 1;
                for (int i = 1; i <= a; i++) {
                temp = (temp * 25) % 1000000007;
                temp=(temp*26*(i+1)*i)%1000000007;
                sum=(sum+temp)%1000000007;
                }
                System.out.println(sum);
            }
        }
    }
}
