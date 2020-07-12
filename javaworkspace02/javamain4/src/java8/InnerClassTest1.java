package java8;

public class InnerClassTest1 {
	public Comparable getComparable() {
		class mycomparable implements Comparable{

			@Override
			public int compareTo(Object o) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		}
		return new mycomparable();
	}
}
