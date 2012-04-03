import java.util.*;

public class BridgePts {
	public int pointValue(int[] hand) {
        int len = hand.length;
        int points = 0,countC=0,countS=0,countD=0,countH = 0;
        int temp;
        Arrays.sort(hand);
        for ( int i = 0; i < len; i++ ) {
            temp = hand[i];
            if(temp < 14)
                countC++;
            if(temp > 13 && temp < 27)
                countS++;
            if(temp > 26 && temp < 40)
                countD++;
            if(temp > 39)
                countH++;
            temp %= 13;

            if(temp == 1)
               points += 4;

            if(temp == 0 )
               points += 3;
            if(temp == 12)
               points += 2;
            if(temp == 11)
               points += 1;
        }
        if(countC == 1)
            points += 2;
        if(countC == 0)
            points += 3;
        if(countC == 2)
            points += 1;

        if(countD == 1)
            points += 2;
        if(countD == 0)
            points += 3;
        if(countD == 2)
            points += 1;

        if(countH == 1)
            points += 2;
        if(countH == 0)
            points += 3;
        if(countH == 2)
            points += 1;

        if(countS == 1)
            points += 2;
        if(countS == 0)
            points += 3;
        if(countS == 2)
            points += 1;
		return points;
	}
}
