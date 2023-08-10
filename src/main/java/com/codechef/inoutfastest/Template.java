package com.codechef.inoutfastest;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Template {


    public static void main(String[] args){
        new Template().run();
    }
    char c[];
    int d[];
    void solve(){
        int k = in.nextInt();
        c = in.next().toCharArray();
        d = new int[c.length+10];
        int cur = 0;
        long ans = 0;
        d[0] = 1;
        out.println(ans);
    }


    class Pair implements Comparable<Pair>{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Pair o) {
            if(o.x == x) return ((Integer) y).compareTo(o.y);
            return ((Integer) x).compareTo(o.x);
        }
    }
    FastScanner in;
    PrintWriter out;
    void run(){
        in = new FastScanner(System.in);
        out = new PrintWriter(new OutputStreamWriter(System.out));
        solve();
        out.close();
    }

    void runIO(){
        try{
            in = new FastScanner(new File("expr.in"));
            out = new PrintWriter(new FileWriter(new File("expr.out")));
            solve();
            out.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    class FastScanner{
        BufferedReader bf;
        StringTokenizer st;
        public FastScanner(File f){
            try{
                bf = new BufferedReader(new FileReader(f));
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        public FastScanner(InputStream is){
            bf = new BufferedReader(new InputStreamReader(is));
        }
        String next(){
            while(st == null || !st.hasMoreTokens()){
                try{
                    st = new StringTokenizer(bf.readLine());
                }
                catch(IOException ex){
                    ex.printStackTrace();
                }
            }
            return st.nextToken();
        }
        char nextChar(){
            return next().charAt(0);
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        float nextFloat(){
            return Float.parseFloat(next());
        }
        String nextLine(){
            try{
                return bf.readLine();
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
            return "";
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        BigInteger nextBigInteger(){
            return new BigInteger(next());
        }
        BigDecimal nextBigDecimal(){
            return new BigDecimal(next());
        }
        int[] nextIntArray(int n){
            int a[] = new int[n];
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(next());
            return a;
        }
        long[] nextLongArray(int n){
            long a[] = new long[n];
            for(int i = 0; i < n; i++)
                a[i] = Long.parseLong(next());
            return a;
        }
    }

}
