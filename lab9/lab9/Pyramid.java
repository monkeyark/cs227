package lab9;

public class Pyramid {
	
	public static void main(String args[]){
		int result = getPyramidCount(2);
		System.out.println(result);
	}
	public static int getPyramidCount(int n){
		if(n==1){
			return 1;
		}else{
			return n*n + getPyramidCount(n-1);
		}
	}
}
