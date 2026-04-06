class Solution {
    public int[] twoSum(int[] nums, int target) {
        var complimentToIndex = new HashMap<Integer, Integer>();
        var result = new int[2];
        for(int itr = 0; itr < nums.length; itr++){
            var compliment = target - nums[itr];
            if(complimentToIndex.containsKey(nums[itr])){
                result[0] = complimentToIndex.get(nums[itr]);
                result[1] = itr;
                return result;
            } else {
                complimentToIndex.put(compliment, itr);
            }
        }
        return new int[0];
    }
}
