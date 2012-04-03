package com.usaco.training;
/*
ID: codin.m1
LANG: JAVA
TASK: transform
*/
//package USACO;
import java.io.*;
import java.util.*;

class transform {
	
	static int[][] matrix,tMatrix;
	static int size;
	
	static int checkTransform() {
		
		boolean nFlag,oFlag,tFlag;
		nFlag = oFlag = tFlag = true;
		for ( int i = 0; i < size; i++ ) 
			for ( int j = 0; j < size; j++ ) { 
				if ( matrix[i][j] != tMatrix[j][size-1-i] )
					nFlag = false;
				if ( matrix[i][j] != tMatrix[size-1-i][size-1-j] )
					oFlag = false;
				if ( matrix[i][j] != tMatrix[size-1-j][i] )
					tFlag = false;
				
			}
		
		if (nFlag)
			return 1;
		if (oFlag)
			return 2;
		if (tFlag)
			return 3;
		
		return -1;
	}
	
	static boolean isEqual() {
	
		for ( int i = 0; i < size; i++ )
			for ( int j = 0; j < size; j++ )
				if ( matrix[i][j] != tMatrix[i][j] )
					return false;
		return true;
	}
	
	static boolean isReflection() {
		
		for ( int i = 0; i < size; i++ )
			for ( int j = 0; j < size/2; j++ ) {
				if ( matrix[i][j] != tMatrix[i][size-1-j] )
					return false;
				if ( matrix[i][size-1-j] != tMatrix[i][j] )
					return false;
			}
		for ( int i = 0; i < size; i++ )
			if ( matrix[i][size/2] != tMatrix[i][size/2] )
				return false;
		
		return true;
	}
	
	static void reflectMatrix() {
		int temp;
		for ( int i = 0; i < size; i++ )
			for ( int j = 0; j < size/2; j++ ) {
				temp = tMatrix[i][j];
				tMatrix[i][j] = tMatrix[i][size-1-j];
				tMatrix[i][size-1-j] = temp;
			}
	}
	
	public static void main ( String[] args ) throws IOException {
		
		BufferedReader bin = new BufferedReader( new FileReader("transform.in"));
		//BufferedReader bin = new BufferedReader( new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter ( new BufferedWriter(new FileWriter("transform.out")));
		
		size = Integer.parseInt(bin.readLine());
		matrix = new int[size][size];
		tMatrix = new int[size][size];
		
		String inputLine;
		
		for ( int i = 0; i < size; i++ ) {
			inputLine=bin.readLine();
			
			for ( int j = 0; j< size; j++ ) 
				matrix[i][j] = inputLine.charAt(j) - '0';
		}
		
		for ( int i = 0; i < size; i++ ) {
			inputLine=bin.readLine();
			for ( int j = 0; j< size; j++ ) 
				tMatrix[i][j] = inputLine.charAt(j) - '0';
		}
		
		int result = checkTransform();
		
		if ( result == -1 ) {
			
			if (isReflection()) {
				out.println(4);
				out.close();
				bin.close();
				System.exit(0);
			}
			
			reflectMatrix();
			result = checkTransform();
			
			if ( result == -1 )
				out.println(7);
			else
				out.println(5);
			reflectMatrix();
			if (isEqual()) {
				out.println(6);
				out.close();
				bin.close();
				System.exit(0);
			}
			
			out.close();
			bin.close();
			System.exit(0);
			
		}
		else 
			out.println(result);
			
		
		out.close();
		bin.close();
		System.exit(0);
	}
	
	static void printMatrix() {
		
		for ( int i = 0; i < size; i++ ) {
			for ( int j = 0; j < size; j++ )
				System.out.print(tMatrix[i][j]);
			System.out.println();
		}
	}

}
