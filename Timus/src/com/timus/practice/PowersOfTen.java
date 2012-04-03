package com.timus.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class PowersOfTen {

	public static void main ( String[] args ) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		int num;
		String input = in.readLine();
		num = Integer.parseInt(input);
		int[][] matrix = new int[num][100];
		
		for ( int i = 0; i < num; i++ ) {
			for ( int j = 0; j<100; j++ )
				matrix[i][j] = -1;
		}
		
		for ( int i = 0; i < num; i++ ) {
			input = in.readLine();
			StringTokenizer st = new StringTokenizer(input," ");
			int ind = 0;
			while ( st.hasMoreTokens() ) {
				matrix[i][ind++] = Integer.parseInt(st.nextToken());
			}
		}
		
		for ( int i = 0; i < num; i++ ) {
			
			int xind = i,yind = 0;
			while ( xind + yind == i && xind >=0 && yind >=0 ) {
				if ( matrix[xind][yind] == -1 )
					break;
				System.out.print(matrix[xind--][yind++]+" ");
			}
		}
		
		for ( int i = 1; matrix[num-1][i] != -1; i++ ) {
			
			int xind = num - 1,yind = i, sum = xind + yind;
			while ( xind + yind == sum && xind >=0 && yind >=0 ) {
				if ( matrix[xind][yind] == -1 )
					break;
				System.out.print(matrix[xind--][yind++]+" ");
			}
		}
		
		in.close();
	}
	
}
