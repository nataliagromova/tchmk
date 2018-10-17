package forth;

import java.util.Scanner;

import static forth.Gauss.gauss;

/**
 * Created by NATA on 05.10.2018.
 */
public class Main {
    public static void main(String[] args) {
        int n,m;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n and m:");
        n=scanner.nextInt();
        m=scanner.nextInt();
        double[][] a = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scanner.nextDouble();
            }
        }
        System.out.println("Enter b(it should have "+ n+" elements):");
        double b[] = new double[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextDouble();
        }
        double[] v = gauss(a, b);
        for (int i = 0; i < v.length; i++) {
            System.out.println(v[i]);
        }
    }

}
