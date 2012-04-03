package com.borat.practice;

import java.util.Arrays;
import java.util.BitSet;
import java.math.BigInteger;


/**
 * @author SB881729
 *
 */
public class Practice {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		int num = 20000;
		int n = 10;
		boolean[] prime = new boolean[num+1];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;
		
		
		for ( int i = 2; i < Math.sqrt(num); i++) {
			
			if(prime[i]) {
				
				for ( int k = i*i; k<=num; k+=i) {
					prime[k] = false;
				}
			}
		}
		
		//for ( int i = 0; i < n; i++ )
			//if(prime[i]) 
				//System.out.print(i+" ");
		
		Practice prac = new Practice();
		//System.out.println("Gcd of 2336 and 1314: "+prac.GCD(1314, 2336));
		
		//System.out.println(prac.findMaxK(10));
		
		//String source = "aefghcbdabc",subString = "abc";
		
		//prac.minimumWindow(source, subString);
		
		//prac.bitSetPractice();
		
		//int[] numbers = {-2,5,-4,0,5,6,-3,4,2,3,-8,2,0,4};
		//generateSubsets(4, numbers,0,"");
		
		//prac.maxSubArraySum(numbers);
		int[] a = new int[10];
	    a[0] = 2;
	    a[1] = 7;
	    a[2] = 12;
	    a[3] = 13;
	    a[4] = 15;
	    int[] b = new int[5];
	    b[0] = 3;
	    b[1] = 5;
	    b[2] = 8;
	    b[3] = 11;
	    b[4] = 19;
	    
