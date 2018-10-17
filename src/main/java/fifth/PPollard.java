package fifth;

import java.math.BigInteger;

/**
 * Created by NATA on 15.10.2018.
 */
public class PPollard {
    BigInteger n;
    int c;

    public PPollard(BigInteger n, int c) {
        this.n = n;
        this.c = c;
    }

    public PPollard(BigInteger n) {
        this.n = n;
    }

    void F() {
        BigInteger a = BigInteger.valueOf(c);
        BigInteger b = BigInteger.valueOf(c);
        BigInteger d = BigInteger.ONE;

        do{
            a=Func(a).mod(n);
            b=Func(b).mod(n);
            b=Func(b).mod(n);
            d=n.gcd(a.subtract(b));
            if(d.equals(n)) {
                System.out.println("P-Pollard: divider is not found");
                return;
            }
        }
        while (d.equals(BigInteger.ONE));
        System.out.println("P-Pollard result: "+d);
        //System.out.println("n="+d+"*"+n.divide(d));
    }
    BigInteger Func(BigInteger a){
        int [] masf={5,0,1};
        BigInteger res=BigInteger.ZERO;
        for (int i = 0; i < masf.length; i++) {
            res=res.add(a.pow(i).multiply(BigInteger.valueOf(masf[i])));
        }
        return res;
    }

    BigInteger Ft() {
        BigInteger a = BigInteger.valueOf(c);
        BigInteger b = BigInteger.valueOf(c);
        BigInteger d;

        do{
            a=Func(a).mod(n);
            b=Func(b).mod(n);
            b=Func(b).mod(n);
            d=n.gcd(a.subtract(b));
            if(d.equals(n)) {
                System.out.println("P-Pollard: divider is not found");
                return BigInteger.ZERO;
            }
        }
        while (d.equals(BigInteger.ONE));
        return d;
    }
}
