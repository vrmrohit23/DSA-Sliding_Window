class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length(); // Length of the input string
        int[] chars = new int[26]; // Array to count occurrences of each character
        int right = 0, left = 0; // Pointers for the sliding window
        int max = 0; // Variable to store the maximum length of the substring
        int maxchar = 0; // Variable to store the count of the most frequent character in the current window

        while (right < n) {
            int index = s.charAt(right) - 'A'; // Get the index of the current character
            chars[index]++; // Increment the count of the current character
            maxchar = Math.max(maxchar, chars[index]); // Update the maxchar with the highest frequency character in the current window

            // If the number of characters to be replaced exceeds k, shrink the window from the left
            if ((right - left + 1) - maxchar > k) {
                chars[s.charAt(left) - 'A']--; // Decrement the count of the character at the left pointer
                left++; // Move the left pointer to the right
            }

            // Update the maximum length of the substring
            max = Math.max(max, right - left + 1);
            right++; // Move the right pointer to the right
        }

        return max; // Return the maximum length of the substring
    }
}
