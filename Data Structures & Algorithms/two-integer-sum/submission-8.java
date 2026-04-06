class Solution {
    public int[] twoSum(int[] nums, int target) {
        var complimentToIdx = new HashMap<Integer, Integer>();
        var result = new int[2];

        for (var i = 0; i < nums.length; i++) {
            var compliment = target - nums[i];

            if (complimentToIdx.containsKey(nums[i])) {
                result[0] = complimentToIdx.get(nums[i]);
                result[1] = i;

                return result;
            } else {
                complimentToIdx.put(compliment, i);
            }
        }

        return new int[0];
    }
}
