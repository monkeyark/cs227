package lab9;

public class ArrayMaximum {
	
	public static void main(String args[]){
		int[] test = {1,2,3,70,100,89,777,1};
		int result = arrayMax(test);
		System.out.println(result);
	}
	
	public static int arrayMax(int[] arr){
		int result = arrayMaxVerbose(arr,0,arr.length-1);
		return result;
	}
	
	public static int arrayMaxVerbose(int[] arr, int start, int end){
		if(start == end){
			return arr[start];
		}else{
			int mid = (start + end)/2;
			int leftMax = compareTo(arr, start, mid);
			int rightMax = compareTo(arr, mid+1, end);
			if(leftMax > rightMax){
				return leftMax;
			}else{
				return rightMax;
			}
		}
	}
	
	public static int compareTo(int[] arr, int start, int end){
		//int max;
		if(end - start == 1){
			if(arr[start] > arr[end]){
				return arr[start];
			}else{
				return arr[end]; 
			}
		}else{
			return arrayMaxVerbose(arr,start, end);
		}
	}
}
