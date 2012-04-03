package com.usaco.training;
/*
ID: codin.m1
LANG: JAVA
TASK: preface
*/
//package USACO;

import java.io.*;


public class preface {
	
	static int[] romanEq = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
	static String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
	static char[] romanCh = {'I','V','X','L','C','D','M'};
	static int[] count = {0,0,0,0,0,0,0};
	
	
	public static void main ( String[] args ) throws Exception {
		
		BufferedReader bin = new BufferedReader( new FileReader("preface.in"));
		//BufferedReader bin = new BufferedReader( new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter ( new BufferedWriter(new FileWriter("preface.out")));
		//PrintWriter out = new PrintWriter( new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(bin.readLine()),len;
		String output;
		for ( int i = 1; i <= num; i++ ) {
			output = romanNumeral(i);
			len = output.length();
			for ( int j = 0; j < len; j++ )
				for ( int k = 0; k < 7; k++ ) {
					if(romanCh[k] == output.charAt(j))
						count[k]++;
				}
		}
		for ( int i = 0; i < 7; i++ ) {
			if(count[i] > 0) {
				out.println(romanCh[i]+" "+count[i]);
			}
		}
		bin.close();
		out.close();
	}
	
	public static String romanNumeral(int num) throws Exception {
		
		StringBuilder soln = new StringBuilder();
		int numCopy = num;
		
		for ( int i = 0; i < 13; i++ ) {
			
			while(numCopy >= romanEq[i]) {
				soln.append(roman[i]);
				numCopy -= romanEq[i];
			}
		}
		
		return soln.toString();
	}
}

