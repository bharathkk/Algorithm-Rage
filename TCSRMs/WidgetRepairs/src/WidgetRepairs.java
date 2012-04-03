import java.util.*;

public class WidgetRepairs {
	public int days(int[] arrivals, int numPerDay) {
        int rem=0,count=0;
        int len = arrivals.length;

        for ( int i = 0; i < len; i++ ) {
            rem += arrivals[i];
            if(rem > numPerDay) {
                count += 1;
                rem -= numPerDay;
            }
            else {
                if(rem!=0)
                    count += 1;
                rem = 0;
            }
        }
        count += rem/numPerDay;
        if(rem % numPerDay != 0)
            count += 1;
		return count;
	}
}
