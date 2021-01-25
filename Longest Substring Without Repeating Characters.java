/*

3. Longest Sub-string Without Repeating Characters

Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.


*/


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        if(s.length() > 0){
            result = Integer.MIN_VALUE;
            HashMap<Character,Integer> hashmap = new HashMap<>();
            int left = 0;
            for(int i = 0;i < s.length();i++){
                while(hashmap.get(s.charAt(i)) != null){
                    hashmap.remove(s.charAt(left));
                    left++;
                }
                result = Math.max(result,i + 1 - left);
                //System.out.println(i + " " + result + " " + left);
                hashmap.put(s.charAt(i),i);
            }
        }
        return result;
    }
}