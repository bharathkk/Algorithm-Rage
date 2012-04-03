package com.codeforce.practice;
import java.io.*;
import java.util.*;

public class Main {
	
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
		int beg,end;
		int total = in.nextInt();
		int[][] matrix = new int[total][total];
		
		for ( int i = 0; i < total; i++ ) 
			for ( int j = 0; j < total; j++ )
			matrix[i][j] = in.nextInt();
		beg = 0;
		long l = System.currentTimeMillis();
		while(true) {
			
			if(beg >= total/2)
				break;
			end = total - 1 - beg;
			printSpiral(matrix,beg,end);
//			if(beg % 2 == 0)
//				rotateClockWise(matrix,beg,end);
//			else
//				rotateAntiClockWise(matrix,beg,end);
			beg++;
		}
		if(total % 2 != 0 )
			printSpiral(matrix,beg,total-1-beg);
		out.println();
		for ( int i = 0; i < total; i++ ) { 
			for ( int j = 0; j < total; j++ ) { 
				out.print(matrix[i][j]);
				if(j != total - 1)
					out.print(" ");
			}
			out.println();
		}
		out.println((System.currentTimeMillis() - l)/1000);
		out.close();
		in.close();
	}
	
	public static void printSpiral(int[][] matrix, int beg, int end ) {
		
		for(int i = beg; i <= end; i++) 
			System.out.print(matrix[beg][i]);
		
		for (int i = beg + 1; i < end; i++) 
			System.out.print(matrix[i][end]);
		
		for (int i = end; i > beg; i-- )
			System.out.print(matrix[end][i]);
		
		for ( int i = end; i > beg; i--) 
			System.out.print(matrix[i][beg]);
	}
	
	public static void rotateClockWise(int[][] matrix, int beg, int end) {
		int temp = matrix[beg][beg];
		int tmp = 0;
		
		for(int i = beg + 1; i <= end; i++) {
			tmp = temp;
			temp = matrix[beg][i];
			matrix[beg][i] = tmp;
		}
		
		for (int i = beg + 1; i <= end; i++) {
			tmp = temp;
			temp = matrix[i][end];
			matrix[i][end] = tmp;
		}
		
		for (int i = end - 1; i >= beg; i-- ) {
			tmp = temp;
			temp = matrix[end][i];
			matrix[end][i] = tmp;
		}
		
		for ( int i = end - 1; i >= beg; i--) {
			tmp = temp;
			temp = matrix[i][beg];
			matrix[i][beg] = tmp;
		}
	}
	
	public static void rotateAntiClockWise(int[][] matrix, int beg, int end) {
		int temp = matrix[beg][end];
		int tmp;
		for (int i = end - 1; i >= beg; i-- ) {
			tmp = temp;
			temp = matrix[beg][i];
			matrix[beg][i] = tmp;
		}
		
		for (int i = beg + 1; i <= end; i++) {
			tmp = temp;
			temp = matrix[i][beg];
			matrix[i][beg] = tmp;
		}
		
		for(int i = beg + 1; i <= end; i++) {
			tmp = temp;
			temp = matrix[end][i];
			matrix[end][i] = tmp;
		}
		
		for ( int i = end - 1; i >= beg; i--) {
			tmp = temp;
			temp = matrix[i][end];
			matrix[i][end] = tmp;
		}
		
	}
}

