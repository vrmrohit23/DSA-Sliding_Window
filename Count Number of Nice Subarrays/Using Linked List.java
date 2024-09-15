// The intiution is behind this approach is finding the fist odd number and retrieving it whenever the sliding window have valid odd numbers
// We can find the number of subarrays by subtracting the left pointer from the first occurance and adding 1 to it 

// TC--> O(N) 
// SC --> O(N)

class Node{
    int val;
    Node next;
    Node(int value){
        this.val = value;
        next = null;
    }
    int getval(){
        return this.val;
    }

}
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Node head = null,tail = null;
        int n = nums.length;
        int right = 0,left = 0;
        LinkedList <Integer> ll= new LinkedList<>();
        int arrays = 0;
        int odds = 0;
        while(right < n){
            if(nums[right] % 2 != 0){
                 odds++; 
                 Node temp = new Node(right);
                 if(head == null){
                    head = temp;
                    tail = temp;
                 }
                 else{
                    tail.next = temp;
                    tail = temp;
                 }
                  }
            if(odds > k){
                Node temp = head;
                left = head.getval() + 1;
                head = head.next;
                temp.next = null;
                odds--;
            }
            if(odds == k){
                int temp = head.getval();
                arrays += (temp - left)+1;
                
            }
            right++;
        }
        return arrays;
    }
}
