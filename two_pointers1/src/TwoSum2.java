import java.util.Arrays;

/**
 * Two Sum II - Input Array Is Sorted
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number.
 * Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 *
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 *
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 *
 * Your solution must use only constant extra space.
 */
public class TwoSum2 {
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        int[] result = findTwoSumII(numbers, target);
        System.out.println("Two Sum II : ["+result[0]+", "+result[1]+"]");
    }

    private static int[] findTwoSumII(int[] numbers, int target) {
        int pointer_one = 0, pointer_two = numbers.length - 1, sum = 0;

        while (pointer_one < pointer_two){
            sum = numbers[pointer_one] + numbers[pointer_two];

            if(sum == target)
                return new int[]{pointer_one + 1, pointer_two + 1};
            else if(sum < target)
                pointer_one +=1;
            else
                pointer_two -= 1;
        }
        return new int[]{-1, -1};
    }
}
