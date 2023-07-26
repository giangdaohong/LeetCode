package com.codechef.problems.rmq;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public final class FArrayPartition {
    private static final PrintWriter out = new PrintWriter(System.out);
    private static final Reader in = new Reader();

    public static void main(String[] args) throws IOException {
        int t = in.nextInt();
        int n;
        int[] a;
        int lg;
        int[][] sp_min;
        int[][] sp_max;
        while (t-- > 0) {
            n = in.nextInt();
            a = in.nextArray(n);
            lg = 32 - Integer.numberOfLeadingZeros(n);
            sp_min = new int[lg][n + 1];
            System.arraycopy(a, 0, sp_min[0], 1, n);

            sp_max = new int[lg][n + 1];
            System.arraycopy(a, 0, sp_max[0], 1, n);

            for (int j = 1; j < lg; j++) {
                for (int i = 1; i + (1 << (j - 1)) < n + 1; i++) {
                    sp_min[j][i] = Math.min(sp_min[j - 1][i], sp_min[j - 1][i + (1 << (j - 1))]);
                    sp_max[j][i] = Math.max(sp_max[j - 1][i], sp_max[j - 1][i + (1 << (j - 1))]);
                }
            }
            boolean isNext = false;
            for (int x = n - 2; x >= 1; x--) {
                for (int y = 1; x + y <= n - 1; y++) {
                    int lg1 = 31 - Integer.numberOfLeadingZeros(x);
                    int log2 = 31 - Integer.numberOfLeadingZeros(y);
                    int log3 = 31 - Integer.numberOfLeadingZeros(n - (x + y));
                    int max1;
                    if (x == 1) max1 = a[0];
                    else max1 = Math.max(sp_max[lg1][1], sp_max[lg1][x - (1 << lg1) + 1]);
                    int min2 = Math.min(sp_min[log2][x + 1], sp_min[log2][x + y - (1 << log2) + 1]);
                    int max3 = Math.max(sp_max[log3][x + y + 1], sp_max[log3][n - (1 << log3) + 1]);
                    if (max1 == min2 && min2 == max3) {
                        out.println("YES");
                        out.println(x + " " + y + " " + (n - (x + y)));
                        isNext = true;
                        break;
                    }
                }
                if (isNext) break;
            }
            if (!isNext) {
                out.println("NO");
            }
        }
        out.flush();
    }

    private static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public int[] readLineInt() throws IOException {

            String[] s = din.readLine().split(" ");
            int[] a = new int[s.length];
            int i = 0;
            for (String t : s) {
                a[i++] = Integer.parseInt(t.trim());
            }
            return a;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[128]; // line length
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
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
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
