package models;


public class BackPart {
	
	private String answer;
	private int score;
	private int trials;
	public BackPart(String s){
	
		answer=s;
		score=1;
		trials=0;
	}
	public String getAnswer(){
		return answer;
	}
	
	public String toString(){
		return getAnswer();
	}

	public void mark(Boolean right){
		trials++;
		if(score>0){
			score+=right ? 0:1;
			return;
		}
		score+=right ? -1:1;
		
		
	}
	public void numMark(String ZeroToTen){
		
		try{
			score+=Integer.parseInt(ZeroToTen);
		}
		catch(Exception e){
			return;
		}
		
	}
	
	public double getScore(){
		return score>0?score:1; 
	}
	public boolean isequal(Object o){
		if(o instanceof BackPart){
			BackPart a=(BackPart)o;
			boolean same= a.answer.equals(getAnswer());
			same=same&& a.getScore()==getScore();
			return same;
		}
		return false;
	}
	
	
	
}
