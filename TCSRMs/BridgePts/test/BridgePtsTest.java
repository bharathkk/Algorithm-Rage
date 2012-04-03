import org.junit.Test;
import static org.junit.Assert.*;

public class BridgePtsTest {
	
	@Test
	public void test0() {
		int[] hand = new int[] {25,14,15,16,17,18,19,20,21,22,23,24,26};
		assertEquals(19, new BridgePts().pointValue(hand));
	}
	
	@Test
	public void test1() {
		int[] hand = new int[] {2,3,4,15,18,28,29,30,41,42,43,16,17};
		assertEquals(0, new BridgePts().pointValue(hand));
	}
}
