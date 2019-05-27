package cn.byhieg.arithmetic;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by weizhaoquan on 2019/05/09.
 */
public class TwoSum {
    public static int[] twoSum1(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            int val = target - nums[i];
            if(map.containsKey(val) && map.get(val) != i){
                return new int[]{i, map.get(val)};
            }
        }
        throw new RuntimeException("No such solution!");
    }
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int val = target - nums[i];
            if(map.containsKey(val)) {// 肯定不会map.get(val) == i
                return new int[]{i, map.get(val)};
            }
            map.put(nums[i], i);
        }
        throw new RuntimeException("No such solution!");
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int taget = 9;
        int[] ints = twoSum2( nums, taget );
        System.out.printf( Arrays.toString(ints) );
    }
}
