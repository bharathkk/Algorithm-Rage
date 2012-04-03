import org.junit.Test;
import static org.junit.Assert.*;

public class LeastMajorityMultipleTest {
	
	@Test
	public void test0() {
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;
		int e = 5;
		assertEquals(4, new LeastMajorityMultiple().leastMajorityMultiple(a, b, c, d, e));
	}
	
	@Test
	public void test1() {
		int a = 30;
		int b = 42;
		int c = 70;
		int d = 35;
		int e = 90;
		assertEquals(210, new LeastMajorityMultiple().leastMajorityMultiple(a, b, c, d, e));
	}
	
	@Test
	public void test2() {
		int a = 30;
		int b = 45;
		int c = 23;
		int d = 26;
		int e = 56;
		assertEquals(1170, new LeastMajorityMultiple().leastMajorityMultiple(a, b, c, d, e));
	}
	
	@Test
	public void test3() {
		int a = 3;
		int b = 14;
		int c = 15;
		int d = 92;
		int e = 65;
		assertEquals(195, new LeastMajorityMultiple().leastMajorityMultiple(a, b, c, d, e));
	}
}
