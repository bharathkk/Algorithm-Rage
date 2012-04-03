import org.junit.Test;
import static org.junit.Assert.*;

public class KingXNewBabyTest {
	
	@Test
	public void test0() {
		String name = "dengklek";
		assertEquals("YES", new KingXNewBaby().isValid(name));
	}
	
	@Test
	public void test1() {
		String name = "iooishlr";
		assertEquals("NO", new KingXNewBaby().isValid(name));
	}
	
	@Test
	public void test2() {
		String name = "dolphinigle";
		assertEquals("NO", new KingXNewBaby().isValid(name));
	}
	
	@Test
	public void test3() {
		String name = "mystictc";
		assertEquals("NO", new KingXNewBaby().isValid(name));
	}
	
	@Test
	public void test4() {
		String name = "rngringo";
		assertEquals("NO", new KingXNewBaby().isValid(name));
	}
	
	@Test
	public void test5() {
		String name = "aaeehpll";
		assertEquals("NO", new KingXNewBaby().isValid(name));
	}
	
	@Test
	public void test6() {
		String name = "metelsky";
		assertEquals("YES", new KingXNewBaby().isValid(name));
	}
}
