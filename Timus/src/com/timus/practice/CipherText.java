package com.timus.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class CipherText {

	public static void main ( String[] args ) throws IOException {
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		String input = in.readLine();
		Stack<Character> solution = new Stack<Character>();
		int len = input.length();
		for ( int i = 0; i < len; i++ ) {
			char ch = input.charAt(i);
			if (solution.isEmpty()) {
				solution.push(ch);
				continue;
			}
			
			if ( ch == solution.peek() )
				solution.pop();
			else
				solution.push(ch);
		}
		
		Object[] sol = solution.toArray();
		len = sol.length;
		
		for ( int i = 0; i < len; i++ )
			System.out.print(sol[i]);
		System.out.println();
		in.close();
	}
}
