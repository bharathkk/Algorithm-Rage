package com.usaco.training;
/*
ID: codin.m1
LANG: JAVA
TASK: clocks
*/
//package USACO;

import java.io.*;
import java.util.*;

public class clocks {
	
	/*
	 *  INV - invalid move / padded for programming ease
	 *  Move - Affected Clocks
	 * 		1	- A,B,D,E,INV
	 * 		2 	- A,B,C,INV,INV
	 * 		3	- B,C,E,F,INV
	 * 		4	- A,D,G,INV,INV
	 * 		5	- B,D,E,F,H
	 * 		6	- C,F,I,INV,INV
	 * 		7	- D,E,G,H,INV
	 * 		8	- G,H,I,INV,INV
	 * 		9	- E,F,H,I,INV
	 */
	
	/**
	 * 0 - clock A
	 * 1 - clock B
	 * 2 - clock C
	 * 3 - clock D
	 * 4 - clock E
	 * 5 - clock F
	 * 6 - clock G
	 * 7 - clock H
	 * 8 - clock I
	 */
	static final int[][] moves = {
									{0,1,3,4,99,99},
									{0,1,2,99,99},
									{1,2,4,5,99,99},
									{0,3,6,99,99},
									{1,3,4,5,7},
									{2,5,8,99,99},
									{3,4,6,7,99},
									{6,7,8,99,99},
									{4,5,7,8,99}
								 };
	static int[][] matrix = new int[3][3];
	
	public static void main ( String[] args ) throws IOException {
		
		BufferedReader bin = new BufferedReader( new FileReader("clocks.in"));
		//BufferedReader bin = new BufferedReader( new InputStreamReader(System.in));
		
		
		StringTokenizer str;
		
		for ( int i = 0; i < 3; i++ ) {
			str = new StringTokenizer(bin.readLine());
			matrix[i][0] = Integer.parseInt(str.nextToken());
			matrix[i][1] = Integer.parseInt(str.nextToken());
			matrix[i][2] = Integer.parseInt(str.nextToken());
		}
		bin.close();
		int[] num = new int[9];
		Arrays.fill(num, 0);
		for ( int a = 0; a < 4; a++ )
			for ( int b = 0; b < 4; b++ )
				for ( int c = 0; c < 4; c++ )
					for ( int d = 0; d < 4; d++ )
						for ( int e = 0; e < 4; e++ )
							for ( int f = 0; f < 4; f++ )
								for ( int g = 0; g < 4; g++ )
									for ( int h = 0; h < 4; h++ )
										for ( int j = 0; j < 4; j++ ) {
											num[0] = a;
											num[1] = b;
											num[2] = c;
											num[3] = d;
											num[4] = e;
											num[5] = f;
											num[6] = g;
											num[7] = h;
											num[8] = j;
											if(move(num))
												display(num);
										}
	}
	
	// Checks if all the clocks reached the final state (12)
	static boolean isComplete(int[][] clocks) {
		
		for ( int i = 0; i < 3; i++ )
			for ( int j = 0; j < 3; j++ )
				if ( clocks[i][j] != 12 )
					return false;
		return true;
	}
	
	static boolean move(int[] ind) {
		
		int[][] clocks = new int[3][3];
		int[] temp = new int[9];
		for ( int i = 0; i < 3; i++ ) {
			clocks[i][0] = matrix[i][0];
			clocks[i][1] = matrix[i][1];
			clocks[i][2] = matrix[i][2];
			temp[i] = ind[i];
			temp[i+3] = ind[i+3];
			temp[i+6] = ind[i+6];
		}
			
		for ( int index = 0; index < 9; index++) {
			
			while (temp[index] != 0) {
				for ( int i = 0; i < 5 && moves[index][i] != 99; i++ ) {
					int l = moves[index][i]%3;
					int m = moves[index][i] / 3;
					clocks[m][l] += 3;
					if (clocks[m][l] > 12)
						clocks[m][l] %= 12;
				}
				temp[index]--;
			}
		}
			
		return isComplete(clocks);
	}
	
	
	public static void display(int[] soln) throws IOException {
		PrintWriter out = new PrintWriter ( new BufferedWriter(new FileWriter("clocks.out")));
		StringBuilder str = new StringBuilder();
		
		for ( int i = 0; i < 9; i++ ) {
			while(soln[i] != 0) {
				str.append(i+1+" ");
				soln[i]--;
			}
		}
		out.println(str.substring(0, str.length()-1));
		out.close();
	}
	
}
