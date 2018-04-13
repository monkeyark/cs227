package exam2;

import java.util.ArrayList;

public class Exam {

	public static double average(double []arr){
		double sum = 0;
		double averageValue;
		for(int i = 0; i < arr.length; i++){
			sum += arr[i];
		}
		averageValue = sum/arr.length;
		return averageValue;
	}
	
//	public static void main(String[] args) {
//		double []array = new double[]{1,2,3,4,5,6,7,8};
//		System.out.println(average(array));
//	}
	
	public static int[] getEvenNumbers(int []arr){
		int count = 0;
		for(int i = 0; i < arr.length; i++){
			if(arr[i]%2 == 0){
				count ++;
			}
		}
		int[] answer = new int[count];
		int k = 0;
		for(int i = 0; i<arr.length;i++){
			if(arr[i]%2 == 0){
				answer[k] = arr[i];
				k++;
			}
		}
		return answer;	
	}
//	public static void main(String[] args) {
//		int []array = new int[]{1,2,3,4,5,6,7,8};
//		System.out.println(Arrays.toString(getEvenNumbers(array)));
//	}
	public static void swapMaxToEnd(int []arr){		
		for(int i = 0; i < arr.length; i++){
			if (arr[i]>=arr[arr.length-1]){
				int temp = arr[i];
				arr[i] = arr[arr.length-1];
				arr[arr.length-1] = temp;
			}
		}
	}
//	public static void main(String[] args) {
//		int []array = new int[]{100,86,343,5654,7676,23,222};
//		swapMaxToEnd(array);
//		System.out.println(Arrays.toString(array));
//	}
	public static boolean containsDuplicate(ArrayList<String> words){
		for(int i = 0; i < words.size(); i++){
			for(int j=i+1; j < words.size(); j++){
				if (words.get(i).equals(words.get(j))){
					return true;
				}
			}			
		}
		return false;
	}
	
	
//	public static void main(String[] args) {
//	ArrayList<String> jikang = new ArrayList<String>();
//	jikang.add("SSG");
//	jikang.add("SKT");
//	jikang.add("RNG");
//	jikang.add("WE");
//	jikang.add("LZ");
//	System.out.println(containsDuplicate(jikang));
//}
	public static int countTerms(double Target){
		double n = 2;
		double sum = 0;
		while (sum <= Target){
			sum = sum + 1/n;
			n = n + 1;
		}
		return (int)(n-2);
	}
	public static void main(String[] args) {
	double Target = 2.0;
	System.out.println(countTerms(Target));
}
	
	
	
	public static String newString(String s){
		String newS="";
		for(int i = 0; i < s.length(); i++){
			if (!Character.isAlphabetic(s.charAt(i))){
				newS = s.replace(s.charAt(i),'#');
			}
		}
		for(int i = 0; i < s.length(); i++){
			newS = newS.replace(' ', '#');
		}
		return newS;
	}
	
//	public static void main(String[] args) {
//		String junjun = new String("junjun!!  zhizhang!!");
//		System.out.println(newString(junjun));
//	}
	
	
	
	
	
	
	
	
	
	
	
}
