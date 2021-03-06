package lzy.cs.algorithm.killalloffer;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class question39_majorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.replace(nums[i], map.get(nums[i]) + 1);
            }
        }
        for (Integer element : map.keySet()) {
            if (map.get(element) > nums.length / 2) {
                return element;
            }
        }
        return -1;
    }

    // 1 2 3 2 2 2 5 4 2
    public int majorityElement2(int[] nums) {
        int number = 0;
        int votes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (votes == 0) {
                number = nums[i];
            }
            votes += number == nums[i] ? 1 : -1;
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println(new question39_majorityElement().majorityElement2(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }
}
