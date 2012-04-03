import java.util.*;
import java.text.*;

public class FormatAmt {
	public String amount(int dollars, int cents) {
        DecimalFormat df = new DecimalFormat("#,###,###,##0.00");
        double ans = dollars + (double)cents/100;
        String soln = "$"+df.format(ans);
		return soln;
	}
}
