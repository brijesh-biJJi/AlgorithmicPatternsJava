/**
 * LeetCode Problem: Maximum Average SubArray
 */
public class MaxAvgSubArray {
    public static void main(String[] args) {
        int[] nums = {1, 12,-5,-6,50,3};
        int k = 4;
        double result = findMaxAvgSlidingWindow(nums,k);
        System.out.println("Max Avg : "+result);
    }

    private static double findMaxAvgSlidingWindow(int[] nums,int k) {
        int windowSum = 0;
        int start = 0;
        double max = Double.NEGATIVE_INFINITY;

        for (int end = 0; end < nums.length; end++) {
            windowSum += nums[end];

            if((end - start + 1) == k ){
                max = Math.max(max, (double) windowSum / (double) k);
                windowSum -= nums[start];
                start += 1;
            }
        }
        return max;
    }
}
