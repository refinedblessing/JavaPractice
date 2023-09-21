package leetcode.containsDuplicate;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> uniqueVars = new HashSet<>();
        for (int num : nums) {
            if (uniqueVars.contains(num)) return true;
            uniqueVars.add(num);
        }
        return false;
    }
}
