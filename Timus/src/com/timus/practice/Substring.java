package com.timus.practice;

import java.io.*;
import java.util.Arrays;

public class Substring {

	static char[] inp;
	
	public static void main ( String[] args ) throws IOException {
		
		BufferedReader bin = new BufferedReader( new InputStreamReader(System.in));
		String input = bin.readLine();
		inp = input.toCharArray();
		final long CONS = (1<<24);
		boolean[] flags = new boolean[(int)CONS];
		int ctr = 0,ind = 0;
		Arrays.fill(flags, false);
		for ( int i = 0; i < inp.length; i++ ) {
			int hash = 0,g=0;
			for ( int j = i; j < inp.length; j++ ) {
				hash = inp[i] + (hash << 4);
				if ((g = (hash & 0xF0000000)) != 0 ) {
					hash ^= (g >> 24);
					hash ^= g;
				}
				ind = (int)(hash % (CONS));
				if ( ind < 0 )
					ind += (CONS);
				if ( flags[ind] == false ) {
					ctr++;
					flags[ind] = true;
				}
			}
		}
		
		System.out.println(ctr);
	}
}
