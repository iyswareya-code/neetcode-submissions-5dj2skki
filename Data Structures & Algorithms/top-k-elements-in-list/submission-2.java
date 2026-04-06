class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count_map = new HashMap<>();
        int[] res = new int[k];
        for(int num : nums){
            count_map.put(num, count_map.getOrDefault(num,0) + 1);
        }
        
        Map<Integer, List<Integer>> reverse_map = new TreeMap<Integer, List<Integer>>(Comparator.reverseOrder());
        for(int key : count_map.keySet()){
            int count = count_map.get(key);
            reverse_map.putIfAbsent(count, new ArrayList<>());
            reverse_map.get(count).add(key);
        }
        for(int res_itr = 0, k_itr = nums.length; k_itr > 0 && res_itr < k; k_itr--){
            if(reverse_map.containsKey(k_itr)){
                for(int elem : reverse_map.get(k_itr)){
                    res[res_itr++] = elem;
                    if(res_itr == k)
                        break;
                }
            }
        }
        
        return res;
    }
}
