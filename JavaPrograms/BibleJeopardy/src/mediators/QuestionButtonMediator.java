package mediators;
import gui.JeopardyBoard;
import gui.QuestionWindow;
import model.Question;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;




public class QuestionButtonMediator implements IMediator, SelectionListener{
	Question question;
	Button button;
	JeopardyBoard board;
	public QuestionButtonMediator(Question question,Button button,JeopardyBoard board){
		this.question=question;
		question.attach(this);
		this.button=button;
		this.board=board;
		button.addSelectionListener(this);

	}
	
	@Override
	public void handle(Object event, Object optional) {
		// TODO Auto-generated method stub
		if(event instanceof Question.QuestionEvent){
			switch((Question.QuestionEvent)event){
			case ANSWERED: button.setEnabled(false);
			button.setGrayed(true);
			
			}
		}
	}
	public String toString(){
		return question.getQuestion().substring(0,10)+"->"+button.getText();
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		board.shell.setEnabled(false);
		
			new QuestionWindow(question,board.currentPlayer).open();
			board.updateScore();
			board.setNextPlayer();
			board.shell.setEnabled(true);
		
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
