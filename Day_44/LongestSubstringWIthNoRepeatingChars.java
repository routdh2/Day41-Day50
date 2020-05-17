package may_17;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestSubstringWithNoRepeatingChars {
	
	private static int findLongestSubstringWithNoRepeatingChars(String str) {
		//we will use sliding window pattern
		int windowStart=0,maxLength=0;
		HashMap<Character,Integer> map = new HashMap<>();
		for(int windowEnd=0;windowEnd<str.length();windowEnd++) {
			char key = str.charAt(windowEnd);
			//check if key is present in map
			if(map.containsKey(key)) {
				//update start pointer
				windowStart=Math.max(windowStart, map.get(key)+1);
			}
			//put the current char in map
			map.put(key, windowEnd);//map contains each char and its last seen index
			//update maxLength
			maxLength=Math.max(maxLength,windowEnd-windowStart+1);
		}
		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println(findLongestSubstringWithNoRepeatingChars("aabccbbabcde"));

	}

}
