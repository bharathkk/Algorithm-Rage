import java.util.*;

public class MostProfitable {
	public String bestItem(int[] costs, int[] prices, int[] sales, String[] items) {
        String ans = "";
        int ind=0,maxCost=-1,cost;
        int len = costs.length;
        
        for ( int i = 0; i < len; i++)  {
           cost = (prices[i] - costs[i])*sales[i];
            if(cost > 0 && cost > maxCost)  {
                ind = i;
                maxCost = cost;
            }
        }
        if(maxCost == -1 )
            return "";
		return items[ind] ;
	}
}
