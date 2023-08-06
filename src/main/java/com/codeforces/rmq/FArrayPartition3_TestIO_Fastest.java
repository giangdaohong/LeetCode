package com.codeforces.rmq;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;

public final class FArrayPartition3_TestIO_Fastest {
    public static final PrintWriter io = new PrintWriter(System.out);
    public static final DataInputStream di = new DataInputStream(System.in);
    public static final FO in = new FO(di);

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = in.nextArray(n);
            int lg = 32 - Integer.numberOfLeadingZeros(n);
            int[][] spMin = new int[lg][n];
            System.arraycopy(a, 0, spMin[0], 0, n);

            int[] pMax = new int[n];
            int[] sMax = new int[n];
            pMax[0] = a[0];
            for (int i = 1; i < n; i++) {
                pMax[i] = Math.max(pMax[i - 1], a[i]);
            }

            sMax[n - 1] = a[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                sMax[i] = Math.max(sMax[i + 1], a[i]);
            }

            for (int j = 1; j < lg; j++) {
                for (int i = 0; i + (1 << (j - 1)) < n; i++) {
                    spMin[j][i] = Math.min(spMin[j - 1][i], spMin[j - 1][i + (1 << (j - 1))]);
                }
            }

            boolean isY = false;
            for (int x = 0; x < n - 2 && !isY; x++) {
                int l = x + 1;
                int r = n - 2;
                while (l <= r && !isY) {
                    int mid = l + (r - l) / 2;
                    int log2 = 31 - Integer.numberOfLeadingZeros(mid - (x + 1) + 1);
                    int min2 = Math.min(spMin[log2][x + 1], spMin[log2][mid - (1 << log2) + 1]);

                    if (min2 > pMax[x] || sMax[mid + 1] > pMax[x]) {
                        l = mid + 1;
                    } else if (min2 < pMax[x] || sMax[mid + 1] < pMax[x]) {
                        r = mid - 1;
                    } else {
                        io.println("YES");
                        StringBuilder rs = new StringBuilder();
                        rs.append(x + 1).append(" ").append(mid - x).append(" ").append(n - mid - 1);
                        io.println(rs);
                        isY = true;
                    }
                }
            }
            if (!isY) {
                io.println("NO");
            }
        }
        io.flush();
    }

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
