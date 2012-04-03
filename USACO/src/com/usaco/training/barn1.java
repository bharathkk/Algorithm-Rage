package com.usaco.training;
/*
ID: codin.m1
LANG: JAVA
TASK: barn1
*/
//package USACO;

import java.io.*;
import java.util.*;

public class barn1 {

	public static void main ( String[] args ) throws IOException {
		
		BufferedReader bin = new BufferedReader( new FileReader("barn1.in"));
		//BufferedReader bin = new BufferedReader( new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter ( new BufferedWriter(new FileWriter("barn1.out")));
		int M,S,C;
		int[] cowStalls;
		int[] diff;
		int totalCows = 0;
		StringTokenizer str = new StringTokenizer(bin.readLine());
		M = Integer.parseInt(str.nextToken());
		S = Integer.parseInt(str.nextToken());
		C = Integer.parseInt(str.nextToken());
		cowStalls = new int[C];
		diff = new int[C - 1];
		for ( int i = 0; i < C; i++ ) {
			cowStalls[i] = Integer.parseInt(bin.readLine());
		}
		
		Arrays.sort(cowStalls);
		totalCows = cowStalls[C-1] - cowStalls[0]+1;
		int ind = 0;
		
		for ( int i = 0; i < C - 1; i++ ) {
			int temp = cowStalls[i+1] - cowStalls[i];
			diff[ind++] = temp;	
		}
		Arrays.sort(diff);
		for ( int i = ind - 1; i >= 0 && M > 1 && diff[i] != 0; i--, M-- ) {
			totalCows -= diff[i] - 1;
		}
		
		out.println(totalCows);
		bin.close();
		out.close();
	}
}
