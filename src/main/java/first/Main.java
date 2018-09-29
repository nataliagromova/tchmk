package first;


import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Find GCD of 2 numbers enter 1");
        System.out.println("Make compare enter 2");
        System.out.println("For exit enter 0");
        while (true) {
            String s = scanner.nextLine();
                int init = Integer.parseInt(s);
            if (init == 1) {
//                System.out.println("Enter two numbers:");
//                int a = scanner.nextInt();
//                int b = scanner.nextInt();
//                System.out.println("Here we have 3 types of Euclidean algorithm output including simple,extended and binary version: ");
//                double start = System.nanoTime();
//                System.out.println(Euclid.EuclidGCD(a, b));
//                double finish = System.nanoTime();
//                System.out.println("Time " + (finish - start) / 1e9);
//                start = System.nanoTime();
//                System.out.println(Euclid.EulcidEXT(a, b));
//                finish = System.nanoTime();
//                System.out.println("Time " + (finish - start) / 1e9);
//                start = System.nanoTime();
//                System.out.println(Euclid.EuclidBIN(a, b));
//                finish = System.nanoTime();
//                System.out.println("Time " + (finish - start) / 1e9);
                ArrayList<Pair<Integer,Integer>> mas=new ArrayList<>();
                int l=1;
                int ll=1000;
                while (mas.size()<1000000){
                    for (int j =l ; j < ll; j++) {
                        for (int k = j; k <ll ; k++) {
                            mas.add(new Pair<>(j,k));
                        }
                    }
                }
                double sum=0;
                double start ;
                double finish ;
                for (int i = 0; i < mas.size(); i++) {
                    start= System.nanoTime();
                    Euclid.EuclidBIN(mas.get(i).getKey(),mas.get(i).getValue());
                    finish= System.nanoTime();
                    sum+=finish-start;
                }
                System.out.println("gcd"+(sum/mas.size()/1e9));

            } else if (init == 2) {
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
                double start = System.nanoTime();
                System.out.println(Comparisons.ChineseTheorem(k, a, m));
                double finish = System.nanoTime();
                System.out.println("Time " + (finish - start) /1e9);
                start = System.nanoTime();
                System.out.println(Comparisons.GarnerMethod(k, a, m));
                finish = System.nanoTime();
                System.out.println("Time " + (finish - start) /1e9);
            } else if (init == 0)
                return;
            else System.out.println("Error.Try another command:)");
            System.out.println("You can choose new number (0,1,2):");
        }
    }
}
