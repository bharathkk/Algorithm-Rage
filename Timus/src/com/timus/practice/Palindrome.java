package com.timus.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {

	static String input;
	static int length;
	
	public static void main ( String[] args ) throws IOException {
		
		BufferedReader bin  = new BufferedReader(new InputStreamReader(System.in));
		input = bin.readLine();
		length = input.length();

		boolean flag = false;
		int nTemp,sInd=-1,eInd=-1,num=0,nTmp,len = 0;
		for ( int i = 0; i < length; i++ ) {
			flag = false;
			nTemp = palindrome(i,true);
			nTmp = palindrome(i,false);
			if ( nTmp >= nTemp) {
				flag = true;
				nTemp = nTmp;
			}
			
			
			if ( nTemp >= num ) {
				if ( nTemp == num && flag == false )
					continue;
				if ( nTemp == num && 2*nTemp == len )
					continue;
				num = nTemp;
				sInd = i - num + 1;
				eInd = i + num - 1;
				if (flag)
					eInd++;
				len = eInd - sInd + 1;
			}
		}
		
		if ( sInd != -1 && eInd !=-1 )
			System.out.println(input.substring(sInd, eInd+1));
				
		bin.close();
	}
	
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
			
			if ( sInd < 0 || eInd >= length )
				break;
			
			sCh = input.charAt(sInd);
			eCh = input.charAt(eInd);
			if ( sCh != eCh ) 
					return len;
			len++;
			sInd--;eInd++;	
		}
		return len;
	}
	
}
