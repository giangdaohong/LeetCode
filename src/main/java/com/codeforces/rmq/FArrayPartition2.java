package com.codeforces.rmq;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public final class FArrayPartition2 {
    public static final PrintWriter out = new PrintWriter(System.out);
    public static final Reader in = new Reader();

    public static void main(String[] args) throws IOException {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] pMax = new int[n];
            int[] a = in.nextArray(n);
            int lg = 32 - Integer.numberOfLeadingZeros(n);
            int[][] spMin = new int[lg][n];
            System.arraycopy(a, 0, spMin[0], 0, n);

            pMax[0] = a[0];
            for (int i = 1; i < n; i++) {
                pMax[i] = Math.max(pMax[i - 1], a[i]);
            }
            int[] sMax = new int[n];

            sMax[n - 1] = a[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                sMax[i] = Math.max(sMax[i + 1], a[i]);
            }

            for (int j = 1; j < lg; j++) {
                for (int i = 0; i + (1 << (j - 1)) < n; i++) {
                    spMin[j][i] = Math.min(spMin[j - 1][i], spMin[j - 1][i + (1 << (j - 1))]);
                }
            }
            boolean y = false;
            for (int x = 0; x < n - 2 && !y; x++) {
                int l = x + 1;
                int r = n - 2;
                while (l <= r && !y) {
                    int mid = l + (r - l) / 2;
                    int lg2 = 31 - Integer.numberOfLeadingZeros(mid - x);
                    int min = Math.min(spMin[lg2][x + 1], spMin[lg2][mid - (1 << lg2) + 1]);

                    if (min > pMax[x] || sMax[mid + 1] > pMax[x]) {
                        l = mid + 1;
                    } else if (min < pMax[x] || sMax[mid + 1] < pMax[x]) {
                        r = mid - 1;
                    } else {
                        out.println("YES" + "\n" + (x + 1) + " " + (mid - x) + " " + (n - mid - 1));
                        y = true;
                    }
                }
            }
            if (!y) {
                out.println("NO");
            }
        }
        out.flush();
        in.close();
    }

    public static class Reader {
        final public int BUFFER_SIZE = 1 << 16;
        public final DataInputStream din;
        public final byte[] buffer;
        public int bufferPointer, bytesRead;

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

        public void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        public byte read() throws IOException {
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
