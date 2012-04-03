import org.junit.Test;
import static org.junit.Assert.*;

public class EmbassyTest {
	
	@Test
	public void test0() {
		int[] forms = new int[] {4,4,4};
		int dayLength = 24;
		int openTime = 8;
		assertEquals(12, new Embassy().visaApplication(forms, dayLength, openTime));
	}
	
	@Test
	public void test1() {
		int[] forms = new int[] {4,4,4,4};
		int dayLength = 24;
		int openTime = 8;
		assertEquals(28, new Embassy().visaApplication(forms, dayLength, openTime));
	}
	
	@Test
	public void test2() {
		int[] forms = new int[] {2,2,2,2};
		int dayLength = 24;
		int openTime = 1;
		assertEquals(73, new Embassy().visaApplication(forms, dayLength, openTime));
	}
	
	@Test
	public void test3() {
		int[] forms = new int[] {25,500,630,2500,1000,350,22,58,100,400,500,5000};
		int dayLength = 1440;
		int openTime = 360;
		assertEquals(16945, new Embassy().visaApplication(forms, dayLength, openTime));
	}
}
