import org.junit.Test;
import static org.junit.Assert.*;

public class WidgetRepairsTest {
	
	@Test
	public void test0() {
		int[] arrivals = new int[] { 10, 0, 0, 4, 20 };
		int numPerDay = 8;
		assertEquals(6, new WidgetRepairs().days(arrivals, numPerDay));
	}
	
	@Test
	public void test1() {
		int[] arrivals = new int[] { 0, 0, 0 };
		int numPerDay = 10;
		assertEquals(0, new WidgetRepairs().days(arrivals, numPerDay));
	}
	
	@Test
	public void test2() {
		int[] arrivals = new int[] { 100, 100 };
		int numPerDay = 10;
		assertEquals(20, new WidgetRepairs().days(arrivals, numPerDay));
	}
	
	@Test
	public void test3() {
		int[] arrivals = new int[] { 27, 0, 0, 0, 0, 9 };
		int numPerDay = 9;
		assertEquals(4, new WidgetRepairs().days(arrivals, numPerDay));
	}
	
	@Test
	public void test4() {
		int[] arrivals = new int[] { 6, 5, 4, 3, 2, 1, 0, 0, 1, 2, 3, 4, 5, 6 };
		int numPerDay = 3;
		assertEquals(15, new WidgetRepairs().days(arrivals, numPerDay));
	}
}
