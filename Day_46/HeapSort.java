package may_21;

public class HeapSort {
	
	private static void heapSort(int[] arr) {
		//check error conditions
		if(arr==null || arr.length==0)
			return;
		//build the heap
		buildHeap(arr);
		for(int i=arr.length-1;i>0;i--) {
			swap(arr,0,i);
			heapifyDown(arr,0,i-1);
		}
	}
	
	private static void buildHeap(int[] arr) {
		for(int i=(arr.length-1)/2;i>=0;i--) {
			heapifyDown(arr,i,arr.length-1);
		}
	}
	
	private static void swap(int[] arr,int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	private static void heapifyDown(int[] arr,int i,int size) {
		int leftChild=2*i+1;
		int rightChild=2*i+2;
		int max=i;
		if(leftChild<=size) {
			max=arr[leftChild]>arr[i]?leftChild:i;
		}
		if(rightChild<=size) {
			max=arr[rightChild]>arr[max]?rightChild:max;
		}
		if(max!=i) {
			swap(arr,max,i);
			heapifyDown(arr,max,size);
		}
		
	}

	public static void main(String[] args) {
		int[] arr=new int[] {8,2,4,9,3,4,3,6,7,4};
		heapSort(arr);
		for(int i:arr)
			System.out.print(i+" ");

	}

}
