package fish.tree;

import java.util.ArrayList;
import java.util.List;

// 先用DFS 2N个“半括号”，可随意选择位置

// 考虑去除无效结果
// left 和right 表示左右括号数
// left>n 或right>n 或right >left 则必定错误
// 
public class Inter0809 {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return this.res;
        }
        StringBuilder path = new StringBuilder();
        dfs(path, n,0,0);
        for (String string : res) {
            System.out.println(string);
        }
        return this.res;
    }

    
    public void dfs(StringBuilder path, int n,int left,int right) {
        // 退出条件
        if (right > left ||left>n) {
            return;
        }

        if (path.length() == 2 * n) {
            res.add(path.toString());
            // dfs回溯需要把path回退
            return;
        }
        // 选2种情况
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                dfs(path.append('('), n,left+1,right);
                path.deleteCharAt(path.length() - 1);
            }
            if (i == 1) {
                dfs(path.append(')'), n, left, right + 1);
                path.deleteCharAt(path.length() - 1);
            }
            // 如果这里 path是string 则不需要delete，因为每次+字符，都是新的，而第一个dfs返回后，其实path没变
        }
    }
    
    public static void main(String[] args) {
        Inter0809 test = new Inter0809();
        test.generateParenthesis(3);
        // System.out.println("123");
    }

    // 思路2

    // left right初始化为n
    // l>0 则放入"("

    // r>0 且 l<r 则可以放入 右括号
    // 每次放入之后，都要delete
}
