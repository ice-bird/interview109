package fish.tree;
// inter 0401 节点间通路

// 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
// 图是否有通路问题 -- DFS
public class Inter0401 {
    private boolean[] visited = null;

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        // graph 存储邻接信息
        // n是节点个数

        // 如果改为node存储，dfs必定可以
        this.visited = new boolean[graph.length];
        // 为什么visited是边的个数
        return dfs(graph, start, target);

    }

    private boolean dfs(int[][] graph, int start, int target) {
        // 深度优先搜索
        for (int i = 0; i < graph.length; i++) {
            // 一条一条边  去找路径
            // 目标就是从graph的边中，组合起来
            if (!visited[i]) {
                // 先访问第0个节点
                if (graph[i][0] == start && graph[i][1] == target) {
                    return true;
                    // 直接相连
                }

                // 回溯法，表示此节点已被访问过
                visited[i] = true;

                if (graph[i][1] == target && dfs(graph, start, graph[i][0])) {
                    // 此邻接的目标是target，则去找从start是否有找到开始的路
                    return true;
                }
                visited[i] = false;
            }
        }

        return false;
    }
    
    // 从他target逆序找，不会超时，因为一开始的正向搜索比较浪费时间

    // 答案的方法
    public boolean findWhetherExistsPath02(int n, int[][] graph, int start, int target) {
        if (start == target)
            return true;
        // 为什么不需要visited[]？是否会循环用重复的边？
        for (int[] entry : graph) {
            // 遍历所以边
            if (entry[1] == target){
            // 从target开始找
                return findWhetherExistsPath(n, graph, start, entry[0]);
            }
        }
        return false;
    }
}
