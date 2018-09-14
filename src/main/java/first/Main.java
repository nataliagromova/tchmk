package first;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Find GCD of 2 numbers enter 1");
        System.out.println("Make compare enter 2");
        while (true) {
            System.out.println("For exit enter 0");
            if (scanner.nextInt() == 1) {
                System.out.println("Enter two numbers:");
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                System.out.println("Here we have 3 types of Euclidean algorithm output including simple,extended and binary version: ");
                System.out.println(Euclid.EuclidGCD(a, b));
                System.out.println(Euclid.EulcidEXT(a, b));
                System.out.println(Euclid.EuclidBIN(a, b));
            } else if (scanner.nextInt() == 2) {
                System.out.println("For compare enter k-number of moduli(not 0) then a1...ak-resudies and them m1...mk-moduli:");
                System.out.println("Enter k");
                int k = scanner.nextInt();
                int[] a = new int[k];
                int[] m = new int[k];
                System.out.println("Enter a1..ak");
                for (int i = 0; i < k; i++) {
                    a[i] = scanner.nextInt();
                }
                System.out.println("Enter m1...mk");
                for (int i = 0; i < k; i++) {
                    m[i] = scanner.nextInt();
                }
                System.out.println("Here we have 2 output. The first one is Chinese Reminders Theorem and another is Garner's algorithm:");
                System.out.println(Comparisons.ChineseTheorem(k, a, m));
                System.out.println(Comparisons.GarnerMethod(k, a, m));
            }
            else if (scanner.nextInt()==0)
                return;
            else System.out.println("Error.Try another command:)");
        }
    }
}
