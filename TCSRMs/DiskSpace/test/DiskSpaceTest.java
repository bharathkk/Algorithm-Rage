import org.junit.Test;
import static org.junit.Assert.*;

public class DiskSpaceTest {
	
	@Test
	public void test0() {
		int[] used = new int[] {300,525,110};
		int[] total = new int[] {350,600,115};
		assertEquals(2, new DiskSpace().minDrives(used, total));
	}
	
	@Test
	public void test1() {
		int[] used = new int[] {1,200,200,199,200,200};
		int[] total = new int[] {1000,200,200,200,200,200};
		assertEquals(1, new DiskSpace().minDrives(used, total));
	}
	
	@Test
	public void test2() {
		int[] used = new int[] {750,800,850,900,950};
		int[] total = new int[] {800,850,900,950,1000};
		assertEquals(5, new DiskSpace().minDrives(used, total));
	}
	
	@Test
	public void test3() {
		int[] used = new int[] {49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,
 49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49};
		int[] total = new int[] {50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,
 50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50};
		assertEquals(49, new DiskSpace().minDrives(used, total));
	}
	
	@Test
	public void test4() {
		int[] used = new int[] {331,242,384,366,428,114,145,89,381,170,329,190,482,246,2,38,220,290,402,385};
		int[] total = new int[] {992,509,997,946,976,873,771,565,693,714,755,878,897,789,969,727,765,521,961,906};
		assertEquals(6, new DiskSpace().minDrives(used, total));
	}
}
