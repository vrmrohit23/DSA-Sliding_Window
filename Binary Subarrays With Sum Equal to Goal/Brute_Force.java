// The most naive solution that comes to mind instantly
// Time_Complexity O(N*N) 
// Space Complexity O(1)

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int right = 0,left = 0;
        int subarrays = 0;
        for(int i = 0;i < n;i++){
            int sum = 0;
           for(int j = i;j < n;j++){
            sum+= nums[j];
            if(sum == goal) subarrays++;
           }
    }
    return subarrays;
}
}
