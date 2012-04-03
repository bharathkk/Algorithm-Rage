package com.timus.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class KnuthMorrisPratt {

	static String lastword, spell,sinp;
	static int[] table;
	static List<Integer> substrInd;
	
	public static void main ( String[] args ) throws IOException {
		
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		int numTc = Integer.parseInt(bin.readLine());
		
		for ( int ll = 0; ll < numTc; ll++ ) {
		
			spell = bin.readLine();
			lastword = bin.readLine();
			substrInd = new ArrayList<Integer>();
			
			StringBuilder sinput = new StringBuilder();
			int ind = 0;
			for ( int i = 0; i < lastword.length() - spell.length(); i++ ) {
				sinput.append(spell.charAt(ind++));
				if ( ind == spell.length() )
					ind = 0;
				
			}
			sinp = spell + sinput.toString();
			buildTable();
			
			int m = 0,i = 0,ctr = 0;
			boolean sflag;
			
			while ( m + i < lastword.length() ) {
				
				if ( sinp.charAt(i) == lastword.charAt(m+i) ) {
					i += 1;
					ctr = 0;
				}
				else {
					
					if ( m == 0 && i == 0 ) {
						sflag = false;
						break;
					}
					m = m + i - table[i];
					if ( table[i] > 0 )
						i = table[i];
					else {
						i = 0;
						ctr++;
					}
					substrInd.add(m);
				}
				if ( ctr > 1 && i == 0) 
					sflag = false;
			}
	}

	}
	
	static void buildTable () { 
		
		table = new int[sinp.length()];
		table[0] = -1;
		if ( sinp.length() == 1 )
			return;
		table[1] = 0;
		int pos = 2, cnd = 0;
		
		while ( pos < sinp.length()) {
			
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
