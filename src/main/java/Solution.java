import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> characterFrequency = new HashMap<>();

        for (Character c : magazine.toCharArray()) {
            characterFrequency.merge(c, 1, Integer::sum);
        }

        for (Character c : ransomNote.toCharArray()) {
            int frequency = characterFrequency.getOrDefault(c, 0);

            if (frequency == 0) return false;

            characterFrequency.put(c, frequency - 1);
        }

        return true;
    }
}