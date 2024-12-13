class Solution {
    public long findScore(int[] nums) {
         Set<Integer> markerSet= new HashSet<>();
         int result=0;
        while(markerSet.size()<nums.length)
        {
            int index=nextSmallest(nums,markerSet);
            result+=nums[index];
            markAdjacent(index,nums,markerSet);
        }
        return result;
    }
    private int nextSmallest(int nums[],Set<Integer> set)
    {
        int minIndex=-1;
        int minValue=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(!set.contains(i))
            {
                if(minValue>nums[i])
                {
                    minValue = nums[i];
                    minIndex= i;
                }
            }
        }
        return minIndex;
    }
    private void markAdjacent(int index,int arr[],Set<Integer> set)
    {
        set.add(index);
        if(index+1<arr.length)
        set.add(index+1);
        if(index-1>=0)
        set.add(index-1);
    }
}