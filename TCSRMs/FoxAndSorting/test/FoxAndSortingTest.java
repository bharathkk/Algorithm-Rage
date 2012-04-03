import org.junit.Test;
import static org.junit.Assert.*;

public class FoxAndSortingTest {
	
	@Test
	public void test0() {
		long idx = 10L;
		assertEquals(100000000L, new FoxAndSorting().get(idx));
	}
	
	@Test
	public void test1() {
		long idx = 1000000000000000000L;
		assertEquals(999999999999999999L, new FoxAndSorting().get(idx));
	}
	
	@Test
	public void test2() {
		long idx = 58L;
		assertEquals(100000000100L, new FoxAndSorting().get(idx));
	}
	
	@Test
	public void test3() {
		long idx = 314159265358979L;
		assertEquals(646003042230121105L, new FoxAndSorting().get(idx));
	}
	
	@Test
	public void test4() {
		long idx = 271828182845904523L;
		assertEquals(132558071125756493L, new FoxAndSorting().get(idx));
	}
}
