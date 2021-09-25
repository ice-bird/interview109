package fish.dp;
// 面试题 08.10. 颜色填充
// 编写函数，实现许多图片编辑软件都支持的「颜色填充」功能。
// 待填充的图像用二维数组 image 表示，元素为初始颜色值。初始坐标点的行坐标为 sr 列坐标为 sc。需要填充的新颜色为 newColor 。
// 「周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。

import java.util.LinkedList;
import java.util.Queue;

import javax.lang.model.element.QualifiedNameable;

// 请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。

// 本质上就是去找周边4向
// DFS可解决
public class Inter0810 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (newColor == color)
            return image;
        // 在dfs时可能无限循环，如一圈的性状。
        dfs(image, sr, sc, newColor, color);
        return image;


    }

    private void dfs(int[][] image, int sr, int sc, int newColor, int color) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) {
            return;
        }
        image[sr][sc] = newColor;
        dfs(image, sr, sc - 1, newColor, color);
        dfs(image, sr, sc + 1, newColor, color);
        dfs(image, sr - 1, sc, newColor, color);
        dfs(image, sr + 1, sc, newColor, color);
        // 此处会重复进入判断，但是newColor相当于是标记，一旦赋值了newColor，就会在第一步返回。效果等同于visited
        return;
    }
    
    // 方法2：BFS，先遍历一圈，再往外遍历一圈
    public int[][] floodFillBfs(int[][] image, int sr, int sc, int newColor) {
        int color=image[sr][sc];
        if (newColor == color) {
            return image;
        }
        Queue<int[]> queue = new LinkedList<>();
        // 存待处理的点
        queue.offer(new int[] { sr, sc });
        int[][] dir = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
        while (!queue.isEmpty()) {
            int[] loc = queue.poll();
            int i = loc[0], j = loc[1];
            image[i][j] = newColor; //上色
            for (int k = 0; k < dir.length; k++) {
                // 遍历所有可行方向
                int r = dir[k][0] + i;
                int c = dir[k][1] + j;
                // 新的坐标
                if (r >= 0 && r < image.length && c >= 0 && c < image[0].length && image[r][c] == color) {
                    queue.offer(new int[] { r, c });
                    // 注意边界条件 >=0 <image.length
                }
            }

        }
        
        return image;
    }

    
}
