import org.junit.Test;
import static org.junit.Assert.*;

public class FoxAndGCDLCMTest {
	
	@Test
	public void test0() {
		long G = 2L;
		long L = 20L;
		assertEquals(14L, new FoxAndGCDLCM().get(G, L));
	}
	
	@Test
	public void test1() {
		long G = 5L;
		long L = 8L;
		assertEquals(-1L, new FoxAndGCDLCM().get(G, L));
	}
	
	@Test
	public void test2() {
		long G = 1000L;
		long L = 100L;
		assertEquals(-1L, new FoxAndGCDLCM().get(G, L));
	}
	
	@Test
	public void test3() {
		long G = 100L;
		long L = 1000L;
		assertEquals(700L, new FoxAndGCDLCM().get(G, L));
	}
	
	@Test
	public void test4() {
		long G = 10L;
		long L = 950863963000L;
		assertEquals(6298430L, new FoxAndGCDLCM().get(G, L));
	}
}
