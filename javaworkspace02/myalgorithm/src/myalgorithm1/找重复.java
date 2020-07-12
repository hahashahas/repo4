package myalgorithm1;
import java.util.Random;
class Util {
	public static void swap(int[] arr, int x, int y) {
		int temp;
		temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	public static void print(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			if (i != arr.length - 1)
				System.out.print(arr[i] + " ");
			else
				System.out.print(arr[i]);
		}
		System.out.println("]");
	}
}
public class 找重复 {
	public static void main(String[] args) {
		int N = 11;
		int[] arr = new int[N];

		for (int i = 0; i < arr.length - 1; i++) {
			arr[i] = i + 1;
		}
		arr[arr.length - 1] = new Random().nextInt(N - 1) + 1;
		int index = new Random().nextInt(N);
		Util.swap(arr, index, arr.length - 1);
		Util.print(arr);
		int x1 = 0;
		for (int i = 1; i <= N - 1; i++) {
			x1 = (x1 ^ i);
		}
		for (int i = 0; i < N; i++) {
			x1 = x1 ^ arr[i];
		}
		System.out.println(x1);
		System.out.println("==================================");
		int []helper= new int[N];
		for (int i = 0; i <N; i++) {
			helper[arr[i]]++;
		}
		for (int i = 0; i <N; i++) {
			if (helper[i] == 2) {
				System.out.println(i);
				break;
			}
		}
	}
}
