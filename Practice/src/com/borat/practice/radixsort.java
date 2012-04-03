package com.borat.practice;
import java.util.*;

public class radixsort {
	
	public static void main(String[] args) {
		
		List<Integer> oneList,zeroList,numbers;
		
		oneList = new ArrayList<Integer>();
		zeroList = new ArrayList<Integer>();
		numbers = new ArrayList<Integer>();
		
		for ( int i = 0; i < 10; i++ )
			if(i % 2== 0)
				numbers.add(i*100);
			else
				numbers.add(i*1000);
		
		int len = numbers.size(),temp;
		
		
		for ( int i = 0; i < 16 ; i++ ) {
			for ( int j = 0; j < len; j++ ) {
				temp = numbers.get(j);
				if((temp & (1<<i)) == 0) {
					zeroList.add(temp);
				}
				else
					oneList.add(temp);
			}
			numbers.clear();
			numbers.addAll(zeroList);
			numbers.addAll(oneList);
			oneList.clear();
			zeroList.clear();
			
		}
		
		for ( int i = 0; i < len; i++ ) 
			System.out.println(numbers.get(i));
	}
}
