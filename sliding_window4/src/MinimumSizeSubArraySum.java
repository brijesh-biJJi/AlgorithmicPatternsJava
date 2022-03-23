/**
 * Minimum Size SubArray Sum
 * Given an Array of positive integers nums and a positive integer target,
 * return the minimul length of a contiguous subarray of which the sum is greater than or equal to target.
 * If there is no such subarray, return 0 instead.
 */
public class MinimumSizeSubArraySum {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        int result = findMinimumSizeSubArraySum(nums, target);
        System.out.println("Minimum Size SubArray Sum : "+result);
    }

    private static int findMinimumSizeSubArraySum(int[] nums, int target) {
        int start = 0,sum = 0;
//        int min = Integer.MAX_VALUE;
        int minLen = 0;

        for (int end = 0; end < nums.length ; end++ ) {
            sum += nums[end];

            while( sum >= target){
                /* This condition is checked only at the beginning
                   Becoz by default min = 0, and 0 is minimum positive number
                   So whenever we check any positive number with 0 it will always be minimum*/
                if(minLen == 0)
                    minLen = end - start + 1;

//                min = Math.min(min, end - start + 1);
                minLen = Math.min(minLen, end - start + 1);
                sum -= nums[start];
                start++;
            }
        }

//        if(min == Integer.MAX_VALUE)
//            return 0;
//        return min;
        if(minLen == 0)
            return 0;
        return minLen;
    }
}
