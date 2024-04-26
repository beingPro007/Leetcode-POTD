class Solution {
    int n ;
    int t[][] = new int[201][201];
    public int solve(int col,int row,int[][]grid){
        if(row == n-1){
            return grid[row][col];
        }
        if(t[row][col] != -1){
            return t[row][col];
        }
        int ans = Integer.MAX_VALUE;
        for(int nextCol = 0; nextCol < n; nextCol++){
            if(nextCol != col){
                ans = Math.min(ans,solve(nextCol,row + 1,grid)); 
            }
        }
        return t[row][col] = ans+grid[row][col];
    }
    public int minFallingPathSum(int[][] grid) {
        n = grid.length;
        int m = grid[0].length; 
        for(int i =0;i<n;i++){
            for(int j=0; j<m;j++){
                t[i][j] = -1;
            }
        }
        int result = Integer.MAX_VALUE;
        for(int col= 0; col< n; col++){
            result = Math.min(result,solve(col,0,grid));
        }
        return result;
    }
}