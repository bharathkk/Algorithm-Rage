import org.junit.Test;
import static org.junit.Assert.*;

public class SkewedPerspectivesTest {
	
	@Test
	public void test0() {
		int[] cubes = new int[] {1,1,1};
		int B = 1;
		int w = 2;
		String[] views = new String[] { "012", "012bb", "bb0", "21bb", "21b", "1bb20" };
		assertArrayEquals(new String[] {"valid", "valid", "valid", "valid", "valid", "valid" }, new SkewedPerspectives().areTheyPossible(cubes, B, w, views));
	}
	
	@Test
	public void test1() {
		int[] cubes = new int[] {0,1,0};
		int B = 3;
		int w = 2;
		String[] views = new String[] {"b","bb","bbb","bbbb","bbbbb","bbbbbb",
 "1", "1b","1bb","1bbb","1bbbb","1bbbbb","1bbbbbb",
 "b1","b1b","b1bb","b1bbb","b1bbbb","b1bbbbb",
 "bb1","bb1b","bb1bb","bb1bbb","bb1bbbb",
 "bbb1","bbb1b","bbb1bb","bbb1bbb",
 "bbbb1","bbbb1b","bbbb1bb",
 "bbbbb1","bbbbb1b",
 "bbbbbb1" };
		assertArrayEquals(new String[] {"invalid", "valid", "valid", "valid", "valid", "valid", "valid", "valid", "valid", "valid", "valid", "valid", "valid", "invalid", "invalid", "invalid", "invalid", "invalid", "invalid", "valid", "valid", "valid", "invalid", "valid", "invalid", "invalid", "invalid", "invalid", "valid", "invalid", "valid", "invalid", "invalid", "valid" }, new SkewedPerspectives().areTheyPossible(cubes, B, w, views));
	}
	
	@Test
	public void test2() {
		int[] cubes = new int[] {100,0,0};
		int B = 20;
		int w = 3;
		String[] views = new String[] {"00000000000000000000000000000000000000000000000000",
 "00000000000000000000000000000000000b00000000000000",
 "0000000000000000000000000000000000000000000000000b",
 "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb0000000000000"};
		assertArrayEquals(new String[] {"valid", "valid", "valid", "valid" }, new SkewedPerspectives().areTheyPossible(cubes, B, w, views));
	}
	
	@Test
	public void test3() {
		int[] cubes = new int[] {5,6,3};
		int B = 0;
		int w = 1;
		String[] views = new String[] {"00000111111222", "0000111111222", "0000011111222", "000001111111222", "0000011111122", "b"};
		assertArrayEquals(new String[] {"valid", "valid", "valid", "invalid", "valid", "invalid" }, new SkewedPerspectives().areTheyPossible(cubes, B, w, views));
	}
	
	@Test
	public void test4() {
		int[] cubes = new int[] {100,100,100};
		int B = 100;
		int w = 50;
		String[] views = new String[] {"2",
 "bb1b012012012012012012012",
 "bb1b012012012012012012012b",
 "bb1b012012012b012b012b012012b",
 "bb1b0b1b2b0b1b2b0b1b2bb012b012b012012b",
 "b1b0b1b2b0b1b2b0b1b2bb012b012b012012b",
 "bbb1b012012012012012012012"
};
		assertArrayEquals(new String[] {"valid", "valid", "valid", "valid", "valid", "invalid", "valid" }, new SkewedPerspectives().areTheyPossible(cubes, B, w, views));
	}
	
	@Test
	public void test5() {
		int[] cubes = new int[] {0,0,0};
		int B = 0;
		int w = 1;
		String[] views = new String[] {"0", "bb"};
		assertArrayEquals(new String[] {"invalid", "invalid" }, new SkewedPerspectives().areTheyPossible(cubes, B, w, views));
	}
	
	@Test
	public void test6() {
		int[] cubes = new int[] {3,0,0};
		int B = 4;
		int w = 3;
		String[] views = new String[] {"00b0b", "bbbbbbbb", "000b"};
		assertArrayEquals(new String[] {"invalid", "valid", "valid" }, new SkewedPerspectives().areTheyPossible(cubes, B, w, views));
	}
}
