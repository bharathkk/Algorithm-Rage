import java.util.*;

public class LeftOrRight {
	public int maxDistance(String program) {
        int len = program.length();
        int lCount=0,rCount = 0,max = -161;
        for ( int i = 0; i < len; i++ ){
            char ch = program.charAt(i);
            switch(ch) {
                case 'L': lCount--;
                          rCount--;
                          break;
                case 'R': rCount++;
                          lCount++;
                          break;
                case '?': lCount--;
                          rCount++;
                          break;
            }
            max = Math.max(Math.max(Math.abs(lCount),Math.abs(rCount)),max);
        }
        return max;
	}
}
