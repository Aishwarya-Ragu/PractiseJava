package LeetCode;

import java.util.*;
import java.util.stream.Collectors;

public class IntersectionOfTwoArray {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        IntersectionOfTwoArray ia = new IntersectionOfTwoArray();
        int[] a = ia.intersect(nums1, nums2);
        System.out.println(a);
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list1 = Arrays.stream(nums1).mapToObj(e->(Integer)e).collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(nums1).mapToObj(e->(Integer)e).collect(Collectors.toList());
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);
        List<Integer> list = new ArrayList<>();
        for(int a:set1){
            if(set2.contains(a)){
                list.add(a);
            }
        }
        return list.stream().mapToInt(e->(int)e).toArray();

    }
}
