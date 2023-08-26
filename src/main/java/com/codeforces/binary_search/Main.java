package com.codeforces.binary_search;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world");
        new Main().run();
    }

    byte s[];

    void solve() throws InterruptedException {
        int k = in.nextInt();
        s = in.nextLine().getBytes();
        int start = 0;
        int end = 0;
        long cnt = 0;
        long rs = 0;

        if (k > 0) {
            while (end < s.length) {
                System.out.println("looping here");
                if (s[end] == '1') {
                    cnt++;
                    if (cnt == k) {
                        int mark_end = end;
                        while (end < s.length && s[end] == '0') {
                            rs++;
                            end++;
                        }
                        if (mark_end > end + 1) end = mark_end - 1;
                        while (++start < s.length && s[start] == '0') {
                            rs++;
                        }
                        if (start == s.length) {
                            break;
                        }
                    }
                }
            }
        } else {
            while (start < s.length) {
                if (s[start] == '0') {
                    int idx = 0;
                    while (start + idx + 1 < s.length && s[start + idx + 1] == '0') {
                        idx++;
                    }
                    if (idx == 0) rs++;
                    else rs += (long) (idx + 1) * (idx + 2) / 2;
                    start += idx + 1;
                } else start++;
            }
        }

        out.println(rs);
        out.flush();
    }

    FastScanner in;
    PrintWriter out;

    void run() throws InterruptedException {
        in = new FastScanner(System.in);
        out = new PrintWriter(new OutputStreamWriter(System.out));
        solve();
        out.close();
    }

    void runIO() {
        try {
            in = new FastScanner(new File("in.in"));
            out = new PrintWriter(new FileWriter(new File("out.out")));
            solve();
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    class FastScanner {
        BufferedReader bf;
        StringTokenizer st;

        public FastScanner(File f) {
            try {
                bf = new BufferedReader(new FileReader(f));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        public FastScanner(InputStream is) {
            bf = new BufferedReader(new InputStreamReader(is));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(bf.readLine());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            return st.nextToken();
        }

        char nextChar() {
            return next().charAt(0);
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        float nextFloat() {
            return Float.parseFloat(next());
        }

        String nextLine() {
            try {
                return bf.readLine();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return "";
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        BigInteger nextBigInteger() {
            return new BigInteger(next());
        }

        BigDecimal nextBigDecimal() {
            return new BigDecimal(next());
        }

        int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(next());
            return a;
        }

        long[] nextLongArray(int n) {
            long a[] = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = Long.parseLong(next());
            return a;
        }
    }
}