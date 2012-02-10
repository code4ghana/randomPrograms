package model;
import java.util.ArrayList;
import java.util.HashSet;

import mediators.IMediator;



public class Question implements Observable{
	public enum QuestionEvent{ANSWERED};
HashSet<IMediator> meds;
String question;
ArrayList<String> choices;
String answer;
int points;
boolean answered;
public Question(String question,ArrayList<String> choices,String answer,int points){
	this.question=question;
	this.answer=answer;
	this.points=points;
	this.choices=choices;
	answered=false;
	meds=new HashSet<IMediator>();
//	6417153300----147335#
//	creame top and black pants
}

public boolean isAnswered(){
	return answered;
}
public String getQuestion() {
	return question;
}
public ArrayList<String> getChioces(){
	return choices;
}
public void answerQuestion(){
answered=true;
notifyMediators(QuestionEvent.ANSWERED,true);
}
public void setQuestion(String question) {
	this.question = question;
}
public String toString(){
	return question.substring(0,10);
}
public String getAnswer() {
	return answer;
}
public void setAnswer(String answer) {
	this.answer = answer;
}
public int getPoints() {
	return points;
}
public void setPoints(int points) {
	this.points = points;
}

@Override
public void attach(IMediator mediator) {
	// TODO Auto-generated method stub
meds.add(mediator);	
}

@Override
public void detach(IMediator mediator) {
	// TODO Auto-generated method stub
	meds.remove(mediator);
}

@Override
public void notifyMediators(Object event, Object option) {
	// TODO Auto-generated method stub
	for(IMediator med:meds){
		med.handle(event, option);
	}
}


}
