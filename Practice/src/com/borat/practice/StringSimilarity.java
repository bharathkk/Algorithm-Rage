package com.borat.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringSimilarity {
	
	static String input;
	static int[] table;
	public static void main ( String[] args ) throws NumberFormatException, IOException {
		
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		
		int numOfCases = Integer.parseInt(bin.readLine());
		int totalSum = 0;
		
		for ( int i = 0 ; i < numOfCases; i++ ) {
			totalSum = 0;
			input = bin.readLine();
			//int len = input.length();
			totalSum = buildTable();
			//totalSum += len;
			System.out.println("Input:"+input+" : "+totalSum);
		}
	}
	
	static int buildTable() {
		
		int len = input.length();
		int total = -1,lastPos = 1;
		table = new int[len];
		table[len-1] = -1;
		if ( input.length() == 1 )
			return total;
		
		table[len - 2] = 0;
		int cnd = len - 1,pos = len - 3;
		
		while ( pos > -1 ) {
			
			if ( input.charAt(pos + 1) == input.charAt(cnd) ) {
				table[pos] = ( len - cnd - 1);
				total += table[pos];
				cnd--;
				System.out.print("("+pos+","+table[pos]+") ");
				pos -= 1;
			}
			else {
				if ( cnd < len - 1 )
					cnd = table[cnd];
				else {
					table[pos] = 0;
					System.out.print("("+pos+","+table[pos]+") ");
					pos -= 1;
				}
			}
		}
		System.out.println("Pos: "+pos+" Cnd: "+cnd);
		return total+1;
	}
}
