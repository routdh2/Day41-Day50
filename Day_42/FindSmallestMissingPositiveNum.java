package may_15;

public class FindSmallestMissingPositiveNo {
	
	private static int findSmallestMissingPositiveNum(int[] arr) {
		if(arr==null || arr.length==0)
			throw new IllegalArgumentException();
		//sort it based on cyclic sort
		for(int index=0;index<arr.length;) {
			if(arr[index]>0 && arr[index]<=arr.length && arr[index]!=arr[arr[index]-1]) {
				swap(arr,index,arr[index]-1);
			}
			else {
				index++;
			}
		}
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=i+1) {
				return i+1;
			}
		}
		return -1;
	}
	
	private static void swap(int[] arr,int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

	public static void main(String[] args) {
		System.out.println(findSmallestMissingPositiveNum(new int[] {-3,1,5,4,2}));
		System.out.println(findSmallestMissingPositiveNum(new int[] {3,-2,0,1,2}));

	}

}
