import java.util.*;

public class RestaurantManager {
	public int allocateTables(int[] tables, int[] groupSizes, int[] arrivals, int[] departures) {
		
        int total,numGroups,turnedAway = 0,ind;
        boolean flag = false;
        int[] assignedGroup;
        total = tables.length;
        numGroups = groupSizes.length;
        assignedGroup = new int[total];
        Arrays.sort(tables);
        Arrays.fill(assignedGroup,-1);
        
        for (int i = 0; i < numGroups; i++ ) {
           flag = false;
           for ( int j = 0; j < total; j++)
               if(tables[j] >= groupSizes[i]) {
                   if(assignedGroup[j] == -1 || departures[assignedGroup[j]] <= arrivals[i] ) {
                       assignedGroup[j] = i;
                       flag = true;
                       break;
                    }
                }
               if(!flag) {
                   turnedAway += groupSizes[i];
               }
        }

        return turnedAway;
	}
}
