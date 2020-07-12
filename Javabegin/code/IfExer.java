import java.util.Scanner;
class IfExer 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner (System.in);
		long start=System.currentTimeMillis();
		int a=0;
		label:for(int i=0;i<1000;i++)
		{
			for(int j=1;j<40;j++){
				//System.out.println("Hello World!");
				if(j%4==0) {
					System.out.println(j);
					break label;
					}
			}
		}
		//System.out.println(a);
		long end=System.currentTimeMillis();
		//System.out.println(end-start);
	}
}
