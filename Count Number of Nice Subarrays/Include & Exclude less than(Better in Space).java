// The intuition is finding all subarrays which have odd numbers upto k
// after finding all of them then removing all the subarrays which are less than or equal to k-1
// hence we will have only those subarrays which have k odd numbers 

// TC --> O(4N) (2N for finding all subarrays and 2N for Exclusion of invalid subarrays)
// SC --> O(1)



class Solution {
    public int find(int[] nums, int k) {
        int n = nums.length;
        int right = 0, left = 0;
        int arrays = 0;
        int odds = 0;
        while (right < n) {
            if (nums[right] % 2 != 0)
                odds++;
            while (odds > k) {
                if(nums[left] % 2 != 0) odds--;
                left++;
            }
            arrays += right-left+1;
            right++;
        }
       return arrays;
    }

    public int numberOfSubarrays(int[] nums, int k) {
       return find(nums,k) - find(nums,k-1);
}
}
