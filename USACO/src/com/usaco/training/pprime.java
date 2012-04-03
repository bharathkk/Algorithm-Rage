package com.usaco.training;
/*
ID: codin.m1
LANG: JAVA
TASK: pprime
*/
//package USACO;

import java.io.*;
import java.util.*;


public class pprime {
	
	static List<Integer> palin = new ArrayList<Integer>();	
	
	public static void main ( String[] args ) throws IOException {
		
		BufferedReader bin = new BufferedReader( new FileReader("pprime.in"));
		//BufferedReader bin = new BufferedReader( new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter ( new BufferedWriter(new FileWriter("pprime.out")));
		//PrintWriter out = new PrintWriter( new OutputStreamWriter(System.out));
		int lenA,lenB,numA,numB;
		String inpA,inpB;
		StringTokenizer str = new StringTokenizer(bin.readLine());
		inpA = str.nextToken();
		numA = Integer.parseInt(inpA);
		inpB = str.nextToken();
		numB = Integer.parseInt(inpB);
		lenA = inpA.length();
		lenB = inpB.length();
		palin.add(5);
		palin.add(7);
		palin.add(11);
		
		
		for ( int i = Math.max(3, lenA); i <= lenB; i++ ) {
			
			switch(i) {
				case 3: generate3();
						break;
				case 5: generate5();
						break;
				case 7: generate7();
						break;
			}
		}
		
		int size = palin.size();
		for ( int i = 0; i < size; i++ ) {
			if ( palin.get(i) < numA )
				continue;
			if ( palin.get(i) > numB )
				break;
			if(isPrime(palin.get(i)))
				out.println(palin.get(i));
		}
		
		bin.close();
		out.close();
	}
	
	public static void generate3() {
		
		for ( int i = 1; i < 10; i+= 2 ) {
			for ( int j = 0; j < 10; j++ ) {
				int tmp = i*100+j*10+i;
				if (isPrime(tmp))
					palin.add(tmp);
			}
		}
	}
	
	public static void generate5() {
		
		for ( int i = 1; i < 10; i+= 2 ) {
			for ( int j = 0; j < 10; j++ ) 
				for ( int k = 0; k < 10; k++ ) {
					int tmp = i*10000+j*1000+k*100+j*10+i;
					if (isPrime(tmp))
						palin.add(tmp);
				}
		}
	}
	
	public static void generate7() {
		
		for ( int i = 1; i < 10; i+= 2 )
			for ( int j = 0; j < 10; j++ )
				for ( int k = 0; k < 10; k++ )
					for ( int l = 0; l < 10; l++ ) {
						int tmp = i*1000000+j*100000+k*10000+l*1000+k*100+j*10+i;
						if (isPrime(tmp))
							palin.add(tmp);
					}
	}
	
	
	public static boolean isPrime ( int n) {
		if ( n == 2 )
			return true;
		if ( n == 0 || n == 1 || n % 2 == 0)
			return false;
		
		int sqrt = (int) Math.sqrt(n);
		
		for ( int i = 3; i <=sqrt; i++ )
			if ( n % i == 0 )
				return false;
		
		return true;
	}
}

