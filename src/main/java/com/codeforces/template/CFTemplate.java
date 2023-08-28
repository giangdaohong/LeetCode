package com.codeforces.template;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CFTemplate {
    static R in = new R();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException, InterruptedException {
       // runTest();
        CFTemplate.run();
    }

    static void run() throws IOException {
        solve();
        out.close();
    }

    static void runTest() throws IOException {
        String path = "src/main/java/com/codeforces/segmenttree/";
        String pIn = path + "in.in";
        String pOut = path + "out.out";
        String pOutBf = path + "bf.out";
        for (int i = 1; i < 10001; i++) {
            // Generate test here ...
            FileWriter writer = new FileWriter(pIn);

            int randomNum = (int) ((Math.random() * (1)) + 0);
            writer.write(randomNum + "\n");
            writer.write(randomNum + "\n");
            writer.write("0101");
            writer.close();

            runIO(pIn, pOut); // write solution to out.out
            runIO_BruteForces(pIn, pOutBf);// run brute forces solution
            runCompare(pOutBf, pOut, i); // Compare test
        }
    }

    static void solve() {

    }

    static void solve_BruteForces() {

    }

    /**
     * Run solution base on file I/O
     *
     * @param pIn  input file test
     * @param pOut output file result
     */
    static void runIO(String pIn, String pOut) throws IOException {
        in = new R(pIn);
        out = new PrintWriter(new FileWriter(pOut));
        solve();
        out.close();
    }

    /**
     * Run bruce force solution base on file I/O
     *
     * @param pIn  input file test
     * @param pOut output file result
     */
    static void runIO_BruteForces(String pIn, String pOut) throws IOException {
        in = new R(pIn);
        out = new PrintWriter(new FileWriter(pOut));
        solve_BruteForces();
        out.close();
    }

    static void runCompare(String expected, String actual, int numOfTest) throws IOException {
        BufferedReader reader1 = new BufferedReader(new FileReader(expected));
        BufferedReader reader2 = new BufferedReader(new FileReader(actual));
        String line1 = reader1.readLine();
        String line2 = reader2.readLine();
        int lineNum = 1;
        boolean areEqual = true;
        while (line1 != null || line2 != null) {
            if (line1 == null || line2 == null) {
                areEqual = false;
                break;
            } else if (!line1.equalsIgnoreCase(line2)) {
                areEqual = false;
                break;
            }
            line1 = reader1.readLine();
            line2 = reader2.readLine();
            lineNum++;
        }
        if (areEqual) {
            System.out.println("\u001B[32m" + "PASSED TESTCASE " + numOfTest);
            //Thread.sleep(300);
        } else {
            System.out.print("\u001B[31m" + "FAILED TESTCASE " + numOfTest);
            System.out.println("; Expected : " + line1 + ", actual : " + line2 + " at line " + lineNum);
            //Thread.sleep(300);
            return;
        }
        reader1.close();
        reader2.close();
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
            din = new DataInputStream(Files.newInputStream(Paths.get(file_name)));
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
            byte[] buf = new byte[1000000]; // line length
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

        public char nextChar() throws IOException {
            return (char) (read());
        }
    }
}
