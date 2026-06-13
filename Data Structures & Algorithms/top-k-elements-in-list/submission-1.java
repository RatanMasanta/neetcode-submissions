class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Build the frequency map
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // 2. Initialize a Min-Heap
        // We use a lambda expression for a cleaner comparator: ascending by frequency
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.getValue(), b.getValue())
        );

        // 3. Keep the heap bounded to size k
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            heap.offer(entry);
            // If the heap grows larger than k, immediately remove the lowest frequency
            if (heap.size() > k) {
                heap.poll(); 
            }
        }

        // 4. Extract the top k keys
        int[] res = new int[k];
        // The heap contains the top k elements, but the smallest of those k is at the top.
        // We can just pop them into our array. 
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll().getKey();
        }

        return res;
    }
}

