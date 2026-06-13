class Solution {
    private static String DELIMITER = "~";

    public String encode(List<String> strs) {
        if(strs.size() == 0) return "";
        StringBuilder sb = new StringBuilder();
        strs.stream().forEach(x -> sb.append(x.length()).append(DELIMITER).append(x));
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        
        while (i < str.length()) {
            // 1. Find the exact position of the next delimiter
            int delimiterIndex = str.indexOf(DELIMITER, i);
            
            // 2. Extract the length of the word (works for 1 digit, 2 digits, etc.)
            int num = Integer.valueOf(str.substring(i, delimiterIndex));
            
            // 3. Extract the word itself
            int wordStart = delimiterIndex + 1;
            int wordEnd = wordStart + num;
            res.add(str.substring(wordStart, wordEnd));
            
            // 4. Jump 'i' directly to the start of the next number
            i = wordEnd;
        }
        
        return res;
    }
}
