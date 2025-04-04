// Understanding :- The problem states that we have to find the longest substring which contains k distinct character at most so same characters can repeat but not more than k number of different characters should 
//                   be in the substring.

    // Approach  :- I used sliding window technique to ensure having only k distinct characters in working window.
    //              HashMap is used to track frequencies of the characters included in the substring.
    //              I will increase the frequency of the character if is already present in the HashMap and move the end pointer.
    //              If the number of distinct characters in the window exceeds k then i will move the start pointer until the condition is satisfied.
    //              length is updated at the end of every iteration of the main loop.

// Complexities :- N is the size of the origianl string, K is the number of distinct elements allowed
// Time complexity :- O(N) 
// Space complexity :- O(K)

// below is the implementation of the approach in code

import java.util.HashMap;

public class Solution {

	public static int kDistinctChars(int k, String str) {
		// Write your code here
		HashMap<Character,Integer> hm = new HashMap<>();
		int start = 0,end = 0;
		int length = 0;
		while(end < str.length()){
			char c1 = str.charAt(end);
			hm.put(c1,hm.getOrDefault(c1,0)+1);
					while(hm.size() > k){
						char c = str.charAt(start);
						int val = hm.get(c);
						if(val == 1){
						 hm.remove(c);
						}
						else hm.put(c,val - 1);
						 start++;
					}
			length = Math.max(length,end-start+1);
			end++;
				}
		return length;
	}

}
