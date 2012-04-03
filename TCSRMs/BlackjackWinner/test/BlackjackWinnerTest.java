import org.junit.Test;
import static org.junit.Assert.*;

public class BlackjackWinnerTest {
	
	@Test
	public void test0() {
		int bet = 10;
		int dealer = 20;
		int dealerBlackjack = 0;
		int player = 21;
		int blackjack = 0;
		assertEquals(0, new BlackjackWinner().winnings(bet, dealer, dealerBlackjack, player, blackjack));
	}
	
	@Test
	public void test1() {
		int bet = 26;
		int dealer = 21;
		int dealerBlackjack = 1;
		int player = 21;
		int blackjack = 0;
		assertEquals(-26, new BlackjackWinner().winnings(bet, dealer, dealerBlackjack, player, blackjack));
	}
	
	@Test
	public void test2() {
		int bet = 100;
		int dealer = 25;
		int dealerBlackjack = 0;
		int player = 21;
		int blackjack = 1;
		assertEquals(150, new BlackjackWinner().winnings(bet, dealer, dealerBlackjack, player, blackjack));
	}
	
	@Test
	public void test3() {
		int bet = 78;
		int dealer = 22;
		int dealerBlackjack = 0;
		int player = 23;
		int blackjack = 0;
		assertEquals(-78, new BlackjackWinner().winnings(bet, dealer, dealerBlackjack, player, blackjack));
	}
}
