package com.timus.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DeminDanger {

	public static void main ( String[] args ) throws IOException {
		
		int numOfGroups,index = 0, numVotes = 0;
		int[] groupInfo;
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		
		
		numOfGroups = Integer.parseInt(in.readLine());
		groupInfo = new int[numOfGroups];
		
		String input = in.readLine();
		StringTokenizer st = new StringTokenizer (input," ");
		
		while ( st.hasMoreTokens() ) 
			groupInfo[index++] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(groupInfo);
		
		for ( int i = 0; i < (numOfGroups / 2)+1; i++ ) 
			numVotes += (groupInfo[i] / 2)+1;
		
		System.out.println(numVotes);
	}
}
