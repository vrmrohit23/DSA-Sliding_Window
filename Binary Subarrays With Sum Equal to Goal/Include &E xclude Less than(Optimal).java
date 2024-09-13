// Intiution:
// The intiution behind is of including and excluding the subarrays whose sum is less than the goal 
// The idea of intiuition is not different than other problems with same asking but slightly differs from intiuitions of other questions

// TC --> O(4N) 
// Explaination :-)
// First/Third N is for the right movement if it has to go from 0 to N-1 to include all the elements less than/equal to goal.
// Second/Fourth N is for the left movement if it has to go through from 0 to N-1 to reduce the array to less than equal to goal.

// SC --> O(1)


class Solution {
    public int find(int[] nums, int goal) {
        // Base case: If goal is negative, there are no valid subarrays
        if (goal < 0) return 0;
        int n = nums.length;
        int sum = 0;         
        int subarrays = 0;    
        int right = 0, left = 0; 
        while (right < n) {
            sum += nums[right];
            // If the sum exceeds the goal, shrink the window from the left side
            while (sum > goal) {
                sum -= nums[left];  // Subtract the element at the left pointer
                left++;  // Move the left pointer to the right to shrink the window
            }
            
            // All subarrays between 'left' and 'right' are valid since sum <= goal
            subarrays += right - left + 1;
            
            // Move the right pointer to expand the window
            right++;
        }
        return subarrays;
    }

    // Main function to find the number of subarrays with sum exactly equal to the goal
    public int numSubarraysWithSum(int[] nums, int goal) {
        // The number of subarrays with sum exactly equal to 'goal' is:
        // Subarrays with sum <= goal - Subarrays with sum < goal
        return find(nums, goal) - find(nums, goal - 1);
    }
}
