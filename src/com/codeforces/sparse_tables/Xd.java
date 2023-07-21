package com.codeforces.sparse_tables;

import java.io.*;
import java.util.*;

class Xd {
    static InputReader in = new InputReader();
    static PrintWriter out = new PrintWriter(System.out);

    private void solve() {
        int n = in.nextInt();
        int[] a = in.nextArray(n);
        int m = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();

        SparseTable st = new SparseTable(a);
        long sum = st.query(Math.min(x, y), Math.max(x, y));
        for (int i = 1; i < m; i++) {
            x += 7;
            if (x >= n - 1) x %= n - 1;
            y += 11;
            if (y >= n) y %= n;
            sum += st.query(Math.min(x, y), Math.max(x, y));
        }

        out.println(sum);
    }

    class SparseTable {
        int[][] M;
        int n;
        int k;

        SparseTable(int[] a) {
            n = a.length;
            k = 32 - Integer.numberOfLeadingZeros(n);
            M = new int[k][n];
            for (int i = 0; i < n; i++) {
                M[0][i] = a[i];
            }

            for (int j = 1; j < k; j++) {
                for (int i = 0; i + (1 << j) - 1 < n; i++) {
                    M[j][i] = op(M[j - 1][i], M[j - 1][i + (1 << (j - 1))]);
                }
            }
        }

        int query(int s, int e) {
            int log = 31 - Integer.numberOfLeadingZeros(e - s + 1);
            return op(M[log][s], M[log][e - (1 << log) + 1]);
        }

        int op(int x, int y) {
            return Math.max(x, y);
        }
    }

    public static void main(String[] args) {
        new Xd().solve();
        out.flush();
    }


    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public InputReader(String file) {
            try {
                stream = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                System.err.println(e);
            }
        }

        public InputReader() {
            this(System.in);
        }

        private int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public int[] nextArray(int N) {
            int[] a = new int[N];
            for (int i = 0; i < N; i++)
                a[i] = nextInt();
            return a;
        }

        public int[][] nextMatrix(int n, int m) {
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = nextInt();
                }
            }
            return matrix;
        }

    }
}
