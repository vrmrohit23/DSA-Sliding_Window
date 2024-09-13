// Kadane's Algorithm Used
// This Algo used in many different Problems of Subarray questions 
// For this Concept You must Know Prefix Sum Concept to understand it properly
// Some Videos for understanding the Concept/Algo are:-
//https://www.youtube.com/watch?v=xvNwoz-ufXA&pp=ygUKcHJlZml4IHN1bQ%3D%3D
// https://www.youtube.com/watch?v=AHZpyENo7k4&pp=ygUKcHJlZml4IHN1bQ%3D%3D

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int subarrays = 0;
        int sum = 0;
        // Create a HashMap to store the count of prefix sums.
        // The key represents the sum and the value represents the frequency of that sum.
        HashMap<Integer, Integer> hm = new HashMap<>();
        // Initialize the HashMap with a base case.
        // A sum of 0 has occurred once (to handle subarrays that start from index 0).
        hm.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            // Check if the difference between the current sum and the goal exists in the HashMap.
            // If it exists, it means there is a prefix sum that, when subtracted, gives us the required subarray.
            // Add the frequency of that prefix sum to the result (subarrays).
            subarrays += hm.getOrDefault(sum - goal, 0);
            // Add the current running sum to the HashMap.
            // If the sum already exists, increment its frequency by 1. Otherwise, initialize it with 1.
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        return subarrays;
    }
}
