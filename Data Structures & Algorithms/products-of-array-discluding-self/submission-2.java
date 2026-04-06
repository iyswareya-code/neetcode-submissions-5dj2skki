class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] frwd_ar = new int[nums.length], rev_ar = new int[nums.length];
        frwd_ar[0] = nums[0]; rev_ar[nums.length - 1] = nums[nums.length -1];
        for(int i = 1, j = nums.length - 2 ; i < nums.length; i++, j--){
            frwd_ar[i] = frwd_ar[i-1] * nums[i];
            rev_ar[j] = rev_ar[j+1] * nums[j];
        }
        int[] res = new int[nums.length];
        res[0] = rev_ar[1];
        res[nums.length-1] = frwd_ar[nums.length-2];
        for(int i = 1; i < nums.length - 1; i++){
            res[i] = frwd_ar[i - 1] * rev_ar[i + 1]; 
        }
        return res;
    }
}  
