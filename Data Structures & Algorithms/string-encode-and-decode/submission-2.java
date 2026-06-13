class Solution {
           private final String delimiter = "@@@@@";
    private final String emptyString = "____________";

    public String encode(List<String> strs) {
        return encodeWithSize(strs);
    }

    private String encodeSimple(List<String> strs) {
        List<String> encoded = new ArrayList<>(strs);
        for (int i = 0; i < encoded.size(); i++) {
            if (encoded.get(i).isEmpty()) {
                encoded.set(i, emptyString);
            }
        }
        return String.join(delimiter, encoded);
    }


    private String encodeWithSize(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s.length()).append('#').append(s);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        return decodeWithSize(str);
    }

    private List<String> decodeSimple(String str) {
        if (str.isEmpty()) {
            return new ArrayList<>();
        }
        String[] parts = str.split(delimiter);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals(emptyString)) {
                parts[i] = "";
            }
            result.add(parts[i]);
        }
        return result;
    }

    private List<String> decodeWithSize(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;

            while (str.charAt(j) != '#') {
                j++;
            }
            int size = Integer.parseInt(str.substring(i, j));
            String newString = str.substring(j + 1, j + 1 + size);
            res.add(newString);
            i = j + 1 + size;
        }
        return res;
    }
}
