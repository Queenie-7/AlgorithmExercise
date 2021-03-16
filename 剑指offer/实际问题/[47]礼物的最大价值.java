// 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
// 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
// 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？

// 示例 1:
// 输入: 
// [
//   [1,3,1],
//   [1,5,1],
//   [4,2,1]
// ]
// 输出: 12
// 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
//  
// 提示：
// 0 < grid.length <= 200
// 0 < grid[0].length <= 200


// 动态规划，每一格点的最大值可以通过上一步（从上面或左边来）的最大值+当前的值

//开辟新空间，多开一行一列，使代码简洁
class Solution {
    public int maxValue(int[][] grid) {
        int  m= grid.length;
        int n = grid[0].length;
        //dp[i][j]表示从grid[0][0]到grid[i - 1][j - 1]时的最大价值
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }
}


//空间复杂度优化，原地改值
class Solution{
	public int maxVaue(int[][] grid){
		int m = grid.length, n = grid[0].length;
		for(int i =0;i< m ;i++)
			for(int j =0; j<n ;j++){
				if(i==0&&j==0) continue;
				if(i==0)
					grid[i][j]+=grid[i][j-1];
				else if(j==0)
					grid[i][j]+=grid[i-1][j];
				else 
					grid[i][j]+=Math.max(grid[i][j-1],grid[i-1][j]);
			}
		return grid[m-1][n-1];
	}
}

