class Solution {
    public int findDuplicate(int[] nums) {
        HashSet set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                return num;
            }
            set.add(num);
        }
        return 0;
    }
}