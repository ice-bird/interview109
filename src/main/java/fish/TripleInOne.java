package fish;
// 面试宝典 0301
class TripleInOne {
    // 意思就是用数组，同时实现三个栈，stack1 stack2 stack3
    // 方法：一维数组分三段，2为数组3*n
    // 成员变量
    int stackSize;
    int N = 3;
    int[][] data;
    int[] top; //记录栈顶位置(准确说是顶+1)
    // 栈底可以算

    public TripleInOne(int stackSize) {
            this.stackSize = stackSize;
            data = new int[N][stackSize];
            top = new int[N];
            // 且自动初始化为0，如果是一维数组，则要自己初始化
        }
        
        public void push(int stackNum, int value) {
            // stackNum是编号
            // 注意合法性校验
            if (top[stackNum] == stackSize) {
                //表示已满
                return;
            } else {
                data[stackNum][top[stackNum]] = value;
                top[stackNum]++;  //栈顶指针上移
            }
        }
        
        public int pop(int stackNum) {
            if (top[stackNum] == 0) {
                //表示已满
                return -1;
            } else {
                int topIndex = top[stackNum] - 1;
                int res = data[stackNum][topIndex];
                data[stackNum][topIndex] = 0; //置零
                top[stackNum] = topIndex;    // 指针变化
                return res;
                // 先-- 再赋值
            }
        }
        
        public int peek(int stackNum) {
            // 只查看，不弹出
            if (top[stackNum] == 0) {
                //表示已满
                return -1;
            } else {
                int topIndex = top[stackNum]-1;
                return data[stackNum][topIndex];
                // 先-- 再赋值
            }
        }
        
        public boolean isEmpty(int stackNum) {
            return top[stackNum] == 0;
        }
    }
