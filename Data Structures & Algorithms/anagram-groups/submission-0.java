class Solution {
    static int MAX_SIZE = 26;
    static String DELIMITER = "$";
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, Integer> frequencyMap = new HashMap<>();
        for(int i = 0; i < strs.length ; i++){
            String key = getHash(strs[i]);
            if(!frequencyMap.containsKey(key)){
                frequencyMap.put(key, res.size());
                res.add(new ArrayList<>());
            }
            res.get(frequencyMap.get(key)).add(strs[i]);
        }
        return res;
        
    }

    private String getHash(String s) {
        StringBuilder hash = new StringBuilder();
        int freq[] = new int[MAX_SIZE];
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a'] ++;
        }
        for(int i = 0; i < MAX_SIZE; i++){
            hash.append(freq[i]);
            hash.append(DELIMITER);
        }
        return hash.toString();
    }

}
