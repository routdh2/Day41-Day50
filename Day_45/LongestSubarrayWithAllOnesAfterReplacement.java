package may_18;

import java.util.HashMap;

public class LongestSubarrayWithOnesAfterReplacement {
	
	private static int longestSubarrayWithOnesAfterReplacement(int[] arr,int k) {
		//check error conditions
		if(arr==null || arr.length==0)
			return 0;
		//create a map to keep track of no of 1's and 0's in curr window
		HashMap<Integer,Integer> map = new HashMap<>();
		int windowStart=0,maxLength=0;
		for(int windowEnd=0;windowEnd<arr.length;windowEnd++) {
			int key=arr[windowEnd];
			//put it into map
			map.put(key,map.getOrDefault(key, 0)+1);
			//if no of 0's in curr windows exceeds K, then shrink window
			if(map.get(0)>k) {
				int num = arr[windowStart];
				//reduce count in map
				map.put(num,map.get(num)-1);
				windowStart++;
			}
			maxLength=Math.max(maxLength, windowEnd-windowStart+1);
			
		}
		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println(longestSubarrayWithOnesAfterReplacement(new int[] {0,1,1,0,0,0,1,1,0,1,1}, 2));
		System.out.println(longestSubarrayWithOnesAfterReplacement(new int[] {0,1,0,0,1,1,0,1,1,0,0,1,1}, 3));
	}

}
