package may_27;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
	//Runs in O(n) time complexity and O(1) space complexity
	private static int[] productOfArrayExceptSelf(int[] input) {
		if(input==null || input.length==0)
			throw new IllegalArgumentException();
		//treat output array as leftProduct array
		int[] output=new int[input.length];
		for(int i=0;i<input.length;i++) {
			if(i==0) {
				output[i]=1;
			}
			else {
				output[i]=output[i-1]*input[i-1];
			}
		}
		//take a variable R which will act as products of elements on right
		int R=1;
		for(int i=input.length-1;i>=0;i--) {
			output[i]=output[i]*R;
			R=R*input[i];
		}
		return output;
	}

	public static void main(String[] args) {
		int[] input=new int[] {1,2,3,4};
		int[] result=productOfArrayExceptSelf(input);
		System.out.println(Arrays.toString(result));

	}

}
