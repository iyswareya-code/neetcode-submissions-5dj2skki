class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int itr=0; itr < nums.length; itr++){
            if(set.contains(nums[itr])){
                return true;
            }
            set.add(nums[itr]);
        }
        return false;
    }
}