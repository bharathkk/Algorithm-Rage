import org.junit.Test;
import static org.junit.Assert.*;

public class FoxListeningToMusicTest {
	
	@Test
	public void test0() {
		int[] length = new int[] {1, 2};
		int T = 1;
		assertArrayEquals(new double[] {0.25, 0.75 }, new FoxListeningToMusic().getProbabilities(length, T), 1e-9);
	}
	
	@Test
	public void test1() {
		int[] length = new int[] {1, 10, 100, 1000, 10000};
		int T = 0;
		assertArrayEquals(new double[] {0.2, 0.2, 0.2, 0.2, 0.2 }, new FoxListeningToMusic().getProbabilities(length, T), 1e-9);
	}
	
	@Test
	public void test2() {
		int[] length = new int[] {5, 8, 4, 7};
		int T = 10;
		assertArrayEquals(new double[] {0.1875, 0.3125, 0.1875, 0.3125 }, new FoxListeningToMusic().getProbabilities(length, T), 1e-9);
	}
	
	@Test
	public void test3() {
		int[] length = new int[] {10, 1};
		int T = 9;
		assertArrayEquals(new double[] {0.9990234375, 9.765625E-4 }, new FoxListeningToMusic().getProbabilities(length, T), 1e-9);
	}
	
	@Test
	public void test4() {
		int[] length = new int[] {58, 47, 36, 25, 14, 3};
		int T = 100;
		assertArrayEquals(new double[] {0.32895835374381194, 0.26291497538241776, 0.18463894970453887, 0.1312301113062895, 0.07518634032025856, 0.017071269542683242 }, new FoxListeningToMusic().getProbabilities(length, T), 1e-9);
	}
}
