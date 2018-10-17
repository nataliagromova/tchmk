package third.FFT_M;

import java.math.BigInteger;

/**
 * Created by NATA on 10.10.2018.
 */
public class F_int {
    public BigInteger _val;
    public BigInteger _mod;

    public F_int(BigInteger val, BigInteger mod) {
        this._val = val;
        this._mod = mod;
    }

    public static F_int GetInverseElement(F_int n) {
        BigInteger reverse = n._val.modInverse(n._mod);
        return new F_int(reverse, n._mod);
    }

    static F_int mult(F_int a, F_int b) {
        BigInteger c=a._val.multiply(b._val);
        c=c.mod(a._mod);
       return new F_int(a._val.multiply(b._val).mod(a._mod),a._mod);
    }
    static F_int sub(F_int a, F_int b) {
        return new F_int(a._val.subtract(b._val).mod(a._mod),a._mod);
    }
    static F_int add(F_int a, F_int b) {
        return new F_int(a._val.add(b._val).mod(a._mod),a._mod);
    }
    static F_int div(F_int a, BigInteger b) {
        return new F_int(a._val.divide(b).mod(a._mod),a._mod);
    }
}
