import java.util.*;
import java.util.HashMap;

public class EllysJuice {

    static HashMap<String,Float> scores = new HashMap<String, Float>();
    static HashSet<String> soln = new HashSet<String>();
    static boolean[] choice;
	public String[] getWinners(String[] players) {
        choice = new boolean[players.length];
		return null;
	}
    
    public static void compute(String[] players, int n) {
        if( n == 0 ) {
            float max = Float.MIN_VALUE,points;
            int ctr = 0,ind = 0;
            
            for ( int i = 0; i < players.length; i++ ) {
                 points = scores.get(players[i]);
                 if(points > max) 
                     max = points;
            }
            for ( int i = 0; i < players.length; i++ ) {
                if(scores.get(players[i]) == max) {
                    ctr++;
                    ind = i;
                }
            }   
            if(ctr > 1)
                return;
            soln.add(players[ind]);
        }
        
    }
}
