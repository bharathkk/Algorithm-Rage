package com.timus.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SinusDances {

	static int n;
	public static void main ( String[] args ) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		StringBuilder output = new StringBuilder();
		
		for ( int k = 1; k <=n ; k++ )
			if ( n - k != 0 )
				output.append("(");
		
		for ( int i = 1; i <= n ; i++ ) {
			
			for (int j = 1; j <= i; j++ ) {
				output.append("sin(");
				if ( j == i)
					output.append(j);
				else {
					output.append(j+((j%2==0)?"+":"-"));
				}
			}
			
			for ( int k = 1; k<=i; k++ )
				output.append(")");
			
			output.append("+"+(n-i+1));
			if ( n - i != 0 )
				output.append(")");
		}
		
		System.out.println(output);
	}

}
