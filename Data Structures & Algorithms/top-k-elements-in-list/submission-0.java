class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // We can use Priority Queue in Java to function as a Heap
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(new FrequencyComparator());
        
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: freqMap.entrySet()){
            heap.add(entry);
        }

        int count = 0;
        int[] res = new int[k];
        while( count < k){
            res[count++] = heap.poll().getKey();
        }

        return res;

    }
}

// Comparator class for comparing strings based on their length
class FrequencyComparator implements Comparator<Map.Entry<Integer,Integer>> {
    // Compare method to compare two strings based on their length
    public int compare(Map.Entry<Integer, Integer> s1, Map.Entry<Integer, Integer> s2) {
        return Integer.compare(s2.getValue(), s1.getValue());
    }
}
