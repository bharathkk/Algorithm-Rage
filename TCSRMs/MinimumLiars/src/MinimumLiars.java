import java.util.*;

public class MinimumLiars {
	public int getMinimum(int[] claim) {
        int total = claim.length;
        
        for ( int i = 0; i <=total; i++ ) {
            int liars = 0;
            for ( int j = 0; j < total; j++ )
                if(i < claim[j])
                    liars++;
            if(liars == i )
                return liars;
        }
		return -1;
	}
}
