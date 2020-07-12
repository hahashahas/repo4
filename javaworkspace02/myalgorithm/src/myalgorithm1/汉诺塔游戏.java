package myalgorithm1;

public class 汉诺塔游戏 {
	public static void main(String[] args) {
		Hannuopower(3,"A","B","C");
	}
	static void Hannuopower(int N,String from,String to,String help) {
		if(N==1) {
			System.out.println("move "+N+" from "+from+" to "+to);
		}else {
			Hannuopower(N-1,from,help,to);
			System.out.println("move "+N+" from "+from+" to "+to);
			Hannuopower(N-1,help,to,from);
		}
	}
}
