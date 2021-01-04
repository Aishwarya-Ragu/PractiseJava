package TopInterviewQuestions.Easy.design;

import java.util.Random;

public class ArrayShuffle {
    int[] original;
    int[] array;

    Random rand = new Random();

    private int range(int min, int max){
        return rand.nextInt(max-min);
    }

    public void swap(int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        ArrayShuffle as = new ArrayShuffle(nums);
        as.reset();
        as.shuffle();
    }

    public ArrayShuffle(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = original;
        original = original.clone();
        return  original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i =0;i<array.length;i++){
            swap(i,range(i,array.length));
        }
        return array;
    }
}
