import org.junit.Test;
import static org.junit.Assert.*;

public class DivisorDigitsTest {
	
	@Test
	public void test0() {
		int number = 12345;
		assertEquals(3, new DivisorDigits().howMany(number));
	}
	
	@Test
	public void test1() {
		int number = 661232;
		assertEquals(3, new DivisorDigits().howMany(number));
	}
	
	@Test
	public void test2() {
		int number = 52527;
		assertEquals(0, new DivisorDigits().howMany(number));
	}
	
	@Test
	public void test3() {
		int number = 730000000;
		assertEquals(0, new DivisorDigits().howMany(number));
	}
}
