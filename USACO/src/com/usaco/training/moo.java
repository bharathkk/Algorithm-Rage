package com.usaco.training;
import java.io.*;


public class moo {

	static long[] sequence;
	public static void main(String[] args) throws IOException {
		//BufferedReader bin = new BufferedReader(new FileReader("moo.in"));
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter out = new PrintWriter(new FileWriter("moo.out"));
		long num;
		num = Long.parseLong(bin.readLine());
		sequence = new long[50];
		sequence[0] = 0;
		sequence[1] = 3;
		
		for ( int i = 2; i < 30; i++ ) 
			sequence[i] = 2 * sequence[i-1] +i+2;
		
		while (num > 3) {
			int i;
			for ( i = 0; i < 30; i++ )
				if (sequence[i] >= num)
					break;
			if ( sequence[i-1] + i + 2 < num )
				num -= sequence[i-1] + i + 2;
			else 
				if ( sequence[i-1] + 1 == num )
					num = 1;
				else
					num = 0;
			
		}
		
		
		if (num == 1)
			System.out.print("m");
		else
			System.out.print("o");
		bin.close();
		//out.close();
	}
}
