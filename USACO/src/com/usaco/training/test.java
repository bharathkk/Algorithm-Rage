package com.usaco.training;

/*
ID: codin.m1
LANG: JAVA
TASK: test
*/

import java.io.*;
import java.util.*;

class test {

	public static void main ( String[] args ) throws IOException {
		
		BufferedReader bin = new BufferedReader( new FileReader("file.in"));
		PrintWriter out = new PrintWriter ( new BufferedWriter(new FileWriter("vans.out")));
		
		StringTokenizer str = new StringTokenizer(bin.readLine());
		int num1 = Integer.parseInt(str.nextToken());
		int num2 = Integer.parseInt(str.nextToken());
		out.println(num1+num2);
		out.close();
		bin.close();
		System.exit(0);
	}
}
