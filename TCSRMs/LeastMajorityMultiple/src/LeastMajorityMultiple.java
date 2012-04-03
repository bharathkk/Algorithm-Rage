import java.util.*;

public class LeastMajorityMultiple {
	public int leastMajorityMultiple(int a, int b, int c, int d, int e) {
        
        int start = Math.min(a,Math.min(c,Math.min(d,e)));
        int ctr = 0;
        while(true){
            ctr = 0;
            if(start % a == 0)
                ctr++;
            if(start % b == 0)
                ctr++;
            if(start % c == 0)
                ctr++;
            if(start % d == 0)
                ctr++;
            if(start % e == 0)
                ctr++;

            if(ctr >= 3)
                break;
            start++;
        }
		return start;
	}
}
