package fish.array;
// inter0107 旋转矩阵
// 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。

// 不占用额外内存空间能否做到？
public class Inter0107 {
    public void rotate(int[][] matrix) {
        // 不占用额外空间旋转 - -找规律(索引0-n-1)

        // 任意一个数(i,j) 旋转后，位于(j,n-i-1)
        // 第j列，必在第j行，然后考虑原i行，会放在倒数的列上
        // new int[][] 存放临时结果，然后覆盖原matrix即可

        // 根据一层一层的思路，可以找到递推公式（1/4角的互换）
        // (i,j)-->(j,n-i-1)-->(n-i-1,n-j-1)-->(n-j-1,i)-->(i,j)
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
        
        // 注意 分块 j<(n+1)/2
        // 如5*5 分为1/4则 第3列第三行不旋转，此时选2行3列
        




        int size = matrix.length;
        for (int i = 0; i < matrix.length; i++) {

        }

    }
    
    // 方法2：转置+对称镜像
    public void rotate02(int[][] matrix) {
        // 矩阵转置不占用额外空间
        // (i,j)<-->(j,i)
        int n=matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 左右镜像 (i,j) <- ->(i,n-1-j) 行不变,列镜像
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                // 注意j的边界，不需要+1 用个例子测试一下即可 n=5  n=4 则交换01列即可，符合要求
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
        

    }

}
