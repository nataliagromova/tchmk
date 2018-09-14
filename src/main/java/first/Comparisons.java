package first;



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
        return "ChineseTheorem:"+String.valueOf(BigInteger.valueOf(x).mod(BigInteger.valueOf(M)).intValue());
    }

    static String GarnerMethod(int k, int[] a, int[] mi) {
        int[] mi_revert = new int[mi.length];
        int[] mu = new int[mi.length];
        int M = 0;
        for (int i = 1; i < k; i++) {
            M = mi[0];
            for (int j = 1; j < i; j++) {
                M *= mi[j];
            }
            mu[i] = M;
            mi_revert[i] = BigInteger.valueOf(mu[i]).modInverse(BigInteger.valueOf(mi[i])).intValue();
        }
        M = mu[k - 1] * mi[k - 1];
        int temp;
        int v = a[0];
        for (int i = 1; i < k; i++) {
            temp = BigInteger.valueOf((a[i] - v) * mi_revert[i]).mod(BigInteger.valueOf(mi[i])).intValue();
            v += temp * mu[i];
        }
        v = BigInteger.valueOf(v).mod(BigInteger.valueOf(M)).intValue();
        return "GarnerMethod:"+String.valueOf(v);
    }


}
