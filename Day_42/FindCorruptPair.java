package may_15;

public class FindCorruptPair {
	
	public static int[] findCorruptPair(int[] arr) {
		if(arr==null || arr.length==0)
			throw new IllegalArgumentException();
		for(int index=0;index<arr.length;) {
			if(arr[index]!=arr[arr[index]-1]) {
				swap(arr,index,arr[index]-1);
			}
			else {
				index++;
			}
		}
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=i+1) {
				return new int[] {arr[i],i+1};
			}
		}
		return new int[] {};
	}
	
	private static void swap(int[] arr,int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

	public static void main(String[] args) {
		int[] pair=findCorruptPair(new int[] {3,1,2,3,6,4});
		for(int i:pair) {
			System.out.print(i+" ");
		}

	}

}
