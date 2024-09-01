class Solution {
    public int longestOnes(int[] nums, int k) {
        int n =  nums.length;
        int max = 0;
        int zero1 = -1;
        int zerocount = 0;
        int right = 0,left = 0;
        LinkedList<Integer> ll = new LinkedList<>();
        while(right < n){
           
            if(nums[right] == 0){ zerocount++;
            ll.add(right);
            }
            if(zerocount > k){
                max = Math.max(max,right-left);
                left = ll.poll()+1;
                zerocount -= 1;
            }
            right++;
        }
                max = Math.max(max,right-left);
        
        return max;
    }
}
