import org.junit.Test;
import static org.junit.Assert.*;

public class MostProfitableTest {
	
	@Test
	public void test0() {
		int[] costs = new int[] {100,120,150,1000};
		int[] prices = new int[] {110,110,200,2000};
		int[] sales = new int[] {20,100,50,3};
		String[] items = new String[] {"Video Card","256M Mem","CPU/Mobo combo","Complete machine"};
		assertEquals("Complete machine", new MostProfitable().bestItem(costs, prices, sales, items));
	}
	
	@Test
	public void test1() {
		int[] costs = new int[] {100};
		int[] prices = new int[] {100};
		int[] sales = new int[] {134};
		String[] items = new String[] {"Service, at cost"};
		assertEquals("", new MostProfitable().bestItem(costs, prices, sales, items));
	}
	
	@Test
	public void test2() {
		int[] costs = new int[] {38,24};
		int[] prices = new int[] {37,23};
		int[] sales = new int[] {1000,643};
		String[] items = new String[] {"Letter","Postcard"};
		assertEquals("", new MostProfitable().bestItem(costs, prices, sales, items));
	}
	
	@Test
	public void test3() {
		int[] costs = new int[] {10,10};
		int[] prices = new int[] {11,12};
		int[] sales = new int[] {2,1};
		String[] items = new String[] {"A","B"};
		assertEquals("A", new MostProfitable().bestItem(costs, prices, sales, items));
	}
}
