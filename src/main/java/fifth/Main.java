package fifth;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by NATA on 15.10.2018.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("1-p-Pollard\n" +
                "2-(p-1)-Pollard");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int choose = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter n: ");
            String s = scanner.nextLine();
            BigInteger n = new BigInteger(s);
            int c = 4, B = 5;
            switch (choose) {
                case 1: {
                    System.out.println("Enter initial c for p-Pollard method:");
                    c = scanner.nextInt();
                    PPollard pPollard = new PPollard(n, c);
                    pPollard.F();
                    break;
                }
                case 2: {
                    System.out.println("enter B");
                    B = scanner.nextInt();
                    Pollard1 pollard1 = new Pollard1(n, B);
                    BigInteger pol1 = pollard1.F();
                    if (pol1.equals(BigInteger.ZERO))
                        System.out.println("P-1 Pollard: divider is not found");
                    else System.out.println("P-1 Pollard result: " + pol1);
                    break;
                }
                case 3: {
                    double start, finish;
                    double res1 = 0, res2 = 0;
                    Pollard1 pollard1 = new Pollard1(n, B);
                    PPollard pPollard = new PPollard(n, c);
//        for (int i = 0; i < 1000; i++) {
//            start = System.nanoTime();
//            pPollard.Ft();
//            finish = System.nanoTime();
//            res1 += finish - start;
//            start = System.nanoTime();
//            pollard1.F();
//            finish = System.nanoTime();
//            res2 += finish - start;
//        }
//        res1 = res1 / 1000 / 1e9;
//        res2 = res2 / 1000 / 1e9;
//        System.out.println(res2 / res1);
//        System.out.println("Time 1 " + res1);
//        System.out.println("Time 2 " + res2);P
                    for (int i = 0; i < 1000; i++) {
                        start = System.currentTimeMillis();
                        pPollard.Ft();
                        finish = System.currentTimeMillis();
                        res1 += finish - start;
                        start = System.currentTimeMillis();
                        pollard1.F();
                        finish = System.currentTimeMillis();
                        res2 += finish - start;
                    }
                    res1 = res1 / 1000;
                    res2 = res2 / 1000;
                    System.out.println(res2 / res1);
                    System.out.println("Time 1 " + res1);
                    System.out.println("Time 2 " + res2);
                    break;
                }
                default:
                    break;
            }

        }


    }
}
