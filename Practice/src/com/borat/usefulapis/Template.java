package com.borat.usefulapis;
import java.io.*;
import java.util.*;

public class Template {
	
	static class InputReader {
		BufferedReader bin;
		StringTokenizer tokenizer;
		
		public InputReader(InputStream in) {
			bin = new BufferedReader(new InputStreamReader(in));
			tokenizer = null;
		}
		
		public String next() {
			
			while( tokenizer == null || !tokenizer.hasMoreTokens())  {
				try {
					tokenizer = new StringTokenizer(bin.readLine());
				} catch(IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
		
		public String readLine() {
			try {
				return bin.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		
		public int nextInt() {
			return Integer.parseInt(next());
		}
		
		public long nextLong() {
			return Long.parseLong(next());
		}
		
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		
		public float nextFloat() {
			return Float.parseFloat(next());
		}
		
		public void close() {
			try {
				bin.close();
				tokenizer = null;
			} catch ( IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		
		out.close();
		in.close();
	}
}

