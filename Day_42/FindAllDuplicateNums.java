package may_15;

import java.util.ArrayList;
import java.util.List;

public class FindAllDupNums {
	
	private static List<Integer> findAllDupNums(int[] arr) {
		List<Integer> result = new ArrayList<>();
		if(arr==null || arr.length==0) 
			return result;
		for(int index=0;index<arr.length;) {
			if(arr[index]!=arr[arr[index]-1]) {
				swap(arr,index,arr[index]-1);
			}
			else {
				index++;
			}
		}
		for(int index=0;index<arr.length;index++) {
			if(arr[index]!=index+1) {
				result.add(arr[index]);
			}
		}
		return result;
	}
	
	private static void swap(int[] arr,int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

	public static void main(String[] args) {
		System.out.println(findAllDupNums(new int[] {3,4,4,5,5}));
		System.out.println(findAllDupNums(new int[] {5,4,7,2,3,5,3}));

	}

}
