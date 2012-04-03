package com.usaco.training;
/*
ID: codin.m1
LANG: JAVA
TASK: sprime
*/
//package USACO;

import java.io.*;
import java.util.*;


public class sprime {
	
	public static void main ( String[] args ) throws IOException {
		
		BufferedReader bin = new BufferedReader( new FileReader("sprime.in"));
		//BufferedReader bin = new BufferedReader( new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter ( new BufferedWriter(new FileWriter("sprime.out")));
		//PrintWriter out = new PrintWriter( new OutputStreamWriter(System.out));
		int n = Integer.parseInt(bin.readLine());
		
		List<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		primes.add(3);
		primes.add(5);
		primes.add(7);
		
		for ( int i = 1; i < n; i++ ) {
			
			int len = primes.size();
			
			for ( int j = 0; j < len; j++ ) {
				int temp = primes.remove(0);
				for ( int k = 1; k <= 9; k+=2 ) {
					if( k == 5 )
						continue;
					temp *= 10;
					temp += k;
					if(isPrime(temp))
						primes.add(temp);
					temp /= 10;
				}
			}
		}
		
		int size = primes.size();
		for ( int i = 0; i < size; i++ )
			out.println(primes.get(i));
		
		bin.close();
		out.close();
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

