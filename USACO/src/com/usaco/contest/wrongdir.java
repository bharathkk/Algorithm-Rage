package com.usaco.contest;
import java.io.*;
import java.util.*;


public class wrongdir {

	public static void main(String[] args) throws IOException {
		//BufferedReader bin = new BufferedReader(new FileReader("wrongdir.in"));
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter out = new PrintWriter(new FileWriter("wrongdir.out"));
		String input = bin.readLine();
		int len = input.length();
		int count = 1;
		for ( int i = 1; i <= len-1; i++ ) {
			if(input.charAt(i) == 'F')
				count += 2;
		}
		
		System.out.println(count);
		bin.close();
		//out.close();
	}
}
