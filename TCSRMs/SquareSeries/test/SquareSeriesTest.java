import org.junit.Test;
import static org.junit.Assert.*;

public class SquareSeriesTest {
	
	@Test
	public void test0() {
		String pattern = "W?B";
		int lastLength = 2;
		assertEquals("WB", new SquareSeries().completeIt(pattern, lastLength));
	}
	
	@Test
	public void test1() {
		String pattern = "?";
		int lastLength = 5;
		assertEquals("BWBWB", new SquareSeries().completeIt(pattern, lastLength));
	}
	
	@Test
	public void test2() {
		String pattern = "BWBBBBW?WB";
		int lastLength = 10;
		assertEquals("...", new SquareSeries().completeIt(pattern, lastLength));
	}
	
	@Test
	public void test3() {
		String pattern = "BWBWBW?WBWBWBW";
		int lastLength = 15;
		assertEquals("BWBWBWBBWBWBWBWBW", new SquareSeries().completeIt(pattern, lastLength));
	}
	
	@Test
	public void test4() {
		String pattern = "WBWBWBWBWBWWBB?W";
		int lastLength = 1;
		assertEquals("WBWBWBWBWBWWBBBBBBBBBBBWW", new SquareSeries().completeIt(pattern, lastLength));
	}
	
	@Test
	public void test5() {
		String pattern = "?WBWBWBBB";
		int lastLength = 3;
		assertEquals("...", new SquareSeries().completeIt(pattern, lastLength));
	}
}
