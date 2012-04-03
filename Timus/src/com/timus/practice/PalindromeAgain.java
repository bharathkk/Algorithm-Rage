package com.timus.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromeAgain {

	static String input;
	public static void main ( String[] args ) throws IOException {
		
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		input = bin.readLine();
		int len = input.length();
		int ind = input.length();
		for ( int i = 1 ; i < len; i++ ) 
			if ( palindrome(i,len - 1) ) {
				ind = i;
				break;
			}
		
		StringBuilder output = new StringBuilder();
		output.append(input);
		
		for ( int i = ind - 1; i >=0; i-- )
			output.append(input.charAt(i));
		
		System.out.println(output);
				
	}
	
	static boolean palindrome ( int sind, int eind ) {
		
		while (true) {
			
			if ( !(input.charAt(sind) == input.charAt(eind))) 
				return false;
			sind++;eind--;
			if ( sind > eind )
				break;
		}
		return true;
	
	}
}
