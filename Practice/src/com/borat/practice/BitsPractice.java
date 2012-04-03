package com.borat.practice;
import java.util.*;
import java.io.*;

public class BitsPractice {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		BitSet bSet = new BitSet();
		int a = 65536;
		while(a>0) {
			System.out.println(a);
			a&=(a-1);
		}
		bin.close();
	}
}
