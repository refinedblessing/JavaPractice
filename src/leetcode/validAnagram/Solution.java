package leetcode.validAnagram;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean isAnagram(String s, String t) {
//        check for length of strings for a start
        if (s.length() != t.length()) return false;
//        we could use hashmap to count occurrence
//        sort the strings and compare
//        we can do an increment and decrement on an alphabet store and loop through the store at the end to look for non-zero values

        int[] alphabetStore = new int[26];

        for (int i = 0; i < s.length(); i++) {
            alphabetStore[s.charAt(i) - 'a']++;
            alphabetStore[t.charAt(i) - 'a']--;
        }

        for (int n : alphabetStore) {
            if (n != 0) return false;
        }

        return true;
    }

    public boolean isAnagram2(String s, String t) {
        return sortString(s).equals(sortString(t));
    }

    public static String sortString(String inputString) {
        // Converting input string to character array
        char[] tempArray = inputString.toCharArray();

        // Sorting temp array using
        Arrays.sort(tempArray);

        // Returning new sorted string
        return new String(tempArray);
    }
}
