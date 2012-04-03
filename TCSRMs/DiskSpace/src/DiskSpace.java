import java.util.*;

public class DiskSpace {
	public int minDrives(int[] used, int[] total) {
		int len = used.length,count=0;
        int sum = 0;
        for ( int i = 0; i < len; i++ )
            sum += used[i];
        
        Arrays.sort(total);
        for ( int i = len - 1; i >=0; i-- ) {
            sum -=total[i];
            count++;
            if(sum<=0)
                break;
        }
        return count;
	}
}
