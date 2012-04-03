import java.util.*;

public class DivisorDigits {
	public int howMany(int number) {
	    boolean[] div = new boolean[9];
        Arrays.fill(div,false);
        int temp = number;
        int count = 0;
        while (temp > 0) {
            int c = temp%10;
            
            if(c !=0 && number % c == 0)
                count++;

            temp /= 10;
        }

        return count;
	}
}
