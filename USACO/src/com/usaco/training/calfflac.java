/*
ID: codin.m1
LANG: JAVA
TASK: calfflac
*/
package com.usaco.training;
import java.io.*;
import java.util.*;

class calfflac {
	
	static String input;
	static String palin;
	static int length;
	
	static int palindrome ( int ind, boolean flag ) {
		int sInd,eInd,len;
		char sCh,eCh;
		if (flag) {
			sInd = ind - 1;
			eInd = ind + 1;
			len = 1;
		}
		else {
			sInd = ind;
			eInd  = ind + 1;
			len = 0;
		}
		
		while (true) {
			
			if ( sInd < 0 || sInd < ind - 1000 || eInd >= length || eInd > ind + 1000 )
				break;
			
			sCh = palin.charAt(sInd);
			eCh = palin.charAt(eInd);
			if ( sCh != eCh ) 
					return len;
			len++;
			sInd--;eInd++;	
		}
		return len;
	}
	
	public static void main ( String[] args ) throws IOException {
		
		BufferedReader bin = new BufferedReader( new FileReader("calfflac.in"));
		//BufferedReader bin = new BufferedReader( new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter ( new BufferedWriter(new FileWriter("calfflac.out")));
		String inputLine;
		int num = 0;
		StringBuilder temp = new StringBuilder();
		StringBuilder tmp = new StringBuilder();
		int[] table;
		table = new int[20000];
		int len = 0;
		int ctr = 0,ctr2 = 0;

		while (true) {
			
			inputLine = bin.readLine();
			if (inputLine == null)
				break;
			tmp.append(inputLine);
			tmp.append("\n");
			len = inputLine.length();
			for ( int i = 0; i < len; i++ ) {
				if ( Character.isLetter(inputLine.charAt(i)) ) {
					temp.append(inputLine.charAt(i));
					table[ctr2] = ctr;
					ctr2++;
				}
				ctr++;
			}
			ctr++;
		}
		
		input = tmp.toString();
		palin = temp.toString().toLowerCase();
		temp = null;
		length = palin.length();
		boolean flag = false;
		int nTemp,sInd=-1,eInd=-1;
		for ( int i = 0; i < length; i++ ) {
			flag = false;
			nTemp = palindrome(i,true);
			if (nTemp == 1) {
				nTemp = palindrome(i,false);
				flag = true;
			}
			
			if ( nTemp > num ) {
				num = nTemp;
				sInd = i - num + 1;
				eInd = i + num - 1;
				if (flag)
					eInd++;
				len = eInd - sInd + 1;
			}
		}
				
		if (sInd == -1) {
			out.println(0);
		}
		else {
			sInd = table[sInd];
			eInd = table[eInd];
			out.println(len);
			if ( sInd > eInd )
				out.println(input.substring(eInd, sInd+1));
			else
				out.println(input.substring(sInd, eInd+1));
		}
		out.close();
		bin.close();
		System.exit(0);
	}
		

}
