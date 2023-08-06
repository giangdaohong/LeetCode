package com.codeforces.rmq;

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

public class CF317D {


    /**
     * Built using CHelper plug-in
     * Actual solution is at the top
     *
     * @author Jialin Ouyang (Jialin.Ouyang@gmail.com)
     */
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        QuickScanner in = new QuickScanner(inputStream);
        QuickWriter out = new QuickWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        int n;
        int m;
        int[][] dp;
        char[] s = new char[1];

        public void solve(int testNumber, QuickScanner in, QuickWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            dp = new int[n][m];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    in.next(s);
                    if (s[0] == '0') {
                        dp[i][j] = 0;
                    } else if (i > 0 && j > 0) {
                        dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    } else {
                        dp[i][j] = 1;
                    }
                }
            }
            IntRangeMaximumQuery2D rmq = new IntRangeMaximumQuery2D(n, m);
            rmq.init(n, m, dp);
            for (int remQ = in.nextInt(); remQ > 0; --remQ) {
                int x1 = in.nextInt() - 1;
                int y1 = in.nextInt() - 1;
                int x2 = in.nextInt();
                int y2 = in.nextInt();
                int lower = 1, upper = Math.min(x2 - x1, y2 - y1), res = 0;
                while (lower <= upper) {
                    int medium = (lower + upper) >> 1;
                    if (rmq.calc(x1 + medium - 1, y1 + medium - 1, x2, y2) >= medium) {
                        res = medium;
                        lower = medium + 1;
                    } else {
                        upper = medium - 1;
                    }
                }
                out.println(res);
            }
        }

        class IntRangeMaximumQuery2D {
            private int[][][][] rmq;

            public IntRangeMaximumQuery2D(int nCapacity, int mCapacity) {
                int nHighBit = 32 - Integer.numberOfLeadingZeros(nCapacity);
                int mHighBit = 32 - Integer.numberOfLeadingZeros(mCapacity);
                rmq = new int[nHighBit][mHighBit][][];
                for (int i = 0; i < nHighBit; ++i)
                    for (int j = 0; j < mHighBit; ++j) {
                        rmq[i][j] = new int[nCapacity - (1 << i) + 1][mCapacity - (1 << j) + 1];
                    }
            }

            public void init(int n, int m, int[][] value) {
                for (int bitI = 0; 1 << bitI <= n; ++bitI) {
                    for (int bitJ = 0; 1 << bitJ <= m; ++bitJ) {
                        for (int i = n - (1 << bitI); i >= 0; --i)
                            for (int j = m - (1 << bitJ); j >= 0; --j) {
                                if (bitI > 0) {
                                    rmq[bitI][bitJ][i][j] = Math.max(
                                            rmq[bitI - 1][bitJ][i][j],
                                            rmq[bitI - 1][bitJ][i + (1 << (bitI - 1))][j]);
                                } else if (bitJ > 0) {
                                    rmq[bitI][bitJ][i][j] = Math.max(
                                            rmq[bitI][bitJ - 1][i][j],
                                            rmq[bitI][bitJ - 1][i][j + (1 << (bitJ - 1))]);
                                } else {
                                    rmq[bitI][bitJ][i][j] = value[i][j];
                                }
                            }
                    }
                }
            }

            public int calc(int x1, int y1, int x2, int y2) {
                int bitX = 31 - Integer.numberOfLeadingZeros(x2 - x1);
                int bitY = 31 - Integer.numberOfLeadingZeros(y2 - y1);
                return Math.max(Math.max(Math.max(
                                        rmq[bitX][bitY][x1][y1],
                                        rmq[bitX][bitY][x2 - (1 << bitX)][y1]),
                                rmq[bitX][bitY][x1][y2 - (1 << bitY)]),
                        rmq[bitX][bitY][x2 - (1 << bitX)][y2 - (1 << bitY)]);
            }

        }

    }

    static class QuickScanner {
        private static final int BUFFER_SIZE = 1024;
        private InputStream stream;
        private byte[] buffer;
        private int currentPosition;
        private int numberOfChars;

        public QuickScanner(InputStream stream) {
            this.stream = stream;
            this.buffer = new byte[BUFFER_SIZE];
            this.currentPosition = 0;
            this.numberOfChars = 0;
        }

        public int next(char[] s) {
            int b = nextNonSpaceChar();
            int res = 0;
            do {
                s[res++] = (char) b;
                b = nextChar();
            } while (!isSpaceChar(b));
            return res;
        }

        public int nextInt() {
            int c = nextNonSpaceChar();
            boolean positive = true;
            if (c == '-') {
                positive = false;
                c = nextChar();
            }
            int res = 0;
            do {
                if (c < '0' || '9' < c) throw new RuntimeException();
                res = res * 10 + c - '0';
                c = nextChar();
            } while (!isSpaceChar(c));
            return positive ? res : -res;
        }

        public int nextNonSpaceChar() {
            int res = nextChar();
            for (; isSpaceChar(res) || res < 0; res = nextChar()) ;
            return res;
        }

        public int nextChar() {
            if (numberOfChars == -1) {
                throw new RuntimeException();
            }
            if (currentPosition >= numberOfChars) {
                currentPosition = 0;
                try {
                    numberOfChars = stream.read(buffer);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                if (numberOfChars <= 0) {
                    return -1;
                }
            }
            return buffer[currentPosition++];
        }

        public boolean isSpaceChar(int c) {
            return c == ' '
                    || c == '\n'
                    || c == '\r'
                    || c == '\t'
                    || c < 0;
        }

    }

    static class QuickWriter {
        private final PrintWriter writer;

        public QuickWriter(OutputStream outputStream) {
            this.writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public QuickWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; ++i) {
                if (i > 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void println(Object... objects) {
            print(objects);
            writer.print('\n');
        }

        public void close() {
            writer.close();
        }

    }

}
