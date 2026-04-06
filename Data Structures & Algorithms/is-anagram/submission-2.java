class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        if(s.length() != t.length()){
            return false;
        }
        char[] s_charArray = s.toCharArray(), t_charArray = t.toCharArray();
        for(int itr = 0; itr < s.length(); itr++){
            count[s.charAt(itr) - 'a']++;
            count[t.charAt(itr) - 'a']--;
        }
        for(int itr = 0; itr < 26; itr++){
            if(count[itr] != 0){
                return false;
            }
        }
        return true;
    }
}
