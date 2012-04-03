import org.junit.Test;
import static org.junit.Assert.*;

public class FoxAndIntegersTest {
	
	@Test
	public void test0() {
		int AminusB = -1;
		int BminusC = 2;
		int AplusB = 3;
		int BplusC = 2;
		assertArrayEquals(new int[] {1, 2, 0 }, new FoxAndIntegers().get(AminusB, BminusC, AplusB, BplusC));
	}
	
	@Test
	public void test1() {
		int AminusB = 0;
		int BminusC = 0;
		int AplusB = 5;
		int BplusC = 5;
		assertArrayEquals(new int[] { }, new FoxAndIntegers().get(AminusB, BminusC, AplusB, BplusC));
	}
	
	@Test
	public void test2() {
		int AminusB = 10;
		int BminusC = -23;
		int AplusB = -10;
		int BplusC = 3;
		assertArrayEquals(new int[] {0, -10, 13 }, new FoxAndIntegers().get(AminusB, BminusC, AplusB, BplusC));
	}
	
	@Test
	public void test3() {
		int AminusB = -27;
		int BminusC = 14;
		int AplusB = 13;
		int BplusC = 22;
		assertArrayEquals(new int[] { }, new FoxAndIntegers().get(AminusB, BminusC, AplusB, BplusC));
	}
	
	@Test
	public void test4() {
		int AminusB = 30;
		int BminusC = 30;
		int AplusB = 30;
		int BplusC = -30;
		assertArrayEquals(new int[] {30, 0, -30 }, new FoxAndIntegers().get(AminusB, BminusC, AplusB, BplusC));
	}
}
