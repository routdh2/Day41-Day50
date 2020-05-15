package may_15;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindKPositiveMissingNums {
	
	private static List<Integer> findFirstKMissingPositiveNums(int[] arr, int k) {
		List<Integer> missingNums = new ArrayList<>();
		if(arr==null || arr.length==0)
			return missingNums;
		//sort it by cyclic sort
		for(int index=0;index<arr.length;) {
			//ignore numbers which are negative or out of the bounds
			if(arr[index]>0 && arr[index]<=arr.length && arr[index]!=arr[arr[index]-1]) {
				swap(arr,index,arr[index]-1);
			}
			else {
				index++;
			}
		}
		
		Set<Integer> extraNumbers = new HashSet<>();// to keep track of numbers which are positive but out of the bounds
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=i+1) {
				missingNums.add(i+1);
				if(missingNums.size()==k) {
					return missingNums;
				}
				extraNumbers.add(arr[i]);
			}
		}
		//add more positive numbers which are not already present in extraNumbers
		for(int i=1;missingNums.size()<k;i++) {
			int num=i+arr.length;
			if(!extraNumbers.contains(num)) {
				missingNums.add(num);
			}
		}
//		if(result.size()<k) {
//			result.add(arr[arr.length-1]+1);
//		}
//		while(result.size()!=k) {
//			int num=result.get(result.size()-1);
//			result.add(num+1);
//		}
		return missingNums;
	}
	
	private static void swap(int[] arr, int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

	public static void main(String[] args) {
		System.out.println(findFirstKMissingPositiveNums(new int[] {3,-1,4,5,5}, 3));
		System.out.println(findFirstKMissingPositiveNums(new int[] {2,3,4}, 3));
		System.out.println(findFirstKMissingPositiveNums(new int[] {-2,-3,4}, 2));

	}

}
