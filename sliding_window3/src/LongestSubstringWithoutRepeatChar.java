import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Longest Substring without Repeating Characters
 */
public class LongestSubstringWithoutRepeatChar {

    public static void main(String[] args) {
        String str = "pwwkew";
        int result = findLongestSubStrWithoutRepeatingChar(str);
        System.out.println("Longest Substring without Repeating Characters : "+result);
    }

    private static int findLongestSubStrWithoutRepeatingChar(String str) {

        int start = 0, largestSubLen = 0;
        Map<Character, Boolean> charMap = new LinkedHashMap<>();

        for (int end = 0 ; end < str.length(); end++){
           char sChar = str.charAt(end);
           if(!charMap.containsKey(sChar)){
               charMap.put(sChar, true);
               largestSubLen = Math.max(largestSubLen, (end - start + 1));
           }else{
               charMap = new LinkedHashMap<>();
               charMap.put(sChar,true);
               start = end;

               while(str.charAt(start) != str.charAt(start - 1) && !charMap.containsKey(str.charAt(start)))
                   start--;

               largestSubLen = Math.max(largestSubLen, (end - start + 1));
           }
        }
        return largestSubLen;
    }
}
