package com.timus.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class StringTale {

	
	private static String output,input;
	
	public static void main ( String[] args ) throws IOException {
		
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(bin.readLine());
		input = bin.readLine();
		output = bin.readLine();
		
		boolean flag = false;
		if ( input.length() != output.length() ) {
			System.out.println(-1);
			System.exit(0);
		}
		if ( input.equals(output)) {
			System.out.println(0);
			System.exit(0);
		}
		
		for ( int i = 1; i < input.length(); i++ ) {
			
			if ( output.substring(num - i).hashCode() == input.substring(0,i).hashCode() ) 
				if ( output.substring(0,num-i).hashCode() == input.substring(i).hashCode()) {
					System.out.println(num - i);
					flag = true;
					break;
				}
		}
		
		if ( flag == false )
			System.out.println(-1);
	}
	
	@Override
	public int hashCode() {
	    int h = 0;
	    int len = input.length();
	    for (int i = 0; i < len/2; i++) {
	        h = 31 * h + input.charAt(i) +input.charAt(len - i - 1);
	    }
	    return h;
	}
}
