package third.FFT_M;

import java.math.BigInteger;

/**
 * Created by NATA on 10.10.2018.
 */
public class Solution {
    public static void main(String[] args) {
//        int[] input = {7,6,5,4,3,2,1,0};
        int[] input = {0, 1, 2, 3, 4, 5, 6, 7};
//        int[] input = {5,4,2,-1};
        BigInteger mod=new BigInteger("65537");
        F_int [] a=new F_int[input.length];
        for (int i = 0; i < input.length; i++) {
            a[i]=new F_int(BigInteger.valueOf(input[i]),mod);
        }
        BigInteger pow=TransformOnFieldRec.Pow(input.length,mod);
        TransformOnFieldRec.TransformOnFieldRec1(a,false,pow);
        for (int i = 0; i < input.length; i++) {
            System.out.println(a[i]._val);
        }
        TransformOnFieldRec.TransformOnFieldRec1(a,true,pow);
        for (int i = 0; i < input.length; i++) {
            System.out.println(a[i]._val);
        }
    }
}
