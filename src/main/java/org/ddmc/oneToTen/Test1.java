package org.ddmc.oneToTen;

import java.util.Arrays;

/**
 * @author Lan
 * @date 2023/1/18
 */
//两数之和
//给定一个整数数组nums和一个整数目标值target  在数组中找到和为目标值的那两个整数，并返回他们的数组下标   进阶：时间复杂度小于O(n²)
public class Test1 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int i1 = i + 1; i1 < nums.length; i1++) {
                if (nums[i] + nums[i1] == target) {
                    return new int[]{i, i1};
                }
            }
        }
        return null;
    }
}
