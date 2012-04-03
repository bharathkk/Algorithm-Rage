import org.junit.Test;
import static org.junit.Assert.*;

public class HexatridecimalSumTest {
	
	@Test
	public void test0() {
		String[] numbers = new String[] {"HELLO"};
		int k = 2;
		assertEquals("ZZLLO", new HexatridecimalSum().maximizeSum(numbers, k));
	}
	
	@Test
	public void test1() {
		String[] numbers = new String[] {"500", "POINTS", "FOR", "THIS", "PROBLEM"};
		int k = 5;
		assertEquals("1100TC85", new HexatridecimalSum().maximizeSum(numbers, k));
	}
	
	@Test
	public void test2() {
		String[] numbers = new String[] {"TO", "BE", "OR", "NOT", "TO", "BE"};
		int k = 0;
		assertEquals("QNO", new HexatridecimalSum().maximizeSum(numbers, k));
	}
	
	@Test
	public void test3() {
		String[] numbers = new String[] {"KEQUALS36"};
		int k = 36;
		assertEquals("ZZZZZZZZZ", new HexatridecimalSum().maximizeSum(numbers, k));
	}
	
	@Test
	public void test4() {
		String[] numbers = new String[] {"GOOD", "LUCK", "AND", "HAVE", "FUN"};
		int k = 7;
		assertEquals("31YUB", new HexatridecimalSum().maximizeSum(numbers, k));
	}
}
