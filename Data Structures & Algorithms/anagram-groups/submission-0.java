class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for(String str : strs){
            int[] char_count = new int[26];
            for(char c : str.toCharArray()){
                char_count[c - 'a']++;
            }
            String key = Arrays.toString(char_count);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(str);
        }

        return new ArrayList<>(res.values());
    }
}
