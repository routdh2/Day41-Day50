package may_18;

import java.util.HashMap;

public class LongestSubstringWithSameLettersAfterReplacement {
	
	private static int longestSubstringWithSameLettersAfterReplacement(String str, int k) {
		//check error conditions
		if(str==null || str.length()==0)
			return 0;
		//create a map to store the char count
		//keep track of maximum repeating char in current window
		HashMap<Character,Integer> map = new HashMap<>();
		int maxRepeatingCharCount=0;
		int windowStart=0,maxLength=0;
		for(int windowEnd=0;windowEnd<str.length();windowEnd++) {
			char key = str.charAt(windowEnd);
			//put it into map
			map.put(key,map.getOrDefault(key, 0)+1);
			//update maximum repeating char count
			maxRepeatingCharCount=Math.max(maxRepeatingCharCount, map.get(key));
			//if the remaining char count exceeds K, then shrink the window size
			int currWindowSize=windowEnd-windowStart+1;
			int noOfRemainingLettersCanBeReplaced=currWindowSize-maxRepeatingCharCount;
			if(noOfRemainingLettersCanBeReplaced>k) {
				char c = str.charAt(windowStart);
				//reduce the count in map
				map.put(c,map.get(c)-1);
				//increase start pointer
				windowStart++;
			}
			//update the max length of longest substring
			maxLength=Math.max(maxLength, windowEnd-windowStart+1);
		}
		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println(longestSubstringWithSameLettersAfterReplacement("aabccbb", 2));
		System.out.println(longestSubstringWithSameLettersAfterReplacement("abbcb", 1));
		System.out.println(longestSubstringWithSameLettersAfterReplacement("abccde", 1));
	}

}
