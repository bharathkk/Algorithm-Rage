package com.usaco.training;
/*
ID: codin.m1
LANG: JAVA
TASK: milk2
*/

import java.io.*;
import java.util.*;

class milk2 {
	
	static int size;
	static final int MAXSIZE = 1000000;
	
	public static void main ( String[] args ) throws IOException {
		
		BufferedReader bin = new BufferedReader( new FileReader("milk2.in"));
		//BufferedReader bin = new BufferedReader( new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter ( new BufferedWriter(new FileWriter("milk2.out")));
		
		int longestContinous=-1,longestFree=0;
		BitSet timeLine = new BitSet(MAXSIZE);
		size = Integer.parseInt(bin.readLine());
		String inputLine;
		int startInd,endInd;
		
		for ( int i = 0; i < size; i++ ) {
			inputLine=bin.readLine();
			StringTokenizer tokenizer = new StringTokenizer(inputLine," ");
			startInd=Integer.parseInt(tokenizer.nextToken());
			endInd=Integer.parseInt(tokenizer.nextToken());
			timeLine.set(startInd, endInd);
		}
		startInd = timeLine.nextSetBit(0);
		while (true){
			endInd = timeLine.nextClearBit(startInd);
			longestContinous = Math.max(endInd - startInd, longestContinous);
			startInd = timeLine.nextSetBit(endInd);
			if ( startInd == -1)
				break;
		}
		
		startInd = timeLine.nextSetBit(0);
		startInd = timeLine.nextClearBit(startInd);
		while (true){
			endInd = timeLine.nextSetBit(startInd);
			if ( endInd == -1 )
				break;
			longestFree = Math.max(endInd - startInd, longestFree);
			startInd = timeLine.nextClearBit(endInd);
		}
		
		out.println(longestContinous+" "+longestFree);
		out.close();
		bin.close();
		System.exit(0);
	}

}
