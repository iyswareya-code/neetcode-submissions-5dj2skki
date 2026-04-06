class Encoder {
    public static String encode(List<String> strs){
        if(strs.isEmpty()){
            return "";
        }
        StringBuilder res = new StringBuilder();
        res.append(strs.size() + "#");
        for(String str : strs){
            res.append(str.length() + "#");
        }
        for(String str : strs) {
            res.append(str);
        }
        return res.toString();     
        
        
    }

    private static int[] readInteger(String str, int start){
        int num = 0;
        while(start < str.length()){
            char c =str.charAt(start++);
            if(c == '#'){
                return new int[]{num, start};
            }
            if(c >= '0' && c <= '9' ){
                num = (num * 10) + (c - '0'); 
            } else {
                return new int[]{-1, -1};
            }
        }
        return new int[]{-1, -1};
    }
    
    private static String readString(String str, int start, int length){
        if(start + length > str.length())
            return null;
        return str.subSequence(start, start + length).toString();
    }
    
    public static List<String> decode(String str){
        //System.out.println("string : " + str);
        if(str.equals("")){
            return new ArrayList<>();
        }

        int[] total_arr = readInteger(str, 0);
        int string_count = total_arr[0];
        int next_ptr = total_arr[1];
        
        if(next_ptr <= 0){
            return new ArrayList<>();
        }
        
        List<String> res = new ArrayList<>(string_count);
        int[] string_len_arr = new int[string_count];
        
        for(int i = 0; i < string_count; i++){
            int[] arr = readInteger(str, next_ptr);
            string_len_arr[i] = arr[0];
            next_ptr = arr[1];
            if(next_ptr <= 0){
                return new ArrayList<>();
            }
        }
        int start = next_ptr;
        for(int i = 0; i < string_count; i++){
            //System.out.println("str " + i+" : " + start +" : "+ string_len_arr[i] );
            res.add(readString(str, start, string_len_arr[i]));
            start += string_len_arr[i];
        }
        
       return res; 
    }
}

class Solution {

    public String encode(List<String> strs) {
        return Encoder.encode(strs);
    }

    public List<String> decode(String str) {
        return Encoder.decode(str);
    }
}
