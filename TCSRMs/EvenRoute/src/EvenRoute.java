import java.util.*;

public class EvenRoute {
    static int numSteps = 0;

	public String isItPossible(int[] x, int[] y, int wantedParity) {
		int numOddPoints=0,numEvenPoints=0;
        int len = x.length;
        
        for ( int i = 0; i < len; i++ ) {
            if(x[i] % 2 == 0) {
                if(y[i] % 2 == 0)
                    numEvenPoints++;
            }
            else {
                if(y[i] % 2 != 0)
                    numEvenPoints++;
            }
        }
        numOddPoints = len - numEvenPoints;
        if(wantedParity == 1) {
            if(numOddPoints > 0 )
                return "CAN";
            return "CANNOT";
        }
        else {
            if(numEvenPoints > 0 )
                return "CAN";
            return "CANNOT";
        }
	}
}