	    inPlaceMerge(a,b,5,5);
		
	}
	
	public int GCD ( int a, int b) {
		
		if ( b == 0 ) return a;
		return GCD(b,a%b);
	}
	
	public int fromDecimal ( int number, int base) {
		
		int result = 0;
		int multiplier = 1;
		
		while (number>0) {
			
			System.out.println(number%base*multiplier);
			result+= (number%base)*multiplier;
			multiplier*= 10;
			number/=base;
		}
		
		return result;
	}
	
	long findMaxK( int n) {
		
		long[] a = new long[n];
		
		for ( int i = 0; i < n; i++ ) {
			a[i] = i+1;
		}
		
		for ( int i =0 ; i<n; i++) {
			
			long num = a[i];
			for ( int j = i+3; j<n; j++,num+=a[i]) {
				a[j] = Math.max(a[j],num);
			}
		}
		
		return a[n-1];
		
	}
	
	void bitSetPractice() {
		
		String names[] = { "Java", "Source", "and",
        "Support"};
		BitSet bits = new BitSet();
		for (int i = 0, n = names.length; i < n; i++) {
			if ((names[i].length() % 2) == 0) {
				bits.set(i);
			}
		}
	    System.out.println(bits.cardinality());
	    System.out.println("Size : " + bits.size());
	    System.out.println("Length: " + bits.length());
	    for (int i = 0, n = names.length; i < n; i++) {
	      if (!bits.get(i)) {
	        System.out.println(names[i] + " is odd");
	      }
	    }
	    BitSet bites = new BitSet();
	    bites.set(0);
	    bites.set(1);
	    bites.set(2);
	    bites.set(3);
	    bites.andNot(bits);
	    
//	 	System.out.println(bites);
	}
	
	void minimumWindow ( String sourceString, String stringToFind ) {
		
		int sourceLen = sourceString.length(), subStringLen = stringToFind.length();
		int beginWindow,endWindow,count = 0,minWindowLen = Integer.MAX_VALUE;
		int minStartInd=0,minEndInd =sourceLen - 1;
		
		
		int[] needToFind, hasFound;
		needToFind = new int[256];
		hasFound = new int[256];
		
		Arrays.fill(needToFind, 0);
		Arrays.fill(hasFound, 0);
		
		for ( int i = 0; i < subStringLen; i++ )
			needToFind[stringToFind.charAt(i)]++;
		
		for ( beginWindow = 0, endWindow = 0; endWindow < sourceLen; endWindow++ ) {
			
			if ( needToFind[sourceString.charAt(endWindow)] == 0 ) continue;
			
			hasFound[sourceString.charAt(endWindow)]++;
			
			if ( hasFound[sourceString.charAt(endWindow)] <= needToFind[sourceString.charAt(endWindow)])
			 count++;
			 
			if ( count == subStringLen) {
				
				while ( needToFind[sourceString.charAt(beginWindow)] == 0 || hasFound[sourceString.codePointAt(beginWindow)] > needToFind[sourceString.charAt(beginWindow)]) {
					
					if (hasFound[sourceString.charAt(beginWindow)] > needToFind[sourceString.charAt(beginWindow)]) 
						hasFound[sourceString.charAt(beginWindow)]--;
						
					beginWindow++;
				}
				
				int windowLen = endWindow - beginWindow +1;
				
				if ( windowLen < minWindowLen ) {
					
					minWindowLen = windowLen;
					minStartInd = beginWindow;
					minEndInd = endWindow;
					System.out.println(minWindowLen+" start ind: "+minStartInd+" end ind: "+minEndInd);
				}
			}
			 
			
		}
		
		System.out.println(sourceString.substring(minStartInd,minEndInd+1));
	}
	
	public static BigInteger fact(int n) {
		
		BigInteger bin = BigInteger.ONE;
		for ( int i = 1; i <= n; i++)
			bin = bin.multiply(BigInteger.valueOf(i));
		
		return bin;
	}
	
	/**
	 * setOfSubsets - global list that has all the generated subsets stored 
	 * 
	 * Initial function call would be generateSubsets(n,{a1,a2,...an},0,"")
	 * 
	 * @param num - size of n
	 * @param numbers - array containing n numbers
	 * @param startIndex - start index of the array from which it should choose the elements for its forthcoming subsets
	 * @param suffix - suffix for the forthcoming subsets 
	 */
	private static void generateSubsets ( int num, int[] numbers, int startIndex, String suffix ) {
		
		if ( startIndex >= num )
			return;
		if ( numbers == null || num <= 0 )
			return;
		
		for ( int i = startIndex; i < numbers.length; i++ ) {
			
			StringBuilder subset = new StringBuilder();
			subset.append(suffix);
			
			if ( suffix != "")
				subset.append(",");
			
			// create a new subset from the suffix by adding the next possible element from the rest of the elements
			subset.append(numbers[i]);
			// add the newly created subset to the global list
			System.out.println(subset.toString());
			
			// Call the generator function recursively if it is possible to generate more subsets
			if ( i + 1 < numbers.length )
				generateSubsets(num,numbers,i+1,subset.toString());
		}
	}
	
	void maxSubArraySum ( int[] array ) {
		
		int maxati = Integer.MIN_VALUE,maxtilli = Integer.MIN_VALUE;
		int startIndex = 0, endIndex = -1;
		
		for ( int i = 0; i < array.length; i++ ) {
			
			
			maxati = maxati > 0? maxati + array[i] : array[i];
			
			if ( maxati < 0)
				startIndex = i + 1;
			if (maxtilli < maxati ) {
				maxtilli =  maxati;
				endIndex = i;
			}
			
		}
		
		System.out.println("Maximum subarray sum: "+maxtilli);
		System.out.println("Begins from: "+startIndex+" ends at: "+endIndex);
	}
	
	public static void inPlaceMerge ( int[] a, int[] b, int n, int m ) {
		
		System.out.println(n+m-1);
		int ind = 0;
		for ( int i = 0; i < n; i++ ) 
			a[n+i] = a[i];
		
		int ind2 = n,ind1 = 0;
		while(true) {
			
			if ( ind2 >= n+m-1 && ind1 == m )
				break;
			if ( ind1 == m ) {
				for (int i = ind; i < n + m - 1; i++ )
					a[i] = a[ind2++];
				break;
			}
			if ( ind2 == n+m - 1) {
				for ( int i = ind; ind1 < m; i++ )
					a[i] = b[ind1++];
				break;
			}
			if ( a[ind2] > b[ind1] ) {
				a[ind++] = b[ind1++];
			}
			else
				a[ind++] = a[ind2++];
		}
		
		for ( int i = 0; i < n + m - 1; i++ )
			System.out.print(a[i]+" ");
	}

}
