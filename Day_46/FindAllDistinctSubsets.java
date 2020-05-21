package may_21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllDistinctSubsets {
	
	private static List<List<Integer>> findAllDistinctSubsets(int[] arr) {
		List<List<Integer>> result = new ArrayList<>();
		//sort the array
		Arrays.sort(arr);
		//create an empty list
		result.add(new ArrayList<Integer>());
		//iterate through each element in arr
		int startIndex=0,endIndex=0;
		for(int i=0;i<arr.length;i++) {
			//copy list from result and add curr element to each list
			
			startIndex=0;
			if(i>0 && arr[i]==arr[i-1]) {
				startIndex=endIndex;
			}
			endIndex=result.size();
			for(int j=startIndex;j<endIndex;j++) {
				ArrayList<Integer> temp = new ArrayList<>(result.get(j));
				temp.add(arr[i]);
				result.add(temp);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr=new int[] {1,5,3,3};
		System.out.println(findAllDistinctSubsets(arr));

	}

}
