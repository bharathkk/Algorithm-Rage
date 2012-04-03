package com.borat.practice;

import java.io.*;
import java.util.*;

public class Prime {
	
	final static int SIZE = 31623;
	static boolean[] primes;
	public static void main(String[] args) throws IOException {
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		
		int numTests;
		long[][] range;
		numTests = Integer.parseInt(bin.readLine());
		range = new long[numTests][2];
		StringTokenizer str;
		
		//boolean[] ranges;
		boolean flag;
		primes = new boolean[SIZE];
		Arrays.fill(primes, true);
		primes[0] = false;
		primes[1] = false;
		StringBuilder ans = new StringBuilder();
		for ( int i = 2; i < 178; i++ ) {
			if(primes[i]) {
				for(int k = i*2; k < SIZE; k += i)
					primes[k] = false;
			}
		}
		
		for ( int i = 0; i < numTests; i++ ) {
			str = new StringTokenizer(bin.readLine());
			range[i][0] = Long.parseLong(str.nextToken());
			range[i][1] = Long.parseLong(str.nextToken());
//			ranges = new boolean[(int)(range[i][1] - range[i][0] )+ 1];
//			Arrays.fill(ranges, true);
//			for ( int cc = 0; cc + range[i][0] <= 1; cc++)
//				ranges[cc] = false;
//			int len = ranges.length;
//			int limit = Math.min(SIZE, (int)(Math.sqrt(range[i][1]))+1);
//			for ( int k = 0; k < limit; k++ ) {
//				if(primes[k]) {
//					for ( int l = 0; l < len; l++ ) {
//						if((l + range[i][0])% k == 0 && (l+range[i][0] !=k) && ranges[l])
//							ranges[l] = false;
//					}
//				}
//			}
//			for ( int l = 0; l < len; l++ )
//				if(ranges[l]) {
//					ans.append((range[i][0]+l)+"\n");
//				}
			int start = (int)range[i][0];
			if(start == 1)
				start++;
			if(start == 2) 
				ans.append(2+"\n");
			if(start % 2 == 0)
				start++;
			long end = range[i][1];
			for ( ; start <= end; start += 2 ) {
				flag = true;
				for ( int cc = 2; cc*cc <= start; cc++ )
					if(primes[cc]) {
						if(start % cc == 0) {
							flag = false;
							break;
						}
					}
				if(flag)
					ans.append(start+"\n");
			}
			
			if(i != numTests -1 )
				ans.append("\n");
		}
		System.out.print(ans.toString());
	}
	
}
