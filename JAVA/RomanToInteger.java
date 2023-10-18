import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("IX")); // 9
        System.out.println(romanToInt("LVIII")); // 58
        System.out.println(romanToInt("MCMXCIV")); // 1994
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int totalValue = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentCharacter = s.charAt(i);
            int currentValue = romanValues.get(currentCharacter);
            if (i + 1 < s.length()) {
                char nextCharacter = s.charAt(i + 1);
                int nextValue = romanValues.get(nextCharacter);
                if (currentValue < nextValue) {
                    totalValue += (nextValue - currentValue);
                    i++;
                } else {
                    totalValue += currentValue;
                }
            } else {
                totalValue += currentValue;
            }
        }
        return totalValue;
    }
}