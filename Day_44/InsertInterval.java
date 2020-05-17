//Problem Statement: https://leetcode.com/problems/insert-interval/
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //check error conditions
        if(intervals==null || intervals.length==0) {
            return new int[][]{newInterval};
        }
        List<int[]> list = new ArrayList<>();
        //find the index where new interval to be inserted
        for(int i=0;i<intervals.length;i++) {
            if(newInterval[0]<intervals[i][0]) {
                //index=i;
                list.add(newInterval);
            }
            list.add(intervals[i]);
        }
        if(list.size()==intervals.length) {
            list.add(newInterval);
        }
        List<int[]> result = new ArrayList<>();
        int start=list.get(0)[0];
        int end=list.get(0)[1];
        for(int i=1;i<list.size();i++) {
            int nextStart=list.get(i)[0];
            int nextEnd=list.get(i)[1];
            if(end>=nextStart) {
                //overlapping condition
                end=Math.max(end,nextEnd);
            }
            else {
                //non overlapping condition
                result.add(new int[]{start,end});
                start=nextStart;
                end=nextEnd;
            }
        }
        result.add(new int[]{start,end});
        int[][] output=new int[result.size()][2];
        for(int i=0;i<result.size();i++) {
            output[i]=result.get(i);
        }
        return output;
        
    }
}
