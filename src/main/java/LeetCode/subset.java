package LeetCode;

import java.util.*;

public class subset {
    List<List<Integer>> output = new ArrayList();
    int n, k;

    public static void main(String[] args) {
        char set[] = {'a', 'b', 'c'};
        String str = "AIshwarya";
        System.out.println(str.substring(1));
        System.out.println(str.substring(1,4));
        printSubsets(set);

    }

    static List<List<Character>> printSubsets(char[] set)
    {
        List<List<Character>> output = new ArrayList();
        int n = set.length;

        int nthBit = 1 << n;
        for (int i = 0; i < (int)Math.pow(2, n); ++i) {
            // generate bitmask, from 0..00 to 1..11
            String bitmask = Integer.toBinaryString(i | nthBit).substring(1);

            // append subset corresponding to that bitmask
            List<Character> curr = new ArrayList();
            for (int j = 0; j < n; ++j) {
                if (bitmask.charAt(j) == '1') curr.add(set[j]);
            }
            output.add(curr);
        }
        return output;

    }

    public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        // if the combination is done
        if (curr.size() == k)
            output.add(new ArrayList(curr));

        for (int i = first; i < n; ++i) {
            // add i into the current combination
            curr.add(nums[i]);
            // use next integers to complete the combination
            backtrack(i + 1, curr, nums);
            // backtrack
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        for (k = 0; k < n + 1; ++k) {
            backtrack(0, new ArrayList<Integer>(), nums);
        }
        return output;
    }

    public static int countPairs(List<Integer> numbers, int k) {
        Set<Integer> set = new HashSet<>();
        int count =0;
        for(int num:numbers){
            set.add(num);
            if(set.contains(num+k)){
                count++;
            }

        }
        return count;
    }

}



