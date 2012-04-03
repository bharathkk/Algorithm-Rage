import org.junit.Test;
import static org.junit.Assert.*;

public class FindingSquareInTableTest {
	
	@Test
	public void test0() {
		String[] table = new String[] {"123",
 "456"};
		assertEquals(64, new FindingSquareInTable().findMaximalSquare(table));
	}
	
	@Test
	public void test1() {
		String[] table = new String[] {"00000",
 "00000",
 "00200",
 "00000",
 "00000"};
		assertEquals(0, new FindingSquareInTable().findMaximalSquare(table));
	}
	
	@Test
	public void test2() {
		String[] table = new String[] {"3791178",
 "1283252",
 "4103617",
 "8233494",
 "8725572",
 "2937261"};
		assertEquals(320356, new FindingSquareInTable().findMaximalSquare(table));
	}
	
	@Test
	public void test3() {
		String[] table = new String[] {"135791357",
 "357913579",
 "579135791",
 "791357913",
 "913579135"}
;
		assertEquals(9, new FindingSquareInTable().findMaximalSquare(table));
	}
	
	@Test
	public void test4() {
		String[] table = new String[] {"553333733",
 "775337775",
 "777537775",
 "777357333",
 "755553557",
 "355533335",
 "373773573",
 "337373777",
 "775557777"};
		assertEquals(-1, new FindingSquareInTable().findMaximalSquare(table));
	}
	
	@Test
	public void test5() {
		String[] table = new String[] {"257240281",
 "197510846",
 "014345401",
 "035562575",
 "974935632",
 "865865933",
 "684684987",
 "768934659",
 "287493867"};
		assertEquals(95481, new FindingSquareInTable().findMaximalSquare(table));
	}
}
