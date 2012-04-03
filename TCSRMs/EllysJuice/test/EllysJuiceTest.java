import org.junit.Test;
import static org.junit.Assert.*;

public class EllysJuiceTest {
	
	@Test
	public void test0() {
		String[] players = new String[] { "elly", "kriss", "stancho", "elly", "stancho" };
		assertArrayEquals(new String[] {"elly", "stancho" }, new EllysJuice().getWinners(players));
	}
	
	@Test
	public void test1() {
		String[] players = new String[] {"torb", "elly", "stancho", "kriss"};
		assertArrayEquals(new String[] { }, new EllysJuice().getWinners(players));
	}
	
	@Test
	public void test2() {
		String[] players = new String[] {"elly", "elly", "elly", "elly", "elly"};
		assertArrayEquals(new String[] {"elly" }, new EllysJuice().getWinners(players));
	}
	
	@Test
	public void test3() {
		String[] players = new String[] { "ariadne", "elly", "ariadne", "stancho", "stancho", "kriss", "stancho", "elly" };
		assertArrayEquals(new String[] {"ariadne", "elly", "stancho" }, new EllysJuice().getWinners(players));
	}
}
