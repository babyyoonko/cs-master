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
        for (Integer element: map.keySet()) {
            if(map.get(element) > nums.length / 2){
                return element;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new question39_majorityElement().majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }
}
