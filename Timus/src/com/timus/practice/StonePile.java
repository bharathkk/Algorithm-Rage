package com.timus.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StonePile {

	static int minimumDiff;
	
	public static void main ( String[] args ) throws NumberFormatException, IOException {
		
		int numOfStones,index = 0;
		int[] listOfStones;
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		StonePile.minimumDiff = 0;
		
		numOfStones = Integer.parseInt(in.readLine());
		listOfStones = new int[numOfStones];
		
		String input = in.readLine();
		
		StringTokenizer st = new StringTokenizer (input," ");
		
		while ( st.hasMoreTokens() ) {
			listOfStones[index] = Integer.parseInt(st.nextToken());
			StonePile.minimumDiff += listOfStones[index];
			index++;
		}
		
		int sum = StonePile.minimumDiff; 
		
		for (int i = 0; i < (1<<numOfStones); i++)
		{
			int temp = 0; 
			for (int j = 0; j < numOfStones; j++)
				if (((1<<j) & i) != 0)
				{
					temp += listOfStones[j];
				}
			if ((StonePile.minimumDiff > (sum - 2 * temp)) && (sum - 2 * temp >= 0))
				StonePile.minimumDiff = sum - 2 * temp; 
		}
		System.out.println(StonePile.minimumDiff);
		
	}
	
	@SuppressWarnings("unused")
	private static void generateSubsets ( int num, int[] numbers, int startIndex, int minDiffSofar ) {
		
		if ( startIndex >= num )
			return;
		if ( numbers == null || num <= 0 )
			return;
		
		for ( int i = startIndex; i < numbers.length; i++ ) {
			
			// create a new subset from the suffix by adding the next possible element from the rest of the elements
			int currentDiff = minDiffSofar - 2 * numbers[i];
			if ( currentDiff < StonePile.minimumDiff && currentDiff >= 0)
				StonePile.minimumDiff = minDiffSofar - 2 * numbers[i];
	
			// Call the generator function recursively if it is possible to generate more subsets
			if ( i + 1 < numbers.length )
				generateSubsets(num,numbers,i+1,minDiffSofar - 2 * numbers[i]);
		}
	}
}
