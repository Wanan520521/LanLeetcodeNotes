package org.ddmc.oneToTen;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Lan
 * @date 2023/11/10
 */
// 15 三数之和
// 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
//
//你返回所有和为 0 且不重复的三元组。
//
//注意：答案中不可以包含重复的三元
// 组。
public class Test8 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        nums = Arrays.stream(nums).sorted().toArray();
        int x = 0, y = nums.length - 1;
        while (x < y) {
            while (x < y) {
                for (int i = x + 1; i < y; i++) {
                    if (nums[x] + nums[i] + nums[y] == 0) {
                        ArrayList<Integer> integers = new ArrayList<>();
                        integers.add(nums[x]);
                        integers.add(nums[i]);
                        integers.add(nums[y]);
                        lists.add(integers);
                    }
                }
                y--;
            }
            y = nums.length - 1;
            x++;
        }
        List<List<Integer>> collect = lists.stream().distinct().collect(Collectors.toList());
        return collect;
    }
}
