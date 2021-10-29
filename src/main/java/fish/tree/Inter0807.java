package fish.tree;
// 面试题 08.07. 无重复字符串的排列组合
import java.util.List;
import java.util.ArrayList;

// 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。

// eg S="ab" res=["ab","ba"]

// 全排列问题,且不考虑重复问题 回溯呗，甚至不需要剪枝
// 动态规划是否可以？

// 升级：有重复的全排列
public class Inter0807 {
    int index;

    public String[] permutation(String S) {
        // 转为char[]更好处理
        this.index = 0;
        StringBuilder path = new StringBuilder(S.length());
        // 注意全排列个数Ann 不是2^n 暂时是不知道长度的
        String[] res = new String[2 << S.length()];
        // List<String> res = new ArrayList<>();
        // backtrack res.append() 
        // 最后List转数组
        // for(String s :res){
        // r[index++] = s;
        // }

        boolean[] visited = new boolean[S.length()];
        backtrack(S, path, visited, res); 
        return res;

    }
    
    void backtrack(String S,StringBuilder path,boolean[] visited,String[] res){
        // 终止条件
        if(path.length()==S.length()){
            res[this.index++] = path.toString();
            return;
        }

        // 所有选择
        for(int i=0;i<S.length();i++){
            if(visited[i]==true){
                continue;
            }
            visited[i]=true;
            path.append(S.charAt(i));
            backtrack(S, path, visited, res);
            // 撤销选择
            path.deleteCharAt(path.length() - 1);
            visited[i]=false;
        }

        return;
    }
}
