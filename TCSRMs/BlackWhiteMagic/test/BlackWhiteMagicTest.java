import org.junit.Test;
import static org.junit.Assert.*;

public class BlackWhiteMagicTest {
	
	@Test
	public void test0() {
		String creatures = "WBBW";
		assertEquals(1, new BlackWhiteMagic().count(creatures));
	}
	
	@Test
	public void test1() {
		String creatures = "WWWWBBBB";
		assertEquals(0, new BlackWhiteMagic().count(creatures));
	}
	
	@Test
	public void test2() {
		String creatures = "BBWW";
		assertEquals(2, new BlackWhiteMagic().count(creatures));
	}
	
	@Test
	public void test3() {
		String creatures = "BWWWWWWWBBBBBBBW";
		assertEquals(1, new BlackWhiteMagic().count(creatures));
	}
	
	@Test
	public void test4() {
		String creatures = "WBWBWBWBWWBWBWBWBBBWBW";
		assertEquals(5, new BlackWhiteMagic().count(creatures));
	}
}
