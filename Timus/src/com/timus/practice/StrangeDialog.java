package com.timus.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StrangeDialog {

	static final int[] alph = {0,0,0,0,1,0,0,0,2,0,0,0,0,3,4,5,0,0,0,6,7,0,0,0,0,0};
				
	static final int[][] states = {{99,99,4,99,13,8,99,99},
			   {99,99,4,99,13,5,99,99},
			   {99,99,4,99,7,8,99,99},
			   {99,0,4,99,13,8,99,99},
			   {99,99,99,1,99,99,99,99},
			   {99,99,99,99,99,99,99,6},
			   {99,99,99,99,99,99,2,99},
			   {99,99,99,3,99,99,99,14},
			   {99,99,99,99,99,99,99,9},
			   {99,99,99,99,99,99,10,99},
			   {99,99,99,99,11,99,99,99},
			   {99,99,99,0,99,99,99,99},
			   {99,0,99,99,99,99,99,99},
			   {99,99,99,12,99,99,99,14},
			   {99,99,99,99,99,99,1,99}
			   };
	
	public static void main ( String[] args ) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		int num = Integer.parseInt(in.readLine());
		int ch;
		
		for ( int i = 0; i < num; i++ ) {
			int start = 0;
			ch = in.read();
			while (ch != 10 && ch != -1) {
				if (start != 99 && ch != '\r')
					start = states[start][alph[ch - 'a']];
				ch = in.read();
			}
			if (start < 4)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		
		in.close();
	}
}
