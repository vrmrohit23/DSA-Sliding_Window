class Solution {
    public int longestOnes(int[] nums, int k) {
        int n =  nums.length;
        int max = 0;
        for(int i = 0;i < n;i++){
            int count = 0;
            int j = i;
            for(;j < n;j++){
                if(nums[j] == 0) count++;
                if(count > k) break;
                
            }
            max = Math.max(j-i,max);
        }
        return max;
    }
}
