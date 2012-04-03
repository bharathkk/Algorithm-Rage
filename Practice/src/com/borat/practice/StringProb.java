package com.borat.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringProb {

	/*
 	A = 1>>2;
	B = 1>>1;
	C = 1>>0;
	*/
	
	public static void main ( String[] args ) throws NumberFormatException, IOException {
		
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		
		int testnum = Integer.parseInt(bin.readLine());
		
		
		for ( int test = 0; test < testnum; test++ ) {
			
			String input = bin.readLine();
			int num = input.length();
			int[][][] mincost;
			mincost = new int[num][num][2];
			
			
			for ( int i = 0; i < num; i ++ ) {	
				mincost[i][i][0] = 1;
				mincost[i][i][1] = 1<<('c'-input.charAt(i));
			}
			
			for ( int i = 2; i <=num; i++ ) {
				for ( int j = 0; j < num - i + 1; j++ ) {
					int k = j + i - 1;
					mincost[j][k][0] = Integer.MAX_VALUE;
					mincost[j][k][1] = 0;
					
					for ( int l = j; l <= k-1; l++ ) {
						int cost = (mincost[j][l][1] ^ mincost[l+1][k][1]);
						int len = mincost[j][l][0] + mincost[l+1][k][0] - (cost>0?1:0);
						
						if ( len < mincost[j][k][0] ) {
							mincost[j][k][0] = len;
							if ( cost != 0)
								mincost[j][k][1] = 7 - cost;
							else
								mincost[j][k][1] = mincost[j][l][1];
						}
					}
				}
			}
			
			System.out.println(mincost[0][num-1][0]);
		}
	}
}
