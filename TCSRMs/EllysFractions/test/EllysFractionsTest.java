import org.junit.Test;
import static org.junit.Assert.*;

public class EllysFractionsTest {
	
	@Test
	public void test0() {
		int N = 1;
		assertEquals(0L, new EllysFractions().getCount(N));
	}
	
	@Test
	public void test1() {
		int N = 2;
		assertEquals(1L, new EllysFractions().getCount(N));
	}
	
	@Test
	public void test2() {
		int N = 3;
		assertEquals(3L, new EllysFractions().getCount(N));
	}
	
	@Test
	public void test3() {
		int N = 5;
		assertEquals(9L, new EllysFractions().getCount(N));
	}
	
	@Test
	public void test4() {
		int N = 100;
		assertEquals(177431885L, new EllysFractions().getCount(N));
	}
}
