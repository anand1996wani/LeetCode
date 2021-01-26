/*

5. Longest Palindromic Substring


Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 3:

Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters (lower-case and/or upper-case),


*/


class Solution {
    public String longestPalindrome(String s) {
        
        int array[][] = new int[s.length()][s.length()];
        int start = 0,end = 0,size = 1;
        
        for(int i = 0;i < s.length();i++){
            array[i][i] = 1;
            if(i < s.length() - 1){
                if(s.charAt(i) == s.charAt(i + 1)){
                    array[i][i + 1] = 1;
                    start = i;
                    end = i + 1;
                    size = 2;
                }
            }
        }
        for(int t = 3;t <= s.length();t++){
            int p = t - 2;
            int j = p;
            for(int i = 1;i <= s.length() - t + 1;i++){
                if(array[i][j] == 1 && s.charAt(i - 1) == s.charAt(j + 1)){
                    array[i - 1][j + 1] = 1;
                    if(size <= (j - i + 3)){
                        size = j - i + 3;
                        start = i - 1;
                        end = j + 1;
                    }
                }
                j++;
            }    
        }
        
        return s.substring(start,end + 1);
    }
}
