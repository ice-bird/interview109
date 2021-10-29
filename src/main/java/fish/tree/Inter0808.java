package fish.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 全排列，有重复，比如aa的排列只有一种，而非两种
// 回溯，此处可以用hashmap记录此位置是否已被占用
// set 不行

// 思路2：先排序，把相同的视为一串
public class Inter0808 {
    public String[] permutation(String S) {
        char[] ar = S.toCharArray();
        Arrays.sort(ar);
        
        StringBuilder path = new StringBuilder();
        boolean[] visited = new boolean[ar.length];
        List<String> res = new ArrayList<>();
        backtrack(path, ar, visited, res);
        String[] r = new String[res.size()];
        int index = 0;
        for (String string : res) {
            r[index++] = string;
        }
        return r;
    }
    
    public void backtrack(StringBuilder path, char[] ar,boolean[] visited, List<String> res) {
        //终止条件
        if (path.length() == ar.length) {
            res.add(path.toString());
        }

        // 选择
        for (int i = 0; i < ar.length; i++) {
            if (i > 0 && ar[i-1] == ar[i]&& !visited[i-1]) {
                continue;
                // visited判真还是假，取决于从头开始选还是从后开始选

                // 若前一个是相同元素，且前一个没有被取，说明这个组合已经遍历过
                // 保证相同的元素，必定是从左到右取过去，[选，未选，未选] 到[选，选，未选]
            }
            if (visited[i] == false) {
                visited[i] = true;
                backtrack(path.append(ar[i]), ar, visited, res);
                path.deleteCharAt(path.length() - 1);
                visited[i] = false;
            }
        }
        
    }
}
