/*

Minimum Path Sum

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 100


*/

class Solution {
    int n;
    int m;
    int array[][];
    public Solution(){
        
    }
    public Solution(int n,int m){
        this.n = n;
        this.m = m;
        array = new int[n][m];
    }
    public int DPMinPathSum(int[][] grid){
        for(int i = 0;i < this.n;i++){
            for(int j = 0;j < this.m;j++){
                if(i == 0 && j == 0){
                    this.array[i][j] = grid[0][0]; 
                }else if(i == 0){
                    this.array[i][j] = grid[i][j] + this.array[i][j - 1];    
                }else if(j == 0){
                    this.array[i][j] = grid[i][j] + this.array[i - 1][j];
                }else{
                    this.array[i][j] = grid[i][j] + Math.min(this.array[i][j - 1],this.array[i - 1][j]);
                }
            }
        }
        return array[this.n - 1][this.m - 1];
    }
    public int recursiveMinPathSum(int[][] grid, int i,int j){
        if(i < this.n && j < this.m){
            if(i == (this.n - 1) && j == (this.m - 1)){
                return grid[i][j];
            }else{
                return grid[i][j] + Math.min(this.recursiveMinPathSum(grid, i, j + 1),this.recursiveMinPathSum(grid, i + 1, j));
            }
        }else{
            return Integer.MAX_VALUE;
        }
    }
    public int minPathSum(int[][] grid) {
        int i = 0,j = 0;
        Solution solution = new Solution(grid.length,grid[0].length);
        //return solution.recursiveMinPathSum(grid,i,j);
        return solution.DPMinPathSum(grid);
    }
}
