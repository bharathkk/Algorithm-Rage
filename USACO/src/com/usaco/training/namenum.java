/*
ID: codin.m1
LANG: JAVA
TASK: namenum
*/
package com.usaco.training;
import java.io.*;
import java.util.*;

class namenum {
	
		char[][] dict = {{'A','B','C'},
						 {'D','E','F'},
						 {'G','H','I'},
						 {'J','K','L'},
						 {'M','N','O'},
						 {'P','R','S'},
						 {'T','U','V'},
						 {'W','X','Y'}
				   		};
		
		public static void main ( String[] args ) throws IOException {
		
		BufferedReader bin = new BufferedReader( new FileReader("namenum.in"));
		BufferedReader in = new BufferedReader( new FileReader("dict.txt"));
		//BufferedReader bin = new BufferedReader( new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter ( new BufferedWriter(new FileWriter("namenum.out")));
		
		HashMap<String,Integer> dictionary = new HashMap<String,Integer>();
		List<String> solution = new ArrayList<String>();
		
		String inputLine;
		while (true) {
			inputLine = in.readLine();
			if (inputLine == null )
				break;
			dictionary.put(inputLine, 1);
		}
		
		int num = Integer.parseInt(bin.readLine());
		num = Integer.reverse(num);
		
		out.close();
		bin.close();
		in.close();
		System.exit(0);
	}
	
	

}
