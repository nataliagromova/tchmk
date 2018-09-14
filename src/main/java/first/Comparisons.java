package first;


import com.sun.org.apache.xerces.internal.impl.dv.dtd.StringDatatypeValidator;

import java.math.BigInteger;

public class Comparisons {
    static String ChineseTheorem(int k, int[] a, int[] mi) {
        Long M = 1L;
        Long[] Mi = new Long[mi.length];
        Long[] Mi_revert = new Long[mi.length];
        for (int i = 0; i < k; i++) {
            M *= mi[i];
        }
        for (int i = 0; i < k; i++) {
            Mi[i] = M / mi[i];
            Mi_revert[i] = BigInteger.valueOf(Mi[i]).modInverse(BigInteger.valueOf(mi[i])).longValue();
        }
        Long x = 0L;
        for (int i = 0; i < k; i++) {
            x += BigInteger.valueOf(a[i] * Mi[i] * Mi_revert[i]).mod(BigInteger.valueOf(M)).longValue();
        }
        return String.valueOf(x);
    }

    static String GarnerMethod(int k, int[] a, int[] mi) {
        int[] mi_revert = new int[mi.length];
        int[] mu = new int[mi.length];
        int M=0;
        for (int i = 1; i < k; i++) {
            M = mi[0];
            for (int j = 1; j  < i; j++) {
                M *= mi[j];
            }
            mi_revert[i] = BigInteger.valueOf(M).modInverse(BigInteger.valueOf(mi[i])).intValue();
        }
        int[] v = new int[k];
        int temp;
        v[0] = a[0];
        for (int i = 1; i < k; i++) {
            temp = v[i - 1];
            for (int j = i - 2; j >= 0; j--) {
                temp =temp* mi[j] + v[j];
            }
            v[i]=(v[i]-temp)*mi_revert[i];
        }
        int u=v[k-1];
        for (int i = k-1; i >=0 ; i--) {
            u=u*mi[i]+v[i];
        }
        return String.valueOf(u);
//        return String.valueOf(BigInteger.valueOf(u).mod(BigInteger.valueOf(M*mi[k-1])).intValue());
    }


}
