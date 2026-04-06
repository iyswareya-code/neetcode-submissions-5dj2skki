class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[][] nums_array = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++){
            nums_array[i][0] = nums[i];
            nums_array[i][1] = i;
        }

        Arrays.sort(nums_array, Comparator.comparingInt(a -> a[0]));
        
        int low = 0, high = nums_array.length - 1;
        while(low < high){
            int sum = nums_array[low][0] + nums_array[high][0];
            if(sum == target){
                if(nums_array[low][1] < nums_array[high][1]){
                    return new int[]{nums_array[low][1], nums_array[high][1]};
                }else{
                    return new int[]{nums_array[high][1], nums_array[low][1]};
                }
            }
            if(sum < target){
                low++;
            }else{
                high--;
            }
        }
        return new int[0];
    }
}
