package first;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        int a= Integer.parseInt(args[0]);
//        int b= Integer.parseInt(args[1]);
//        int a=25,b=90;
//        System.out.println(Euclid.EuclidGCD(a,b));
//        System.out.println(Euclid.EulcidEXT(a,b));
//        System.out.println(Euclid.EuclidBIN(a,b));
        int k=3;
        int [] a={3,2,4};
        int [] m={4,3,5};
        System.out.println(Comparisons.ChineseTheorem(3,a,m));
        System.out.println(Comparisons.GarnerMethod(3,a,m));
    }
}
