package models;

public class FaceCard implements ISpreadAble{
	private String question;
	private BackPart answer;
	private Range myRange;

	public FaceCard(String ques,String ans) {
		question = ques;
		answer=new BackPart(ans);
	}
	
	public void setAnswer(String ans){

		answer=new BackPart(ans);

	}
	public void setRange(Range r){
		myRange=r;
	}
	public Range getRange(){
		return myRange;
	}
	public String getWord() {
		return question;
	}

	public void changeWord(String newWord) {
		question = newWord;
	}

	public double getPerformance() {
		return answer.getScore();
	}
	public void mark(boolean right){
		answer.mark(right);
	}

	public String getAnswer() {
		return answer.getAnswer();
	}
	public String toString()
	{
		return question;
	}
	public boolean equals(Object o){
		if(o instanceof FaceCard){
			FaceCard a=(FaceCard)o;
			boolean same=a.getWord().equals(getWord());
			same=same&& a.getAnswer().equals(getAnswer());
			same=same&& a.getPerformance()==getPerformance();
			return same;
		}
		return false;
	}
}
