package fish.dp;
// 幂集

import java.util.ArrayList;
import java.util.List;

// 编写一种方法，返回某集合的所有子集。集合中不包含重复的元素
// eg [1,2,3] ---- [1][2][3][1,2][2,3][1,3][1,2,3][]
public class Inter0804 {
    public List<List<Integer>> subsets(int[] nums) {
        // 全排列 - -回溯法

        // 迭代 [] 访问1 [] [1] 访问2产生新的 [2] [1,2]
        // 访问3 在已有基础上，产生新的[3] [13][23][123]
        List<List<Integer>> res = new ArrayList<>(1 << nums.length);
        // 总共2^n 个结果 只是初始化了长度，此时并没有具体的分配空间

        // List<Integer> temp = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        // 先添加空的[]

        // 这里应该是深拷贝
        for (int num : nums) {
            for (int i = 0, j = res.size(); i < j; i++) {
                // 注意此处res.size()会变，陷入无限循环
                List<Integer> list = new ArrayList<>(res.get(i));
                list.add(num);
                res.add(list);
            }
            // new一个新list(已现有的初始化)，然后添加一个数字，再加到res

        }

        return res;

    }
    

    // 回溯：所有的路径都是结果，每次回溯，先res.add() 然后继续下一步
    // 选择 - -递归 - - 撤销选择
    int len;
    List<List<Integer>> res = new ArrayList<>(1 << len);

    public List<List<Integer>> subsets02(int[] nums) {
        this.len = nums.length;
        // List<List<Integer>> res = new ArrayList<>(1 << nums.length);
        boolean[] visited = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        backtrack(nums, visited, list,0);
        return res;
    }
    
    private void backtrack(int[] nums, boolean[] visited, List<Integer> list, int start) {

        // 注意此处是深拷贝
        res.add(new ArrayList<>(list));
        // 从剩余的nums中挑选
        // 选择开始的参数，选择结束的参数---
        for (int i = start; i < nums.length; i++) {
            // 若i=start的意思是选过的不选，1之后选3 就不会选2了，妙啊，也省去了visited[] 123第一次遍历，之后就不会重复的132了 比如我选了13之后，就不会选132 而是直接没有可选的，返回
            if (visited[i] == true) {
                continue;
            }
            list.add(nums[i]);
            backtrack(nums, visited, list, i + 1);
            // 撤销
            list.remove(list.size() - 1);
            visited[i] = false;
        }
        return;
    }
    
    // 位运算
    // 这都能位运算？00001 00010 00011 01表示是否选择
    // 共0000 --- 1111 种选择
    public List<List<Integer>> subsets03(int[] nums) {
        int length = 1 << nums.length;
        List<List<Integer>> res = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            List<Integer> list = new ArrayList<>();
            // 每个结果都需要new 
            for (int j = 0; j < nums.length; j++) {

                if (((i >> j) & 1) == 1) {
                    // 如果这个位置的数字是1，就添加进list
                    // i>>j 右移，&1 判断是不是1
                    // 11100 表示的组合，翻译为数组去add
                    
                    list.add(nums[j]);
                }
            }
            res.add(list);
        }
        return res;

    }

}
