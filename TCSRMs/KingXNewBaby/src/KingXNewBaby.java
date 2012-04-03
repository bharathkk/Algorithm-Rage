import java.util.*;

public class KingXNewBaby {
    
	public String isValid(String name) {
		int[] countVowels = new int[5];
        Arrays.fill(countVowels,0);
        int len = name.length();
        if(len != 8)
            return "NO";
        char ch;
        int sum = 0;
        for ( int i = 0 ; i < len; i++ ) {
           ch = name.charAt(i);
           if(Character.isUpperCase(ch))
               return "NO";
           switch(ch) {
               case 'a': countVowels[0]++;
                         break;
               case 'e': countVowels[1]++;
                   break;
               case 'i': countVowels[2]++;
                   break;
               case 'o': countVowels[3]++;
                   break;
               case 'u': countVowels[4]++;
                   break;
           }
        }
        for ( int i = 0; i < 5; i++ ) {
          if(countVowels[i] != 2 && countVowels[i] != 0)
              return "NO";
          sum += countVowels[i];
        }
        if(sum != 2)
            return "NO";
        return "YES";
	}
}
