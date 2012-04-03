package com.usaco.training;
/*
ID: codin.m1
LANG: JAVA
TASK: packrec
*/
//package USACO;

import java.io.*;

import java.util.*;

class rec implements Comparable<rec>{
	int x, y;
	public rec(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	@Override
	public int compareTo(rec a) {
		if(x*y == a.x*a.y) {
			if ( x == a.x )
				return y - a.y;
			return x - a.x;
		}
		return x*y-a.x*a.y;
	}
	
	@Override
	public boolean equals(Object a) {
		if ( this == a )
			return true;
		if ( a == null )
			return false;
		if ( getClass() != a.getClass() )
			return false;
		rec tmp = (rec) a;
		if ( x == tmp.x && y == tmp.y )
			return true;
		
		return false;	
	}
	
	@Override
	public int hashCode() {
		return x*10+y;
	}
}

public class packrec {
	
	static boolean[] set = {false,false,false,false};
	static int[][] rectangles = new int[4][2];
	static HashSet<rec> solution = new HashSet<rec>();
	static int minArea = 100000007;
	static int size = 0;
	
	public static void generate(List<Integer> num) {
		
		if(num.size() == 4) 
			findRect(num);
		
		for ( int i = 0; i < 4; i++ ) {
			if(!set[i]) {
				set[i] = true;
				num.add(i);
				generate(num);
				num.remove(new Integer(i));
				set[i] = false;
			}
		}
	}
	
	public static void main ( String[] args ) throws IOException {
		
		BufferedReader bin = new BufferedReader( new FileReader("packrec.in"));
		//BufferedReader bin = new BufferedReader( new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter ( new BufferedWriter(new FileWriter("packrec.out")));

		StringTokenizer str;

		for ( int i = 0; i < 4; i++ ) {
			str = new StringTokenizer(bin.readLine());
			rectangles[i][0] = Integer.parseInt(str.nextToken());
			rectangles[i][1] = Integer.parseInt(str.nextToken());
		}
		List<Integer> num = new ArrayList<Integer>();
		
		generate(num);
		
		out.println(minArea);
		PriorityQueue<rec> sol = new PriorityQueue<rec>(solution);
		Iterator<rec> itr = sol.iterator();
		while (itr.hasNext()) {
			rec tmp = itr.next();
			out.println(tmp.getX()+" "+tmp.getY());
		}
			
		bin.close();
		out.close();
	}
	
	public static void findRect(List<Integer> num) {
		
		int[] x,y = new int[4];
		int l,b;
		x = new int[4];
		x[0] = rectangles[num.get(0)][0];
		x[1] = rectangles[num.get(1)][0];
		x[2] = rectangles[num.get(2)][0];
		x[3] = rectangles[num.get(3)][0];
		y[0] = rectangles[num.get(0)][1];
		y[1] = rectangles[num.get(1)][1];
		y[2] = rectangles[num.get(2)][1];
		y[3] = rectangles[num.get(3)][1];
		
		for ( int i = 0; i < 1<<4; i++ ) {
			
			for ( int j = 0; j < 4; j++ ) {
				if (((1<<j) & i) != 0) {
					int temp = x[j];
					x[j] = y[j];
					y[j] = temp;
				}
			}
			//System.out.println(x[0]+","+y[0]+" "+x[1]+","+y[1]+" "+x[2]+","+y[2]+" "+x[3]+","+y[3]);
			b = x[0]+x[1]+x[2]+x[3];
			l = Math.max(max3(y[0],y[1],y[2]), y[3]);
			process(b,l);
			
			b = Math.max(x[0]+x[1]+x[2],x[3]);
			l = max3(y[0],y[1],y[2]) + y[3];
			process(b,l);
			
			b = Math.max(x[0]+x[1],x[3]) + x[2];
			l = Math.max(Math.max(y[0],y[1]) + y[3], y[2]);
			process(b,l);
			
			b = x[0]+x[3]+ Math.max(x[1],x[2]);
			l = max3(y[0],y[3],y[1]+y[2]);
			process(b,l);
			
			b = max3(x[0]+x[1],x[1]+x[2],x[2]+x[3]);
			l = max3(y[0]+y[2],y[0]+y[3],y[1]+y[3]);
			process(b,l);
			
			for ( int j = 0; j < 4; j++ ) {
				if (((1<<j) & i) != 0) {
					int temp = x[j];
					x[j] = y[j];
					y[j] = temp;
				}
			}
		}
	}
	
	public static int max3(int x, int y, int z) {
		if ( x > y ) {
			if ( x > z )
				return x;
			return z;
		}
		else {
			if ( y > z )
				return y;
			return z;
		}
	}
	
	public static void process(int x, int y) {
		if ( x*y <= minArea) {
			if(x*y == minArea) {
				if ( x < y )
					solution.add(new rec(x,y));
				else
					solution.add(new rec(y,x));
			}
			else {
				solution.clear();
				if ( x < y )
					solution.add(new rec(x,y));
				else
					solution.add(new rec(y,x));
				minArea = x*y;
			}
		}
	}
}
