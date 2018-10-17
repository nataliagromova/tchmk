package fifth;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by NATA on 16.10.2018.
 */
public class Pollard1 {
    BigInteger n;
    int B;

    public Pollard1(BigInteger n, int b) {
        this.n = n;
        B = b;
    }

    Long[] Base() {
        BigInteger new_p = new BigInteger("2");
        Long[] base = new Long[B];
        int i = 0;
        do {
            base[i++] = new_p.longValue();
            new_p = new_p.nextProbablePrime();
        }
        while (i < B);
        return base;
    }

    BigInteger F() throws Exception {
        Random random=new Random();
        BigInteger a=new BigInteger(String.valueOf(random.nextInt(Math.abs(n.subtract(BigInteger.valueOf(2)).intValue()))));
        BigInteger d=a.gcd(n);
        if(d.compareTo(BigInteger.valueOf(2))==1 || d.compareTo(BigInteger.valueOf(2))==0)
            return d;
        Long [] base=Base();
        for (Long idx:base) {
            int l=(int)(Math.log(n.longValue())/Math.log(idx));
            a=a.modPow(BigInteger.valueOf(idx).pow(l),n);
        }
        d=a.subtract(BigInteger.ONE).gcd(n);
        if(d.equals(n)||d.equals(BigInteger.ONE))
            return BigInteger.ZERO;
        return d;
    }
}
