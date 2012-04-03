package com.usaco.training;
/*
ID: codin.m1
LANG: JAVA
TASK: holstein
*/
//package USACO;

import java.io.*;
import java.util.*;

public class holstein {

	static int V;
	public static void main ( String[] args ) throws IOException {
		
		BufferedReader bin = new BufferedReader( new FileReader("holstein.in"));
		//BufferedReader bin = new BufferedReader( new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter ( new BufferedWriter(new FileWriter("holstein.out")));
		//PrintWriter out = new PrintWriter( new OutputStreamWriter(System.out));
		
		int[] vitamins;
		int[][] ingredients;
		int total = 0,min = Integer.MAX_VALUE;
		List<String> solns = new ArrayList<String>();
		List<Integer> soln = new ArrayList<Integer>();
		
		V = Integer.parseInt(bin.readLine());
		vitamins = new int[V];
		StringTokenizer str = new StringTokenizer(bin.readLine());
		
		for ( int i = 0; i < V; i++ ) 
			vitamins[i] = Integer.parseInt(str.nextToken());
		
		total = Integer.parseInt(bin.readLine());
		ingredients = new int[total][V];
		
		for ( int i = 0; i < total; i++ ) {
			str = new StringTokenizer(bin.readLine());
			for ( int j = 0; j < V; j++ ) 
				ingredients[i][j] = Integer.parseInt(str.nextToken());
		}
		
		for ( int i = 0; i < (1<<total); i++ ) {
			boolean flag = false;
			soln.clear();
			StringBuilder ans = new StringBuilder();
			for ( int j = 0; j < total; j++ ) {
				
				if ( ((1<<j)&i) != 0 ) {
					flag = true;
					soln.add(j);
					ans.append((j+1)+" ");
				}
			}
			if(flag) {
				boolean result = isFed(vitamins,ingredients,soln);
				if (soln.size() <= min && result) {
					if ( soln.size() < min )
						solns.clear();
					solns.add(ans.toString());
					min = soln.size();
				}	
			}
		}
		
		out.print(min+" ");
		String ans = solns.get(0);
		int size = ans.length();
		out.print(ans.substring(0, size-1));
		out.println();
		bin.close();
		out.close();
	}
	
	public static final boolean isFed(int[] vitamins, int[][] ingredients, List<Integer> soln) {
		
		boolean result = true;
		int[] temp = new int[V];
		Arrays.fill(temp, 0);
		int size = soln.size();
		
		for ( int j = 0; j < V; j++ ) {
			for ( int i = 0; i < size; i++)
				temp[j] += ingredients[soln.get(i)][j];
			if(temp[j] < vitamins[j])
				return false;
		}
			
		return result;
	}
	
}
