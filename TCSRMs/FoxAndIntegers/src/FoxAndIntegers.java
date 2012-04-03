import java.util.*;

public class FoxAndIntegers {
	public int[] get(int AminusB, int BminusC, int AplusB, int BplusC) {
        int[] soln = new int[3];
        int a,b,c=-2341;
        a = (AminusB + AplusB)/2;
        b = (BminusC + BplusC)/2;
        if(a+b == AplusB && a-b == AminusB)
            c = b - BminusC;
        if(c == -2341)
            return new int[0];
        soln[0] = a;
        soln[1] = b;
        soln[2] = c;
		return soln;
	}
}
