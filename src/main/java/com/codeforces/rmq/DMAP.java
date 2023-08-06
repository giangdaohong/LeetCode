package com.codeforces.rmq;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;

public class DMAP {
    /*
                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
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
        int[][] input = R.nextArray2D(n, m);

        solve(n, m, a, b, input);
    }

    static void solve(int n, int m, int a, int b, int[][] matrix) {
        long[][] preSum = preSum(matrix);

        int[][] st = new int[m][n]; // to invert row by colum
        for (int i = 0; i < n; i++) { // pre calculus by rmq on each row with length 'b'
            int[][] lst = rmq2D(matrix[i]);
            for (int j = 0; j + b <= m; j++) {
                st[j][i] = query(j, j + b - 1, lst); // index j to store by column
            }
        }

        // pre calculus by rmq on each col with length 'a'
        long[][] dp = new long[n][m];
        for (int i = 0; i + b <= m; i++) { // get by column => row
            int[][] ls_acc = rmq2D(st[i]);
            for (int j = 0; j + a <= n; j++) {
                dp[j][i] = query(j, j + a - 1, ls_acc);
            }
        }

        ArrayList<Area> ls = new ArrayList<>();
        for (int i = 0; i + a <= n; i++) {
            for (int j = 0; j + b <= m; j++) {
                long sum;
                if (i == 0 && j == 0) {
                    sum = preSum[i + a - 1][j + b - 1];
                } else if (i == 0) {
                    sum = preSum[i + a - 1][j + b - 1] - preSum[i + a - 1][j - 1];
                } else if (j == 0) {
                    sum = preSum[i + a - 1][j + b - 1] - preSum[i - 1][j + b - 1];
                } else {
                    sum = preSum[i + a - 1][j + b - 1] - preSum[i - 1][j + b - 1] - preSum[i + a - 1][j - 1] + preSum[i - 1][j - 1];
                }
                long cost = sum - a * b * dp[i][j];
                ls.add(new Area(i, j, cost));
            }
        }
        // 3. Sort list min by upper left most
        Collections.sort(ls);
        ArrayList<Area> rs = new ArrayList<>();
        boolean[][] mark = new boolean[n][m];
        for (Area ar : ls) {
            if (mark[ar.x][ar.y] || mark[ar.x][ar.y + b - 1] || mark[ar.x + a - 1][ar.y] || mark[ar.x + a - 1][ar.y + b - 1])
                continue;
            for (int i = ar.x; i <= ar.x + a - 1; i++) {
                for (int j = ar.y; j <= ar.y + b - 1; j++) {
                    mark[i][j] = true;
                }
            }
            rs.add(ar);
        }
        out.println(rs.size());
        StringBuilder sb = new StringBuilder();
        for (Area ar : rs) {
            sb.append((ar.x + 1)).append(" ").append((ar.y + 1)).append(" ").append(ar.cost).append("\n");
        }
        out.println(sb);
        out.flush();
    }

    static long[][] preSum(int[][] input) {
        long[][] rs = new long[input.length][input[0].length];
        rs[0][0] = input[0][0];
        IntStream.range(1, input.length).forEachOrdered(i -> rs[i][0] = rs[i - 1][0] + input[i][0]);
        IntStream.range(1, input[0].length).forEachOrdered(j -> rs[0][j] = rs[0][j - 1] + input[0][j]);
        for (int i = 1; i < input.length; i++) {
            for (int j = 1; j < input[0].length; j++) {
                rs[i][j] = rs[i - 1][j] + rs[i][j - 1] - rs[i - 1][j - 1] + input[i][j];
            }
        }
        return rs;
    }

    static int[][] rmq2D(int[] matrix) {
        int lgM = 32 - Integer.numberOfLeadingZeros(matrix.length);
        int[][] cur = new int[lgM][matrix.length];

        System.arraycopy(matrix, 0, cur[0], 0, matrix.length);

        for (int j = 1; j < lgM; j++) {
            for (int k = 0; k + (1 << (j - 1)) < matrix.length; k++) {
                cur[j][k] = Math.min(cur[j - 1][k], cur[j - 1][k + (1 << (j - 1))]);
            }
        }

        return cur;
    }

    static int query(int x, int y, int[][] M) {
        int k = 31 - Integer.numberOfLeadingZeros(y - x + 1);
        return Math.min(M[k][x], M[k][y - (1 << k) + 1]);
    }

    static class Area implements Comparable<Area> {
        public int x;
        public int y;
        public long cost;

        public Area(int x, int y, long cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Area o) {
            if (this.cost > o.cost) return 1;
            if (this.cost < o.cost) return -1;
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
