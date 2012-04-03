import java.util.*;

public class FoxAndGCDLCM {

    static boolean primes[];
    static int[] factors; 
    static int end;
    static long a=1,b=1,soln;
    static List<Integer> facts = new ArrayList<Integer>();

    public long get(long G, long L) {

        long prod;
        soln = Long.MAX_VALUE;
        if(L % (G*G) != 0)
            return -1;
        prod = L/G;
        primes = new boolean[1000000];
        findPrimes();
        if(isPrime(prod))
            return G+(G*prod);


        end = primes.length;
        factors = new int[end];
        Arrays.fill(factors,0);
        factorize(prod);
        if(facts.size() == 0)
            return 1+prod;
        int size = facts.size();
        for ( int i = 0; i < 1<<size; i++) {
            a = G;
             for ( int j = 0; j < size; j++ ) {
                 if( ((1<<j) & i) != 0 ) {
                      a *= Math.pow(facts.get(j),factors[facts.get(j)]);
                 }
             }
            System.out.println("a: "+a+" b: "+b);
            b = (prod / a)*G;
            if( a+b < soln)
                soln = a+b;
        }
		return soln;
	}

    public void findPrimes() {

        Arrays.fill(primes,true);
        primes[0] = false;
        primes[1] = false;
        for ( long i = 2; i < 1000000; i++ )
            if(primes[(int)i])
                for ( long j = i*i; j < 1000000; j += i )
                    primes[(int)j] = false;
    }

    public boolean isPrime(long n) {
        
        int size = (int)Math.sqrt(n);
        size = Math.min(size,1000000-1);
        
        for ( int i = 0; i < size; i++)
            if(primes[i])
                if(n % i == 0)
                    return false;

        return true;
    }


    public void factorize(long n) {

        for ( int i = 0; i < end; i++)
            if(primes[i]) {
                while(n % i == 0) {
                   factors[i]++;
                    n /= i;
                }
                if(factors[i] > 0)
                    facts.add(i);
                if(n == 0 || n == 1)
                    break;
                if(n < 1000000 && primes[(int)n]) {
                    factors[(int)n]++;
                    facts.add((int)n);
                    break;
                }
            }
    }

    
}
