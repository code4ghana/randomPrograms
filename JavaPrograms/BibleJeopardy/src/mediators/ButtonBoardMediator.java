package mediators;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class ButtonBoardMediator implements IMediator, SelectionListener{
	private Button button;
	private Composite composite;
	public ButtonBoardMediator(Button button,Composite composite){
		this.button=button;
		button.addSelectionListener(this);
		this.composite=composite;
		
	}
	@Override
	public void handle(Object event, Object optional) {
		// TODO Auto-generated method stub
		
		
	}
	@Override
	public void widgetSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
			button.setEnabled(false);
			composite.update();
		
	}
	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
