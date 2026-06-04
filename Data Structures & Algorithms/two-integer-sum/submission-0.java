class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int smallerIndex = -1, largerIndex = -1;
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                smallerIndex = i > map.get(target - nums[i]) ? map.get(target - nums[i]) : i;
                largerIndex = i < map.get(target - nums[i]) ? map.get(target - nums[i]) : i;
                return new int[] {smallerIndex, largerIndex};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[] {-1,-1};

    }
}
