import java.util.*;

public class ChatTranscript {
	public int howMany(String[] transcript, String name) {
		int count = 0;
        int size,len;
        size = transcript.length;
        len = name.length();
        name = name+":";

        for ( int i = 0; i < size; i++ ) {
            if(transcript[i].length() >= len+1)
            if(transcript[i].substring(0,len+1).equals(name))
                count++;
        }
        return count;
	}
}
