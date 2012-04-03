import org.junit.Test;
import static org.junit.Assert.*;

public class ChatTranscriptTest {
	
	@Test
	public void test0() {
		String[] transcript = new String[] {
"Bob: Hello Tim.",
"Tim: Hello Bob.",
"Bob: How are ya Tim?",
"Frank: Stop chatting!"
};
		String name = "Bob";
		assertEquals(2, new ChatTranscript().howMany(transcript, name));
	}
	
	@Test
	public void test1() {
		String[] transcript = new String[] {
"Bob: This is a long",
"sentence that takes 2 lines.",
"Tim: Yes it is.",
"Bob : I am not Bob.",
"Frank: No you aren't!",
" Bob: Neither am I."
};
		String name = "Bob";
		assertEquals(1, new ChatTranscript().howMany(transcript, name));
	}
	
	@Test
	public void test2() {
		String[] transcript = new String[] {
"Crazy1010: !@LK%#L%K @#L%K @#L%K@#L%K2kl53k2",
"Bob: You are crazy.",
"Crazy1010 Yup #@LK%$L!K%LK%!K% !K afmas,"
};
		String name = "Crazy1010";
		assertEquals(1, new ChatTranscript().howMany(transcript, name));
	}
	
	@Test
	public void test3() {
		String[] transcript = new String[] {
"A:A:A:A:A:A:A:A:A",
"b:b:b:b:b:b:b:b:b"
};
		String name = "B";
		assertEquals(0, new ChatTranscript().howMany(transcript, name));
	}
	
	@Test
	public void test4() {
		String[] transcript = new String[] {"A:A:A:A:A:A:A:A:A"};
		String name = "A";
		assertEquals(1, new ChatTranscript().howMany(transcript, name));
	}
}
