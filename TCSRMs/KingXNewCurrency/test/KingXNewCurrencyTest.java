import org.junit.Test;
import static org.junit.Assert.*;

public class KingXNewCurrencyTest {
	
	@Test
	public void test0() {
		int A = 5;
		int B = 8;
		int X = 5;
		assertEquals(5, new KingXNewCurrency().howMany(A, B, X));
	}
	
	@Test
	public void test1() {
		int A = 8;
		int B = 4;
		int X = 2;
		assertEquals(-1, new KingXNewCurrency().howMany(A, B, X));
	}
	
	@Test
	public void test2() {
		int A = 7;
		int B = 4;
		int X = 13;
		assertEquals(1, new KingXNewCurrency().howMany(A, B, X));
	}
	
	@Test
	public void test3() {
		int A = 47;
		int B = 74;
		int X = 44;
		assertEquals(2, new KingXNewCurrency().howMany(A, B, X));
	}
	
	@Test
	public void test4() {
		int A = 128;
		int B = 96;
		int X = 3;
		assertEquals(65, new KingXNewCurrency().howMany(A, B, X));
	}
}
