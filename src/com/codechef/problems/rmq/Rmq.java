package com.codechef.problems.rmq;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

class Rmq {
    private static final PrintWriter out = new PrintWriter(System.out);
    private static final Reader in = new Reader();

    public static void main(String[] args) throws IOException {

        int n = in.nextInt();
        int[] a = in.nextArray(n);
        int m = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();

        int k = 32 - Integer.numberOfLeadingZeros(n);
        int[][] sp = new int[k][n];

        System.arraycopy(a, 0, sp[0], 0, n);

        for (int j = 1; j < k; j++) {
            for (int i = 0; i + (1 << (j - 1)) < n; i++) {
                sp[j][i] = Math.max(sp[j - 1][i], sp[j - 1][i + (1 << (j - 1))]);
            }
        }

        long sum = 0;
        int lg;
        while (m-- > 0) {
            int l = Math.min(x, y);
            int r = Math.max(x, y);
            lg = 31 - Integer.numberOfLeadingZeros(r - l + 1);
            sum += Math.max(sp[lg][l], sp[lg][r - (1 << lg) + 1]);
            x += 7;
            if (x >= n - 1) x %= (n - 1);
            y += 11;
            if (y >= n) y %= n;
        }
        out.println(sum);
        out.flush();
    }

    static class Reader {
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
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
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
