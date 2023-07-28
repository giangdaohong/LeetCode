package com.codechef.inoutfastest;

import java.io.FileInputStream;
import java.io.InputStream;

public class IOTemplate_Pro {
    public static class FO {
        InputStream di;
        byte[] bf = new byte[1 << 17];
        int p = 0;

        public FO(String fileName) throws Exception {
            di = new FileInputStream(fileName);
        }

        public FO(InputStream is) {
            di = is;
        }

        int nextInt() throws Exception {
            int ret = 0;
            byte b;
            do {
                b = nextByte();
            } while (b <= ' ');
            boolean negative = false;
            if (b == '-') {
                negative = true;
                b = nextByte();
            }
            while (b >= '0' && b <= '9') {
                ret = 10 * ret + b - '0';
                b = nextByte();
            }
            return (negative) ? -ret : ret;
        }

        long nextLong() throws Exception {
            long ret = 0;
            byte b;
            do {
                b = nextByte();
            } while (b <= ' ');
            boolean negative = false;
            if (b == '-') {
                negative = true;
                b = nextByte();
            }
            while (b >= '0' && b <= '9') {
                ret = 10 * ret + b - '0';
                b = nextByte();
            }
            return (negative) ? -ret : ret;
        }

        Integer[] readArray(int n) throws Exception {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        byte nextByte() throws Exception {
            if (p == bf.length) {
                di.read(bf, 0, bf.length);
                p = 0;
            }
            return bf[p++];
        }

        String next() throws Exception {
            StringBuilder ret = new StringBuilder();
            byte b;
            do {
                b = nextByte();
            } while (b <= ' ');
            while (b > ' ') {
                ret.appendCodePoint(b);
                b = nextByte();
            }
            return ret.toString();
        }

        public void close() throws Exception {
            if (di == null) return;
            di.close();
        }

        public int[] nextArray(int n) throws Exception {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }
    }
}
