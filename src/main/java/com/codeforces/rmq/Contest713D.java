package com.codeforces.rmq;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Contest713D {
    static final PrintWriter out = new PrintWriter(System.out);
    static final R in = new R();

    public static void main(String[] args) throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();

        int[][] matrix = R.nextArray2D(n, m);
    }

    /**
     * <a href="https://codeforces.com/contest/713/problem/D">...</a>
     * <a href="https://codeforces.com/blog/entry/47094">...</a>
     * First lets calculate dp[i][j] — maximum square ending in cell (i, j). For each cell if input matrix contain 0 then dp[i][j] = 0 else dp[i][j] = min(dp[i - 1][j - 1], dp[i−1][j], dp[i][j−1]) + 1.
     * <p>
     * We will use binary search to find the answer. Lets fix some value x. For each square (i, j)..(i + x - 1, j + x - 1) we need to find maximum and compare it to x. To find maximum we can use 2D sparse table.
     * <p>
     * So preprocessing takes O(NMlogNlogM), and query works in O(logN).
     */
    static void solve(int n, int m, int a, int b, int[][][][] M, int[][] matrix) {
        out.println("");
        out.flush();
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
