// 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

//  
// 示例 1：
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
// 输出：[1,2,3,6,9,8,7,4,5]

// 示例 2：
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
// 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//  

// 限制：
// 0 <= matrix.length <= 100
// 0 <= matrix[i].length <= 100

class Solution {
    public int[] spiralOrder(int[][] matrix) {
    	if(matrix.length == 0) return new int [0];

        int left=0 , right=matrix[0].length-1 , top=0 , below=matrix.length-1;
        int[] res = new int[(right+1)*(below+1)];
        int k=0;
        
        while(true){
            for(int i = left ; i <= right ; i++) 
            res[k++] = matrix[top][i]; 				// left to right.
            if( ++top > below ) break;

            for(int i = top ; i <= below ; i++)  
            res[k++]= matrix[i][right];				// top to bottom.
            if( --right < left ) break;

            for(int i = right ; i >= left ; i--) 
            res[k++]=matrix[below][i];				// right to left.
            if(-- below < top) break;

            for(int i = below ; i >= top ; i--) 
            res[k++] = matrix[i][left];				// bottom to top.
            if(++ left > right) break;
        }
        return res;
    }
}



