import org.junit.Test;
import static org.junit.Assert.*;

public class MinimumLiarsTest {
	
	@Test
	public void test0() {
		int[] claim = new int[] {1,1,1,2};
		assertEquals(1, new MinimumLiars().getMinimum(claim));
	}
	
	@Test
	public void test1() {
		int[] claim = new int[] {7,8,1};
		assertEquals(2, new MinimumLiars().getMinimum(claim));
	}
	
	@Test
	public void test2() {
		int[] claim = new int[] {5,5,5,5,5};
		assertEquals(-1, new MinimumLiars().getMinimum(claim));
	}
	
	@Test
	public void test3() {
		int[] claim = new int[] {0,0,0,4,3,0};
		assertEquals(2, new MinimumLiars().getMinimum(claim));
	}
	
	@Test
	public void test4() {
		int[] claim = new int[] {4,7,5};
		assertEquals(3, new MinimumLiars().getMinimum(claim));
	}
}
