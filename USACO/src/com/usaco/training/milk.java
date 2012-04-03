package com.usaco.training;
/*
ID: codin.m1
LANG: JAVA
TASK: milk
*/
//package USACO;
import java.io.*;
import java.util.*;

class milk {

	static int[][] cost;
	static int[] index;
	
	public static void main ( String[] args ) throws IOException {
		
		BufferedReader bin = new BufferedReader( new FileReader("milk.in"));
		//BufferedReader bin = new BufferedReader( new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter ( new BufferedWriter(new FileWriter("milk.out")));
		
		StringTokenizer str = new StringTokenizer(bin.readLine());
		int totalAmount = Integer.parseInt(str.nextToken(" "));
		int totalFarmers = Integer.parseInt(str.nextToken(" "));
		
		cost = new int[totalFarmers][2];
		index = new int[totalFarmers];
		
		for ( int i = 0; i < totalFarmers; i++ ) {
			str = new StringTokenizer(bin.readLine());
			cost[i][0] = Integer.parseInt(str.nextToken(" "));
			cost[i][1] = Integer.parseInt(str.nextToken(" "));
			index[i] = i;
		}
		int temp,amt;
		amt = totalAmount;
		for ( int i = 0; i < totalFarmers; i++ )
			for ( int j = i+1; j < totalFarmers; j++ ) 
				if ( cost[index[i]][0] > cost[index[j]][0] ) {
					temp = index[i];
					index[i] = index[j];
					index[j] = temp;
				}
		
		int ind = 0,costs = 0;
		while (amt != 0) {
			
			temp = amt - cost[index[ind]][1];
			
			if ( temp > 0 ) 
				costs += cost[index[ind]][0] * cost[index[ind]][1];
			else {
				costs += cost[index[ind]][0] * amt;
				break;
			}
			amt = temp;
			ind++;
		}
		out.println(costs);
		out.close();
		bin.close();
		System.exit(0);
	}
}
