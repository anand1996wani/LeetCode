/*

Longest Common Subsequence
https://leetcode.com/problems/longest-common-subsequence/

Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.

 

If there is no common subsequence, return 0.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 

Constraints:

1 <= text1.length <= 1000
1 <= text2.length <= 1000
The input strings consist of lowercase English characters only.


*/


class Solution {
    public int LCSRecurssive(String s1,int n,String s2,int m){
        if(n == 0 || m == 0){
            return 0;
        }else{
            if(s1.charAt(n - 1) == s2.charAt(m - 1)){
                return 1 + this.LCS(s1,n - 1,s2,m - 1);
            }else{
                return Math.max(this.LCS(s1,n - 1,s2,m),this.LCS(s1,n,s2,m - 1));
            }
        }
    }
    public int LCS(String s1,int n,String s2,int m){
        int DP[][] = new int[n + 1][m + 1];
        for(int i = 1;i < n + 1;i++){
            for(int j = 1;j < m + 1;j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    DP[i][j] = 1 + DP[i - 1][j - 1];
                }else{
                    DP[i][j] = Math.max(DP[i][j - 1],DP[i - 1][j]);
                }
            }
        }
        return DP[n][m];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        return this.LCS(text1,text1.length(),text2,text2.length());
    }
}
