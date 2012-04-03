package com.usaco.training;

/*
ID: codin.m1
LANG: JAVA
TASK: gift1
*/

import java.io.*;
import java.util.*;

class gift1 {

	public static void main ( String[] args ) throws IOException {
		
		BufferedReader bin = new BufferedReader( new FileReader("gift1.in"));
		PrintWriter out = new PrintWriter ( new BufferedWriter(new FileWriter("gift1.out")));
		
		int total = Integer.parseInt(bin.readLine());
		int[] credit,debit;
		credit = new int[total];
		debit = new int[total];
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		List<String> names = new ArrayList<String>();
		
		for ( int i = 0; i < total; i++ ) {
			String mem = bin.readLine();
			map.put(mem, i);
			names.add(mem);
			credit[i] = 0;
			debit[i] = 0;
		}
		
		for (int k = 0; k < total; k++ ) {
			
			String memName = bin.readLine();
			StringTokenizer str = new StringTokenizer(bin.readLine());
			int ind = map.get(memName);
			debit[ind] = Integer.parseInt(str.nextToken());
			int nReceivers = Integer.parseInt(str.nextToken());
			
			if ( nReceivers != 0 ) {
				credit[ind] += debit[ind] % nReceivers;
				int giftamt = debit[ind] / nReceivers;
				for ( int i = 0; i < nReceivers; i++ ) {
					String mem = bin.readLine();
					int memInd = map.get(mem);
					credit[memInd] += giftamt;
				}
			}
		}
		
		for ( int i = 0; i < total; i++ ) {
			String mem = names.get(i);
			int index = map.get(mem);
			out.println(mem+" "+(credit[index] - debit[index]));
		}
		
		out.close();
		bin.close();
		System.exit(0);
	}
}
