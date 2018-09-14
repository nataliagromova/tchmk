package first;

class Euclid {
    static String EuclidGCD(int a, int b) {
        if (b == 0)
            return "GCD:"+a;
        else return EuclidGCD(b, a % b);
    }

    static String EulcidEXT(int a, int b) {
        int x1 = 1;
        int y1 = 0;
        int x2 = 0;
        int y2 = 1;
        return EuclidEXT(a, b, x1, y1, x2, y2);
    }

    private static String EuclidEXT(int a, int b, int x1, int y1, int x2, int y2) {
        while (b != 0) {
            int q = a / b;
            int r = a % b;
            a = b;
            b = r;
            int t = x2;
            x2 = x1 - q * x2;
            x1 = t;
            t = y2;
            y2 = y1 - q * y2;
            y1 = t;
        }
        return "GCDext:" + a + " X:" + x1 + " Y:" + y1;
    }

    static String EuclidBIN(int a, int b) {
        int k = 1;
        while (a != 0 && b != 0) {
            while (a % 2 == 0 && b % 2 == 0) {
                a /= 2;
                b /= 2;
                k *= 2;
            }
            while (a % 2 == 0)
                a /= 2;
            while (b % 2 == 0)
                b /= 2;
            if (a >= b) a -= b;
            else b -= a;
        }
        return "GCDbin:"+b * k;
    }
}
