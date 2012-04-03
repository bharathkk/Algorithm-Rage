import java.math.BigInteger;
import java.util.*;

public class EllysFractions {
    
    static boolean[] primes = new boolean[251];
    static long[] total = new long[251];
    static int[] count = new int[251];
    List<Integer> factors = new ArrayList<Integer>();
	public long getCount(int N) {
        total[0] = 0;
        total[1] = 0;
        calcPrime();
        for ( int i = 2; i <= N; i++ ){
            solve(i);
        }
		return total[N];
	}
    
    public void solve(int n) {
        Arrays.fill(count,0);
        int ctr = 0;
        if(primes[n] == true) {
            total[n] = total[n-1];
            return;
        }
        factors.clear();
        factorize(n,ctr);
        BigInteger num,den;
        long numer=1,denr=1;
        int numSoln = 0;
        num = new BigInteger("1");
        den = new BigInteger("1");
        for ( int i = 0; i < 1<<factors.size(); i++ ) {
            for ( int j = 0; j < factors.size(); j++ ) {
                if(((1<<j)& i) != 0) {
                    numer *= Math.pow(factors.get(j),count[j]);
                    num.multiply(new BigInteger(Long.toString(numer)));
                    numer = 1;
                }
                else {
                    denr *= Math.pow(factors.get(j),count[j]);
                    den.multiply(new BigInteger(Long.toString(numer)));
                    denr = 1;
                }
            }
            if(num.compareTo(den) < 0)
                numSoln++;
                
        }
        total[n] = numSoln + total[n-1];

    }
    
    public void factorize(int n,int ctr) {
        for ( int i = 2; i < n; i++ ) {
            if(primes[i]) {
                if(n % i == 0) {
                    ctr++;
                    factors.add(i);
                }
                while(n % i == 0) {
                    count[i]++;
                    n /= i;
                }
            }
            if( n == 1 ) {
                ctr++;
                count[1]++;
                factors.add(1);
                break;
            }
        }
    }
    public void calcPrime() {
        Arrays.fill(primes,true);
        primes[0] = false;
        primes[1] = false;
        for ( int i = 2; i < 251; i++ )
            if(primes[i])
            for ( int j = i*i; j < 251; j += i)
                primes[j] = false;
    }    
    
    
}
