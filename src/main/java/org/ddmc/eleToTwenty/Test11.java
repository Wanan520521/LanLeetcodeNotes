package org.ddmc.eleToTwenty;

import java.util.Arrays;

/**
 * @author Lan
 * @date 2023/11/15
 */
//560.和为k的子数组
//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
//
//子数组是数组中元素的连续非空序列。
//
//
//
//示例 1：
//
//输入：nums = [1,1,1], k = 2
//输出：2
//示例 2：
//
//输入：nums = [1,2,3], k = 3
//输出：2
public class Test11 {
    public static void main(String[] args) {
        int[] que = new int[]{1, 2, 3};
        int k = 3;
        System.out.println(subarraySum(que, k));
    }

    public static int subarraySum(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            if (nums[i] == k) {
                ans++;
            }
            sum += nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    ans++;
                }
            }
        }
        return ans;

    }
}
