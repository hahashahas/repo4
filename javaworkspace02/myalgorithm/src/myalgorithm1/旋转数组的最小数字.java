package myalgorithm1;

public class 旋转数组的最小数字 {
	static int min(int []arr) {
		int begin=0;
		int end=arr.length-1;
		if(arr[begin]<arr[end]) return arr[begin];
		while(begin+1<end) {
			int mid=begin+((end-begin)>>1);
			if(arr[mid]>=arr[begin]) {
				begin=mid;
			}else {
				end=mid;
			}
		}
		return arr[end];
	}
	public static void main(String[] args) {
		int[]arr= {5,1,2,3,4};
		int res=min(arr);
		System.out.println(res);
	}
}
