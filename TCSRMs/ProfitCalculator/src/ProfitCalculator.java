import java.util.*;

public class ProfitCalculator {
	public int percent(String[] items) {
        double sp,cp,tSp=0,tCp=0;
        int percent = 0;
        int len = items.length;
        for ( int i = 0; i < len; i++ ) {
            String[] temp = items[i].split(" ");
            sp = Double.parseDouble(temp[0]);
            cp = Double.parseDouble(temp[1]);
            tSp += sp;
            tCp += cp;            
        }
        percent = (int)(((tSp-tCp)/tSp)*100);
		return percent;
	}
}
