package com.codeforces.rmq;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;

public class DMAP_2D_RMQ {
    /*
                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)2
1 1 1
2 1 2
                  O\  =  /O
               ____/`---'\____
             .'  \\|     |//  `.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  `-`  ___/-. /
         ___`. .'  /--.--\  `. . ___
      ."" '<  `.___\_<|>_/___.'  >'"".
     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
     \  \ `-.   \_ __\ /__ _/   .-` /  /
======`-.____`-.___\_____/___.-`____.-'======
                   `=---='
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
*/
    static final PrintWriter out = new PrintWriter(System.out);
    static final R in = new R();

    public static void main(String[] args) throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();

        int[][] matrix = R.nextArray2D(n, m);
        MyThread myThread = new MyThread(n, m, a, b, matrix);
        myThread.start();
    }

    static void solve(int n, int m, int a, int b, int[][][][] M, int[][] matrix) {
        // *********/
        //        Main process
        // 1. Calculus presum of matrix
        // 2. Preprocess 2D RMQ by sparse table
        // 3. List out all area a*b and min of it's where min "excess ground"
        // 4. Sort list min by upper left most
        // 5. Count and print output

        //*********/
        //       Implement
        // 1. Calculus pre sum
        long[][] pre_sum = preSum(matrix);
        precompute_min(n, m, M, matrix);
        matrix = null;
        // 2. List out all area a*b and min of it's where min "excess ground"
        ArrayList<Area> ls = new ArrayList<>();
        for (int i = 0; i + a <= n; i++) {
            for (int j = 0; j + b <= m; j++) {
                int min_high = compute_min(i, j, i + a - 1, j + b - 1, M);
                long sum;
                if (i == 0 && j == 0) {
                    sum = pre_sum[i + a - 1][j + b - 1];
                } else if (i == 0) {
                    sum = pre_sum[i + a - 1][j + b - 1] - pre_sum[i + a - 1][j - 1];
                } else if (j == 0) {
                    sum = pre_sum[i + a - 1][j + b - 1] - pre_sum[i - 1][j + b - 1];
                } else {
                    sum = pre_sum[i + a - 1][j + b - 1] - pre_sum[i - 1][j + b - 1] - pre_sum[i + a - 1][j - 1] + pre_sum[i - 1][j - 1];
                }
                long current_excess_ground = sum - (long) a * b * min_high;

                Area area = new Area(i, j, current_excess_ground);
                ls.add(area);
            }
        }
        // 3. Sort list min by upper left most
        Collections.sort(ls);

        ArrayList<Area> rs = new ArrayList<>();
        if (!ls.isEmpty()) {
            for (Area l : ls) {
                if (!checkConflict(l, rs, a, b)) {
                    rs.add(l);
                }
            }
        }
        ls = null;
        out.println(rs.size());
        for (Area ar : rs) {
            out.println((ar.x + 1) + " " + (ar.y + 1) + " " + ar.excessGround);
        }
        out.flush();
    }

    private static boolean checkConflict(Area area, ArrayList<Area> rs, int a, int b) {
        for (Area cur : rs) {
            if (Math.abs(area.x - cur.x) == 0 && Math.abs(area.y - cur.y) == 0) {
                return true;
            }
            if (Math.abs(area.x - cur.x) == 0 && Math.abs(area.y - cur.y) < b) {
                return true;
            }
            if (Math.abs(area.y - cur.y) == 0 && Math.abs(area.x - cur.x) < a) {
                return true;
            }
            if (Math.abs(area.x - cur.x) < a && Math.abs(area.y - cur.y) < b) {
                return true;
            }
        }
        return false;
    }

    static long[][] preSum(int[][] matrix) {
        long[][] rs = new long[matrix.length][matrix[0].length];
        rs[0][0] = matrix[0][0];
        IntStream.range(1, matrix.length).forEachOrdered(i -> rs[i][0] = rs[i - 1][0] + (long) matrix[i][0]);
        IntStream.range(1, matrix.length).forEachOrdered(j -> rs[0][j] = rs[0][j - 1] + (long) matrix[0][j]);
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                rs[i][j] = rs[i - 1][j] + rs[i][j - 1] - rs[i - 1][j - 1] + (long) matrix[i][j];
            }
        }
        return rs;
    }

    static void precompute_min(int n, int m, int[][][][] M, int[][] matrix) {
        for (int i = 0; (1 << i) <= n; i++) { // 0 -> logN for row
            for (int j = 0; (1 << j) <= m; j++) { // 0 -> logM for col
                for (int x = 0; x + (1 << i) <= n; x++) { // row
                    for (int y = 0; y + (1 << j) <= m; y++) { // col
                        if (i == 0 && j == 0) {
                            M[i][j][x][y] = matrix[x][y]; // store x, y
                        } else if (i == 0) {
                            M[i][j][x][y] = Math.min(M[i][j - 1][x][y], M[i][j - 1][x][y + (1 << (j - 1))]);
                        } else if (j == 0) {
                            M[i][j][x][y] = Math.min(M[i - 1][j][x][y], M[i - 1][j][x + (1 << (i - 1))][y]);
                        } else {
                            M[i][j][x][y] = Math.min(Math.min(M[i - 1][j - 1][x][y], M[i - 1][j - 1][x + (1 << (i - 1))][y]),
                                    Math.min(M[i - 1][j - 1][x][y + (1 << (j - 1))], M[i - 1][j - 1][x + (1 << (i - 1))][y + (1 << (j - 1))]));
                        }
                    }
                }
            }
        }
    }

    static int compute_min(int x, int y, int x1, int y1, int[][][][] M) {
        int k = 31 - Integer.numberOfLeadingZeros(x1 - x + 1);
        int l = 31 - Integer.numberOfLeadingZeros(y1 - y + 1);
        int ans2 = Math.min(Math.min(M[k][l][x][y], M[k][l][x1 - (1 << k) + 1][y]),
                Math.min(M[k][l][x][y1 - (1 << l) + 1], M[k][l][x1 - (1 << k) + 1][y1 - (1 << l) + 1]));
        return ans2;
    }

    public static class MyThread extends Thread {
        int n, m, a, b;
        int[][] matrix;

        public MyThread(int n, int m, int a, int b, int[][] matrix) {
            this.n = n;
            this.m = m;
            this.a = a;
            this.b = b;
            this.matrix = matrix;
        }

        public void run() {
            int lgN = 32 - Integer.numberOfLeadingZeros(n), lgM = 32 - Integer.numberOfLeadingZeros(m);
            int[][][][] M = new int[lgN][lgM][n][m];
            solve(n, m, a, b, M, matrix);
        }
    }

    static class Area implements Comparable<Area> {
        public int x;
        public int y;
        public long excessGround;

        public Area(int x, int y, long excessGround) {
            this.x = x;
            this.y = y;
            this.excessGround = excessGround;
        }

        @Override
        public int compareTo(Area o) {
            if (this.excessGround > o.excessGround) return 1;
            if (this.excessGround < o.excessGround) return -1;
            if (this.x > o.x) return 1;
            if (this.x < o.x) return -1;
            return Integer.compare(this.y, o.y);
        }
    }

    static class R {
        final private int SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] bf;
        private int bfP, bR;

        public R() {
            din = new DataInputStream(System.in);
            bf = new byte[SIZE];
            bfP = bR = 0;
        }

        public R(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            bf = new byte[SIZE];
            bfP = bR = 0;
        }

        private static int[][] nextArray2D(int n, int m) throws IOException {
            int[][] rs = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    rs[i][j] = in.nextInt();
                }
            }
            return rs;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    } else {
                        continue;
                    }
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg) return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg) return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bR = din.read(bf, bfP = 0, SIZE);
            if (bR == -1) bf[0] = -1;
        }

        private byte read() throws IOException {
            if (bfP == bR) fillBuffer();
            return bf[bfP++];
        }

        public void close() throws IOException {
            if (din == null) return;
            din.close();
        }

        public int[] nextArray(int N) throws IOException {
            int[] a = new int[N];
            for (int i = 0; i < N; i++)
                a[i] = nextInt();
            return a;
        }
    }
}
