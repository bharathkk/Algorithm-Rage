import org.junit.Test;
import static org.junit.Assert.*;

public class FormatAmtTest {
	
	@Test
	public void test0() {
		int dollars = 123456;
		int cents = 0;
		assertEquals("$123,456.00", new FormatAmt().amount(dollars, cents));
	}
	
	@Test
	public void test1() {
		int dollars = 49734321;
		int cents = 9;
		assertEquals("$49,734,321.09", new FormatAmt().amount(dollars, cents));
	}
	
	@Test
	public void test2() {
		int dollars = 0;
		int cents = 99;
		assertEquals("$0.99", new FormatAmt().amount(dollars, cents));
	}
	
	@Test
	public void test3() {
		int dollars = 249;
		int cents = 30;
		assertEquals("$249.30", new FormatAmt().amount(dollars, cents));
	}
	
	@Test
	public void test4() {
		int dollars = 1000;
		int cents = 1;
		assertEquals("$1,000.01", new FormatAmt().amount(dollars, cents));
	}
}
