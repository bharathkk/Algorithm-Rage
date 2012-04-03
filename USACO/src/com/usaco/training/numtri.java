package com.usaco.training;
/*
ID: codin.m1
LANG: JAVA
TASK: numtri
*/
//package USACO;

import java.io.*;
import java.util.*;


public class numtri {
	
	public static void main ( String[] args ) throws IOException {
		
		BufferedReader bin = new BufferedReader( new FileReader("numtri.in"));
		//BufferedReader bin = new BufferedReader( new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter ( new BufferedWriter(new FileWriter("numtri.out")));
		//PrintWriter out = new PrintWriter( new OutputStreamWriter(System.out));
	
		int rows,size,ind=0;
		rows = Integer.parseInt(bin.readLine());
		size = rows*(rows+1)/2;
		int[] triangles = new int[size];
		StringTokenizer str;
		
		for ( int i = 0; i < rows; i++ ) {
			str = new StringTokenizer(bin.readLine()," ");
			boolean flag = true;
			while (str.hasMoreTokens()) {
				triangles[ind++] = Integer.parseInt(str.nextToken());
				if(flag && ind > 0) {
					flag = false;
					if ( ind != 1 )
						triangles[ind-1] += triangles[ind-1-i];
				}
				else
					if (!str.hasMoreTokens() && ind > 1 ) 
						triangles[ind-1] += triangles[ind-1-(i+1)];
					else
						triangles[ind-1] = Math.max(triangles[ind-1]+triangles[ind-1-i], triangles[ind-1]+triangles[ind-1-i-1]);
			}
		}
		int ans = -1;
		for ( int l=rows-1; l < size; l++ ) 
			if ( ans < triangles[l])
				ans = triangles[l];
		
		out.println(ans);
		bin.close();
		out.close();
	}
}

