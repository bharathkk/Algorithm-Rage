package com.usaco.training;

/*
ID: codin.m1
LANG: JAVA
TASK: friday
*/

import java.io.*;

class friday {

	static int[] freq;
	
	public static void main ( String[] args ) throws IOException {
		
		BufferedReader bin = new BufferedReader( new FileReader("friday.in"));
		PrintWriter out = new PrintWriter ( new BufferedWriter(new FileWriter("friday.out")));
		
		freq = new int[7];
		int smonth = 0;
		int startDate = 1;
		
		int total = Integer.parseInt(bin.readLine());
		int endYear = 1900 + total - 1;
		
		for ( int i = 1900; i <=endYear; i++ ) {
			
			startDate %= 7;
			for ( int j = 0; j < 12; j++ ) {
				smonth = j;
				freq[(startDate + 12)%7]++;
				switch (smonth) {
					
					case 1 : if ( (i % 100 == 0 && i % 400 == 0) || i % 4 == 0 && i % 100 != 0 )
								 startDate += 29;
							 else
								 startDate += 28;
							  break;
							  
					case 3 :
							  
							  
					case 5 :
							  
							  
					case 8 :
							  
							  
					case 10 : startDate += 30;
							  break;
					
					default : startDate += 31;
							  break;
				}
			}
		}
		
		out.print(freq[6]+" ");
		for ( int i = 0; i < 6; i++ )
			if ( i != 5 )
				out.print(freq[i] + " ");
			else
				out.println(freq[i]);
		
		out.close();
		bin.close();
		System.exit(0);
	}
}
