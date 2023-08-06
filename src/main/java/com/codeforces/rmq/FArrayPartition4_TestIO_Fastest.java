package com.codeforces.rmq;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public final class FArrayPartition4_TestIO_Fastest {
    public static final PrintWriter io = new PrintWriter(System.out);
    static final R in = new R();

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
