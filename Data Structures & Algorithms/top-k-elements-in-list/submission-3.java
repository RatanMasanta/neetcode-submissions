class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // for every element:
        // if element is already a key in map,
        // add 1 to value.
        // else if element is not yet a key,
        // make a new key-value pair with a value of 1.

        HashMap<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        // make an ArrayList<Integer>[] the size of nums + 1.
        // for every pair in the map:
        // add the key to the arraylist onto the index of its value.

        @SuppressWarnings("unchecked") 
        ArrayList<Integer>[] buckets = (ArrayList<Integer>[]) new ArrayList[nums.length + 1];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            Integer key = entry.getKey();
            Integer val = entry.getValue();

            buckets[val].add(key);
        }

        // return the Kth elements starting from the last index of the arraylist
        int[] res = new int[k];
        int idx = 0;

        for (int i = buckets.length - 1; i >= 0; i--) {
            for (int j = buckets[i].size() - 1; idx < k && j >= 0; j--) {
                if (buckets[i].size() > 0) {
                    res[idx] = buckets[i].get(j);
                    idx++;
                } else {
                    continue;
                }
            }
        }

        return res;
    }
}
