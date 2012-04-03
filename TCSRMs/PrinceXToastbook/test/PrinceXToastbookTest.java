import org.junit.Test;
import static org.junit.Assert.*;

public class PrinceXToastbookTest {
	
	@Test
	public void test0() {
		int[] prerequisite = new int[] {-1, 0};
		assertEquals(1.5, new PrinceXToastbook().eat(prerequisite), 1e-9);
	}
	
	@Test
	public void test1() {
		int[] prerequisite = new int[] {-1, 0, 1};
		assertEquals(1.6666666666666667, new PrinceXToastbook().eat(prerequisite), 1e-9);
	}
	
	@Test
	public void test2() {
		int[] prerequisite = new int[] {1, -1, 1};
		assertEquals(2.0, new PrinceXToastbook().eat(prerequisite), 1e-9);
	}
	
	@Test
	public void test3() {
		int[] prerequisite = new int[] {1, 0};
		assertEquals(0.0, new PrinceXToastbook().eat(prerequisite), 1e-9);
	}
	
	@Test
	public void test4() {
		int[] prerequisite = new int[] {-1, -1};
		assertEquals(2.0, new PrinceXToastbook().eat(prerequisite), 1e-9);
	}
}
