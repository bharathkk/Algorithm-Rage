package com.usaco.training;
/*
ID: codin.m1
LANG: JAVA
TASK: lamps
*/
//package USACO;
import java.io.*;
import java.util.*;

class lamps {
	
	static int[] states,on,off;
	static int numSolns=0,n;
	static String[] solns = new String[16];
	public static void main ( String[] args ) throws IOException {
		
		BufferedReader bin = new BufferedReader( new FileReader("lamps.in"));
		//BufferedReader bin = new BufferedReader( new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter ( new BufferedWriter(new FileWriter("lamps.out")));
		//PrintWriter out = new PrintWriter ( new BufferedWriter(new OutputStreamWriter(System.out)));
		int c,temp,count;
		n = Integer.parseInt(bin.readLine());
		c = Integer.parseInt(bin.readLine());
		states = new int[n];
		on = new int[n];
		off = new int[n];
		int ind = 0;
		Arrays.fill(on, -1);
		Arrays.fill(off, -1);
		
		StringTokenizer str = new StringTokenizer(bin.readLine());
		while(str.hasMoreTokens()) {
			ind = Integer.parseInt(str.nextToken());
			if(ind != -1)
				on[ind-1] = 1;
			else
				break;
		}
		str = new StringTokenizer(bin.readLine());
		while(str.hasMoreTokens()) {
			ind = Integer.parseInt(str.nextToken());
			if(ind != -1)
				off[ind-1] = 0;
			else
				break;
		}
		
		for ( int i = 0; i < 16; i++) {
			temp = i;
			count = 0;
			while(temp != 0) {
				temp &= (temp-1);
				count++;
			}
			if(count % 2 == c % 2 && count <= c) {
				Arrays.fill(states, 1);
				perform(i);
			}
		}
		if(numSolns == 0)
			out.println("IMPOSSIBLE");
		else {
			Arrays.sort(solns,0,numSolns);
			for ( int i = 0; i < numSolns; i++)
				if(!solns[i].equals(solns[i+1]))
					out.println(solns[i]);
		}
		
		out.close();
		bin.close();
		
	}
	
	public static void perform(int i) {
		StringBuilder soln = new StringBuilder();
		if((i&1) != 0) 
			for ( int ii = 0; ii < n; ii++ ) 
				states[ii] = 1 - states[ii];
		
		if((i&2) != 0) 
			for ( int ii = 0; ii < n; ii+=2 ) 
				states[ii] = 1 - states[ii];
		
		if((i&4) != 0) 
			for ( int ii = 1; ii < n; ii+=2 ) 
				states[ii] = 1 - states[ii];
		
		if((i&8) != 0) 
			for ( int ii = 0; ii*3 < n; ii++ ) 
				states[ii*3] = 1 - states[ii*3];
		
		
		for ( int ii = 0; ii < n; ii++ ) {
			if(on[ii] != -1 && on[ii] != states[ii])
				return;
			if(off[ii] != -1 && off[ii] != states[ii])
				return;
		}
		
		for ( int ii = 0; ii < n; ii++ ) 
			soln.append(states[ii]);
		
		solns[numSolns++] = soln.toString();
	}
	
	
}
