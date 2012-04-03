package com.timus.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProductDigits {

	public static void main ( String[] args ) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		int num = Integer.parseInt(in.readLine());
		
		if ( num < 10 ) {
			if ( num == 0 )
				System.out.print(10);
			else
				System.out.print(num);
			
			System.exit(0);
		}
		
		int[] div = new int[10];
		for (int i = 9; i >=2 ; i--)
			div[i] = 0;
		for (int i = 9; i >=2 ;i--)
		{
			while (num % i == 0)
			{
				div[i]++;
				num/=i;
			}
		}
		if (num != 1)
		{
			System.out.println("-1");
		}
		else
		{
			for (int j = 2; j<=9; j++)
				for (int k = 0; k < div[j]; k++)
					System.out.print(j);
			System.out.println();	
		}
	}
}
