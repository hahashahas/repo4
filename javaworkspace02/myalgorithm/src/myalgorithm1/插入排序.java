package myalgorithm1;

public class 插入排序 {
	static void insertsort(int arr[],int k) {
		if(k==0) return;
		insertsort(arr,k-1);
		int x=arr[k];
		int index=k-1;
		while(index>-1&&x<arr[index]) {
			arr[index+1]=arr[index];
			index--;
		}
		arr[index+1]=x;
	}
	public static void main(String[] args) {
		int [] arr= {3,2,4,1,8};
		insertsort(arr,4);
		for(int i=0;i<=4;i++)
		System.out.print(arr[i]+" ");
	}
}
