package com.codeforces.rmq;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public final class FArrayPartition {
    private static final PrintWriter io = new PrintWriter(System.out);
    private static final Reader in = new Reader();

    public static void main(String[] args) throws IOException {
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
