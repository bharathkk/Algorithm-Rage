package com.usaco.training;
/*
ID: codin.m1
LANG: JAVA
TASK: sort3
*/
//package USACO;

import java.io.*;


public class sort3 {
	
	public static void main ( String[] args ) throws IOException {
		
		BufferedReader bin = new BufferedReader( new FileReader("sort3.in"));
		//BufferedReader bin = new BufferedReader( new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter ( new BufferedWriter(new FileWriter("sort3.out")));
		//PrintWriter out = new PrintWriter( new OutputStreamWriter(System.out));
		int numSeq,onesIntwos=0,onesInthree=0,threeIntwos = 0,twosInthree;
		int[] sequence;
		int numOnes=0,numTwo=0;
		
		numSeq = Integer.parseInt(bin.readLine());
		sequence = new int[numSeq];
		for ( int i = 0; i < numSeq; i++ ) {
			sequence[i] = Integer.parseInt(bin.readLine());
			if (sequence[i] == 1) 
				numOnes++;
			if (sequence[i] == 2) 
				numTwo++;
		}
		
		for ( int i = numOnes; i < numSeq; i++ ) {
			if ( sequence[i] == 1 ) {
				if( i < numOnes + numTwo )
					onesIntwos++;
				else
					onesInthree++;
			}
			if( sequence[i] == 3 && i < numOnes + numTwo )
				threeIntwos++;
			   
		}
		int numOperations = 0;
		for ( int i = 0; i < numOnes; i++ ) {
			if ( sequence[i] == 2 ) {
				if (onesIntwos != 0)
					onesIntwos--;
				else {
					onesInthree--;
					numOperations++;
					threeIntwos--;
				}
				numOperations++;
			}
			if ( sequence[i] == 3 ) {
				if (onesInthree != 0)
					onesInthree--;
				else {
					onesIntwos--;
					threeIntwos++;
				}
				numOperations++;
			}
		}
		
		if (threeIntwos > 0)
			numOperations += threeIntwos;
		
		out.println(numOperations);
		bin.close();
		out.close();
	}
}
