import java.util.*;

public class SubstitutionCode {
    
	public int getValue(String key, String code) {
		HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        int len = code.length();
        StringBuilder str = new StringBuilder();
        for ( int i = 0 ; i < 9;  i++ ) {
             map.put(key.charAt(i),i+1);
        }
        map.put(key.charAt(9),0);
        
        for ( int i = 0; i < len; i++ ) {
            if(map.containsKey(code.charAt(i))) {
                str.append(map.get(code.charAt(i)));
            }
        }
        return Integer.parseInt(str.toString());
	}
}
