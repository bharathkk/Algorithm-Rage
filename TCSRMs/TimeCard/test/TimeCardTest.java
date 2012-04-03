import org.junit.Test;
import static org.junit.Assert.*;

public class TimeCardTest {
	
	@Test
	public void test0() {
		String[] time = new String[] {"03:00,pm"};
		assertEquals("BELOW 40", new TimeCard().leave(time));
	}
	
	@Test
	public void test1() {
		String[] time = new String[] {"09:00,am","05:00,pm","09:00,am","05:00,pm",
    "09:00,am","05:00,pm","09:00,am","05:00,pm","09:00,am"};
		assertEquals("05:00,pm", new TimeCard().leave(time));
	}
	
	@Test
	public void test2() {
		String[] time = new String[] {"12:00,am","08:00,pm","12:00,am","08:00,pm","12:00,am"};
		assertEquals("12:00,am", new TimeCard().leave(time));
	}
	
	@Test
	public void test3() {
		String[] time = new String[] {"12:00,pm","08:00,pm","12:00,am","08:00,pm","12:00,am"};
		assertEquals("12:00,pm", new TimeCard().leave(time));
	}
	
	@Test
	public void test4() {
		String[] time = new String[] {"09:00,am","04:31,pm","09:00,am","04:31,pm",
     "09:00,am","05:00,pm","09:00,am","05:00,pm","03:53,am"};
		assertEquals("12:51,pm", new TimeCard().leave(time));
	}
}
