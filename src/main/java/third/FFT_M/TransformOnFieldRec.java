package third.FFT_M;

import java.math.BigInteger;

/**
 * Created by NATA on 10.10.2018.
 */
public class TransformOnFieldRec {
    public static void TransformOnFieldRec1(F_int[] a, boolean invert, BigInteger alpha) // tested
    {
        BigInteger mod = a[0]._mod;

        int n = a.length;
        if (n == 1) return;

        F_int[] a0 = new F_int[n / 2], a1 = new F_int[n / 2];

        for (int i = 0; i < n / 2; i++) {
            a0[i] = new F_int(BigInteger.ZERO, mod);
            a1[i] = new F_int(BigInteger.ZERO, mod);
        }

        for (int i = 0, j = 0; i < n; i += 2, ++j) {
            a0[j] = a[i];
            a1[j] = a[i + 1];
        }

        TransformOnFieldRec1(a0, invert, alpha);
        TransformOnFieldRec1(a1, invert, alpha);


        F_int root = new F_int(BigInteger.ONE, mod),
                root_w = new F_int(alpha, mod);


        for (int i = 0; i < n / 2; ++i) {
            a[i] = F_int.add(a0[i], F_int.mult(root, a1[i]));
            a[i + n / 2] = F_int.sub(a0[i], F_int.mult(root, a1[i]));

            if (invert) {
                a[i] = F_int.mult(a[i], F_int.GetInverseElement(new F_int(BigInteger.valueOf(2),mod)));
                a[i + n / 2] =  F_int.mult(a[i + n / 2], F_int.GetInverseElement(new F_int(BigInteger.valueOf(2),mod)));
            }

            root = F_int.mult(root, root_w);
        }
    }

    static BigInteger Pow(int n, BigInteger mod) {
        BigInteger alpha;
        for (alpha = BigInteger.valueOf(2); !alpha.equals(mod.subtract(BigInteger.ONE)); alpha = alpha.add(BigInteger.ONE)) {
            if (alpha.modPow(BigInteger.valueOf(8), mod).equals(BigInteger.ONE))
                break;
        }
        return alpha;
    }

}
