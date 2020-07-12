package myalgorithm1;

public class 字符串数组 {
	public static void main(String[] args) {
		String []arr= {"a","","ac","","ad","b","","ba"};
		int res=indexof(arr,"b");
		System.out.println(res);
	}
	private static int indexof(String[]arr,String p) {
		int begin=0;
		int end=arr.length-1;
		while(begin<=end) {
			int indexofmid=begin+((end-begin)>>1);
			while(arr[indexofmid].equals("")) {
				indexofmid++;
				if(indexofmid>end) {
					return -1;
				}
			}
			if(arr[indexofmid].compareTo(p)>0) {
				end=indexofmid-1;
			}else if(arr[indexofmid].compareTo(p)<0) {
				begin=indexofmid+1;
			}else {
				return indexofmid;
			}
		}
		return -1;
	}
}
