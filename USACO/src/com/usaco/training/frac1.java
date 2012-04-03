/*
ID: codin.m1
LANG: JAVA
TASK: frac1
*/
package com.usaco.training;

import java.io.*;
import java.util.*;


public class frac1 {
	
	static int size;
	static double[][] fractions;
	public static void main ( String[] args ) throws IOException {
		
		//BufferedReader bin = new BufferedReader( new FileReader("frac1.in"));
		BufferedReader bin = new BufferedReader( new InputStreamReader(System.in));
		//PrintWriter out = new PrintWriter ( new BufferedWriter(new FileWriter("frac1.out")));
		PrintWriter out = new PrintWriter( new OutputStreamWriter(System.out));

		size = Integer.parseInt(bin.readLine());
		if ( size == 1 ) {
			out.println("0/1\n1/1");
			bin.close();
			out.close();
			System.exit(0);
		}
		int n = size * (size-1)/2,ind = 0;
		fractions = new double[n][3];
		
		for ( int i = 1; i < size; i++ ) {
			for ( int j = i+1; j <= size; j++) {
				fractions[ind][0] = (double)i/(double)j;
				fractions[ind][1] = i;
				fractions[ind++][2] = j;
			}
		}
		
		Arrays.sort(fractions,new fractionComparator());
		
		out.println("0/1");
		double val = 0;
		for ( int i = 0; i < ind; i++ ) {
			if( fractions[i][0] != val)
				out.println((int)fractions[i][1]+"/"+(int)fractions[i][2]);
			val = fractions[i][0];
		}
		out.println("1/1");
		bin.close();
		out.close();
	}
}

class fractionComparator implements Comparator<double[]> {

	@Override
	public int compare(double[] a, double[] b) {
		if(a[0] > b[0])
			return 1;
		if (a[0] < b[0])
			return -1;
		return 0;
	}
	
}

