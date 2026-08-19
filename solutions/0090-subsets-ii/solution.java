class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(nums);
        list.add(new ArrayList<>());
        int start=0,end=0;
        for(int i=0;i<nums.length;i++){
            start=0;
            int size=list.size();
            if(i>0 && nums[i]==nums[i-1]){
                start=end+1;
            }
            end=size-1;
            for(int j=start;j<size;j++){
                List<Integer> list1=new ArrayList<>(list.get(j));
                list1.add(nums[i]);
                list.add(list1);
            }
        }
        return list;
    }
}
