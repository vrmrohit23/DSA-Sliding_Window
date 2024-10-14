// Intuition :- Intuition is driven from previous same type of problem i did which is just include all the subarrays upto k (which are less than and equal to).
// TC :- O(4*N), N is the length of nums.
// SC :- O(2*N)

class Solution {
     public int find(int[] nums, int k) {
      
        int n = nums.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        int right = 0, left = 0;
        int different = 0;
        int arrays = 0;
        while(right < n){
            int stored = hm.getOrDefault(nums[right],0);
            if(stored == 0) different++;
            hm.put(nums[right],stored + 1);
            while(different > k){
                int val = hm.get(nums[left]);
                if(val == 1){ different--; hm.remove(nums[left]);}
                else hm.put(nums[left],val-1);
                left++;
            }
            arrays = arrays + (right - left) + 1;
            right++;
        }
        return arrays;
     }
    public int subarraysWithKDistinct(int[] nums, int k) {
          
        return find(nums,k) - find(nums,k-1);
    }
}
