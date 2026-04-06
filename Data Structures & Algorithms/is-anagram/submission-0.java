class Solution {
    public boolean isAnagram(String s, String t) {
        int[] s_count = new int[26], t_count = new int[26];
        if(s.length() != t.length()){
            return false;
        }
        char[] s_charArray = s.toCharArray(), t_charArray = t.toCharArray();
        for(int itr = 0; itr < s_charArray.length; itr++){
            s_count[s_charArray[itr] - 'a']++;
            t_count[t_charArray[itr] - 'a']++;
        }
        return Arrays.equals(s_count, t_count);
    }
}
