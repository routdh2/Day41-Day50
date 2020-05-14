package may_14;

public class CyclicSort {
	//Runs in O(n) Time complexity and O(1) space complexity
	private static void cyclicSort(int[] arr) {
		if(arr==null)
			return;
		for(int currentIndex=0;currentIndex<arr.length;) {
			int currNo=arr[currentIndex];
			//we have to place the currNo at its correct place
			int correctIndex=currNo-1;//since array indexing starts with 0
			if(currentIndex==correctIndex) {
				currentIndex++;
			}
			else {
				//swap with correct Index
				swap(arr,currentIndex,correctIndex);
			}
		}
	}
	
	private static void swap(int[] arr,int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

	public static void main(String[] args) {
		int[] arr=new int[] {1,5,6,4,3,2};
		cyclicSort(arr);
		for(int i:arr) {
			System.out.print(i+" ");
		}

	}

}
