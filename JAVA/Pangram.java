import java.util.HashMap;
import java.util.Map;

public class Pangram {
   public static void main(String[] args) {
       String input = "The quick brown fox jumps over the lazy dog";
       System.out.println(isPangram(input));
   }

   public static boolean isPangram(String input) {
       Map<Character, Integer> alphabetCount = new HashMap<>();

       for (char c : input.toCharArray()) {
           if (Character.isAlphabetic(c)) {
               char lowerCase = Character.toLowerCase(c);
               alphabetCount.put(lowerCase, alphabetCount.getOrDefault(lowerCase, 0) + 1);
           }
       }

       for (char c = 'a'; c <= 'z'; c++) {
           if (!alphabetCount.containsKey(c)) {
               return false;
           }
       }

       return true;
   }
}