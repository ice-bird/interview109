package fish.array;
// 先排序 12345
// 两两交换

import java.util.Arrays;

public class Inter1011 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2) {
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }
        // 每次+2步
    }

    // 改进，快排的时候如何操作？
    

}
