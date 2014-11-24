import java.util.Random;
public class Eight_Queens {
	static int Queens_num=8;
	static int[] Queens = new int[Queens_num];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		random_model();
		HC();
		
	}
	public static void HC(){
		System.out.println(Score(Queens));
		int minx=0;
		int miny=0;
		int minscore=1000;
		int tmp,tmpj;
		for(int k=0;k<10;k++){
			
			for(int i=0;i<Queens.length;i++){
				tmpj=Queens[i];
				for(int j=0;j<Queens.length;j++){
					Queens[i]=j;
					if((tmp=Score(Queens))<minscore){
						minscore=tmp;
						minx=i;
						miny=j;
					}
				}
				Queens[i]=tmpj;
			}
			Queens[minx]=miny;
			System.out.println(Score(Queens));
		}

		
		
		
		
		System.out.println("!!");

	}
	public static void random_model(){
		for(int i=0;i<Queens.length;i++){
			Random ran = new Random();
			Queens[i]=ran.nextInt(8);
			
		}
	}
	public static int Score(int[] queens){
		int score=0;
		for(int i=0;i<queens.length;i++){
			for(int j=0;j<queens.length;j++){
				if(i==j){
					continue;
				}
				if(queens[i]==queens[j]){
					
					score++;
					//System.out.println("i="+i+"	j="+j+"	score="+score);
					//System.out.println("queens[i]==queens[j]"+queens[i]+","+queens[j]);
				}
				if((i-j)*(i-j)==(queens[i]-queens[j])*(queens[i]-queens[j])){
					score++;
					//System.out.println("i="+i+"	j="+j+"	score="+score);
					//System.out.println("(i-j)*(i-j)="+(i-j)*(i-j));
					//System.out.println("(queens[i]-queens[j])*(queens[i]-queens[j])="+(queens[i]-queens[j])*(queens[i]-queens[j]));
				}
				
				//System.out.println("i="+i+"j="+j);
			}
		}
		return score;
	}
}
