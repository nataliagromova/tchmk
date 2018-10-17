package forth;

/**
 * Created by NATA on 05.10.2018.
 */
public class Gauss {
    public static double[] gauss(double[][] a, double[] b) {
        int n = a.length;
        for (int row = 0; row < n; row++) {
            int best = row;
            for (int i = row + 1; i < n; i++)
                if (Math.abs(a[best][row]) < Math.abs(a[i][row]))
                    best = i;
            double[] tt = a[row];
            a[row] = a[best];
            a[best] = tt;
            double t = b[row];
            b[row] = b[best];
            b[best] = t;
            for (int i = row + 1; i < n; i++)
                a[row][i] /= a[row][row];
            b[row] /= a[row][row];
            a[row][row] = 1;
            for (int i = 0; i < n; i++) {
                double x = a[i][row];
                if (i != row && x != 0) {
                    //reverse
                    for (int j = row + 1; j < n; j++)
                        a[i][j] -= a[row][j] * x;
                    b[i] -= b[row] * x;
                }
            }
        }
        for (int i = 0; i < b.length; i++) {
            if (Math.abs(b[i]) - (int) Math.abs(b[i]) > 0.999) b[i] = b[i] > 0 ? (int) b[i] + 1 : (int) b[i] - 1;
        }
        return b;
    }
}
