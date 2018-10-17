package second;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by NATA on 29.09.2018.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number and choose needed test :\n" +
                "1-Theorem of Ferma\n" +
                "2-Solovei_Shtrassen test\n" +
                "3-Miller_Rabin test\n"

        );
        System.out.println("Enter a number");


        Long number = scanner.nextLong();
        scanner.nextLine();
        while (true) {

            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    System.out.print("Ferma test:\n" + number + " is ");
                    if (!Fermat(number))
                        System.out.println("composite");
                    else System.out.println("maybe prime");
                    break;
                case "2":
                    Solovei_Shtrassen(number);
                    break;
                case "3":
                    Miller_Rabin(number);
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Wrong command,try again.");
                    break;
            }
        }
    }

    public static boolean Fermat(Long n) {
        Random r = new Random();
        int a = r.nextInt(Math.toIntExact(n));
        while (a > n || a == 0 && a < n)
            a = r.nextInt(Math.toIntExact(n));
//        int a =3;
//        if(a<n) {
            while (n / a != 1)
                a++;
//        }
        BigInteger c = new BigInteger(String.valueOf(a));
        if (c.modPow(BigInteger.valueOf(n - 1), BigInteger.valueOf(n)).equals(BigInteger.ONE)) {
            return true;
        } else {
            return false;
        }
    }


    public static boolean isPrime(Long n) {
        if (n == 2)
            return true;
        if (n == 1 || n % 2 == 0)
            return false;
        Long sq = (long) Math.sqrt(n);
        for (int i = 3; i < sq; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static Long power(Long x, Long y, Long mod) {
        if (y == 0)
            return 1l;
        Long temp = power(x, y / 2, mod) % mod;
        temp = (temp * temp) % mod;
        if (y % 2 == 1)
            temp = (temp * x) % mod;
        return temp;
    }

    public static boolean Carlmichael(Long x) {
        if (isPrime(x))
            return false;
        for (int i = 2; i < x; i++) {
            if (power(Long.valueOf(i), x, x) != i)
                return false;
        }
        return true;
    }

    public static Long Jacobi(Long a, Long b) {
        for (int i = 2; i < b; i++) {
            if (b % i == 0) {
                System.out.println("Number " + b + " is composite");
                return 0L;
            }
        }
        Long r = 1L;
        if (a < 0) {
            a = -a;
            if (b % 4 == 3)
                r = -r;
        }
        do {

            int t = 0;
            while (a % 2 == 0) {
                t++;
                a /= 2;
            }
            if (t % 2 != 0) {
                if (b % 8 == 3 || b % 8 == 5)
                    r = -r;
            }
            if (a % 4 == 3 && b % 4 == 3)
                r = -r;
            Long c = a;
            a = b % c;
            b = c;

        }
        while (a != 0);
        return r;
    }

    public static void Solovei_Shtrassen(Long n) {
        System.out.println("Reliability parametr is 10");
        int t = 1000;
        int end = 0;
        int prime = 0;
        System.out.print("Solovei-Shtrassen test:\n" + n + " is ");
        while (end != t) {
            Long c = (long) (Math.random() * (n - 2 - 2) + 2);
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    System.out.println("composite");
                    return;
                }
            }
            if (n % c == 0 && n % 2 == 0) {
                System.out.println("composite");
                return;
            } else {
                Long r = Jacobi(c, n);

                BigInteger s = new BigInteger(String.valueOf(c));
                s = s.modPow(BigInteger.valueOf((n - 1) / 2), BigInteger.valueOf(n));
                if (BigInteger.valueOf(r).equals(s))
                    prime++;
            }
            end++;

        }

        System.out.println("prime with probability " + (1 - Math.pow(2, -prime)));
    }

    public static void Miller_Rabin(Long n) {
        System.out.println("Number of rounds is 100");

        if (n < 2 || n % 2 == 0) {
            System.out.println("Wrong number");
            return;
        } else {
            System.out.print("Miller_Rabin test:\n");
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    System.out.println(n + " is a composite");
                    return;
                }
            }
            int k = 0;
            Long t = n - 1;
            int s = 0;
            while (t % 2 == 0) {
                t /= 2;
                s++;
            }
            int prime = 0;
            label:
            while (k != 10) {
                Long a = (long) (Math.random() * (n - 2 - 2) + 2);                   //первый цикл
                BigInteger x = new BigInteger(String.valueOf(a));
                x = x.modPow(BigInteger.valueOf(t), BigInteger.valueOf(n));
                if (x.equals(BigInteger.ONE) || x.equals(BigInteger.valueOf(-1))) {
                    prime++;
                    k++;
                    continue;
                } else {
                    for (int i = 0; i < s; i++) {                                      //второй
                        x = x.modPow(BigInteger.valueOf(2), BigInteger.valueOf(n));
                        if (x.equals(BigInteger.ONE)) {
                            break;
                        }
                        if (x.equals(BigInteger.valueOf(-1))) {
                            prime++;
                            k++;
                            continue label;
                        }
                    }

                }
                k++;
            }
            System.out.print(n + " is ");
            System.out.printf("prime with probability %.4f ", 1 - Math.pow(4, -prime));
            System.out.println();
        }
    }
}
