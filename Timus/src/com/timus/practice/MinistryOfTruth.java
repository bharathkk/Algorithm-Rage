package com.timus.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MinistryOfTruth {

	static String input,allowed;
	static int[] table;
	
	public static void main ( String[] args ) throws IOException {
		
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		int[] index;
		
		input = bin.readLine();
		allowed = bin.readLine();
		
		StringTokenizer str = new StringTokenizer(allowed," ");
		
		int len = str.countTokens();
		int size = input.length();
		index = new int[2*len];
		index[0] = 0;
		boolean sflag = false;
		int m = 0, i = 0,ind = 0;
		while ( str.hasMoreTokens() ) {
			
			String temp = str.nextToken();
			buildTable(temp);
			i = 0;
			if ( m == -1 ) {
				sflag = true;
				break;
			}
			
			while ( m + i < size ) {
				
				if ( temp.charAt(i) == input.charAt(m+i) ) {
					if ( i == temp.length() - 1) 
						break;
					i += 1;
				}
				else {
					m = m + i - table[i];
					if ( table[i] > 0 )
						i = table[i];
					else 
						i = 0;
				}
				
			}
			
			if ( m + i < size ) {
				index[ind++] = m;
				index[ind++] = m + i;
			}
			else {
				sflag = true;
				break;
			}
			m = m+i+2;
			
		}
		
		if (!sflag) {
			
			int k = 0,j = 0;
			
			while ( k < size ) {
				
				while ( k < index[j] ) {
					if ( input.charAt(k) != ' ')
						System.out.print('_');
					else
						System.out.print(' ');
					k++;
				}
				
				for ( int l = index[j]; l <=index[j+1]; l++ ) 
					System.out.print(input.charAt(l));
				
				k = index[j+1]+1;
				j += 2;
				if ( j == 2*len ) {
					for ( int l = k; l < size; l++)
						if ( input.charAt(l) != ' ')
							System.out.print('_');
						else
							System.out.print(' ');
					break;
				}
			}
		}
		else
			System.out.println("I HAVE FAILED!!!");
		
	}
	
	static void buildTable ( String sinp ) { 
		
		table = null;
		int len = sinp.length();
		table = new int[len];
		table[0] = -1;
		if ( len == 1 )
			return;
		table[1] = 0;
		int pos = 2, cnd = 0;
		
		while ( pos < len) {
			
			if ( sinp.charAt(pos - 1) == sinp.charAt(cnd) ) {
				cnd += 1;
				table[pos] = cnd;
				pos += 1;
			}
			else {
				if ( cnd > 0 ) {
					cnd = table[cnd];
				}
				else {
					table[pos] = 0;
					pos += 1;
				}
			}
		}
	}
	
}
