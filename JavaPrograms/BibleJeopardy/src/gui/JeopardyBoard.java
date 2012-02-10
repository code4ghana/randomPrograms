package gui;

import io.GoGetter;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

import mediators.ButtonBoardMediator;
import mediators.QuestionButtonMediator;
import model.Category;
import model.Player;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class JeopardyBoard {
	public Shell shell;
	public ArrayList<Player> players;
	public ArrayList<Category> categories;
	public ArrayList<QuestionButtonMediator> questMeds;
	public ArrayList<ButtonBoardMediator> buttonMeds;
	public ArrayList<Button> questButtons;
	public ArrayList<Text> scoresTexts;
	public ExpandBar mainBar;
	public Composite gameBoardComp;
	public Composite scoreBoardComp;
	public ExpandItem gameBoardItem;
	public ExpandItem scoreBoardItem;
	public Player currentPlayer;
	
	private void loadSwtJar() {
	    try {
	        String osName = System.getProperty("os.name").toLowerCase();
	        String osArch = System.getProperty("os.arch").toLowerCase();
	        URLClassLoader classLoader = (URLClassLoader) getClass().getClassLoader();
	        Method addUrlMethod = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
	        addUrlMethod.setAccessible(true);

	        String swtFileNameOsPart = 
	            osName.contains("win") ? "win32" :
	            osName.contains("mac") ? "macosx" :
	            osName.contains("linux") || osName.contains("nix") ? "linux_gtk" :
	            ""; // throw new RuntimeException("Unknown OS name: "+osName)

	        String swtFileNameArchPart = osArch.contains("64") ? "x64" : "x86";
	        String swtFileName = "swt_"+swtFileNameOsPart+"_"+swtFileNameArchPart+".jar";
	        URL swtFileUrl = new URL("rsrc:"+swtFileName); // I am using Jar-in-Jar class loader which understands this URL; adjust accordingly if you don't
	        addUrlMethod.invoke(classLoader, swtFileUrl);
	    }
	    catch(Exception e) {
	        System.out.println("Unable to add the swt jar to the class path: ");
	        e.printStackTrace();
	    }
	}
	public JeopardyBoard(ArrayList<Category> cats, ArrayList<Player> players) {
		Display disp = new Display();
		shell = new Shell(disp);
		this.categories = cats;
		this.players = players;
	}
	
	public void init()
	{
		shell.setLayout(new FillLayout());
		shell.setText("Bible Jeopardy");
		mainBar = new ExpandBar(shell, SWT.V_SCROLL);
		questMeds = new ArrayList<QuestionButtonMediator>();
		buttonMeds = new ArrayList<ButtonBoardMediator>();
		questButtons = new ArrayList<Button>();
		scoresTexts = new ArrayList<Text>();
		currentPlayer=players.get(0);
		setUpGameBoard();
		setUpScoreBoard();	
	}
	
	
	public void setNextPlayer(){
		int position=players.indexOf(currentPlayer);
		if(position==(players.size()-1)){
			currentPlayer=players.get(0);
			return;
		}
		currentPlayer=players.get(++position);
		
	}
	public void updateScore(){
		int position=players.indexOf(currentPlayer);
		scoresTexts.get(position).setText(String.valueOf(currentPlayer.getPoints()));
	}

	public void run() {
		shell.open();
		shell.setMaximized(true);
		while (!shell.isDisposed()) {
			if (!shell.getDisplay().readAndDispatch()) {
				shell.getDisplay().sleep();
			}
		}
	}

	public void setUpGameBoard() {
		// composite setup
		gameBoardComp = new Composite(mainBar, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout = new GridLayout(categories.size(), true);
		layout.marginLeft = layout.marginTop = layout.marginBottom = 10;
		layout.marginRight = 10;
		layout.verticalSpacing = 10;

		gameBoardComp.setLayout(layout);
		// set up buttons
		for (Category cat : categories) {
			Label catLabel = new Label(gameBoardComp, SWT.BORDER_DOT);
			catLabel.setText(cat.getName());
			GridData gData = new GridData();
			gData.horizontalAlignment = GridData.CENTER;
			gData.grabExcessHorizontalSpace = true;
			gData.grabExcessVerticalSpace=true;
			catLabel.setLayoutData(gData);
		}
		for (int i = 0; i < categories.get(0).getQuesitons().size(); i++) {
			for (int j = 0; j < categories.size(); j++) {
				Button button = new Button(gameBoardComp, SWT.PUSH);
				GridData gData = new GridData(SWT.FILL, SWT.FILL, true, true);
				gData.grabExcessHorizontalSpace = true;
				button.setLayoutData(gData);
				int points = categories.get(j).getQuesitons().get(i)
						.getPoints();
				button.setText(String.valueOf(points));
				questButtons.add(button);
				questMeds.add(new QuestionButtonMediator(categories.get(j)
						.getQuesitons().get(i), button,this));
				buttonMeds.add(new ButtonBoardMediator(button, gameBoardComp));
			}

		}

		gameBoardItem = new ExpandItem(mainBar, SWT.NONE, 0);
		gameBoardItem.setText("Questions Board");
		gameBoardItem.setHeight(gameBoardComp.computeSize(SWT.DEFAULT,
				SWT.DEFAULT).y);
		gameBoardItem.setControl(gameBoardComp);
		gameBoardItem.setImage(shell.getDisplay().getSystemImage(
				SWT.ICON_QUESTION));
	}

	public void setUpScoreBoard() {
		scoreBoardComp = new Composite(mainBar, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns=5;
		scoreBoardComp.setLayout(layout);

		for (Player player : players) {
			Label playName = new Label(scoreBoardComp, SWT.BORDER_DOT);
			playName.setText(player.getName());
			GridData gData = new GridData();
			gData.horizontalSpan=1;
			gData.horizontalAlignment=SWT.FILL;
	
			playName.setLayoutData(gData);

			Text scoreText = new Text(scoreBoardComp, SWT.BORDER | SWT.MULTI
					| SWT.READ_ONLY|SWT.CENTER);
			scoreText.setText(String.valueOf(player.getPoints()));
			gData = new GridData();
			gData.horizontalAlignment=SWT.FILL;
			
			gData.grabExcessHorizontalSpace=true;
			gData.horizontalSpan = 2;
			
			scoreText.setLayoutData(gData);
			Label eatSpace= new Label(scoreBoardComp,SWT.NONE);
			gData=new GridData();
			gData.horizontalAlignment=SWT.BEGINNING;
			gData.horizontalSpan=2;
			gData.grabExcessHorizontalSpace=true;
			eatSpace.setLayoutData(gData);
			// scoreText.setLayoutData(new
			// GridData(GridData.HORIZONTAL_ALIGN_FILL));
			scoresTexts.add(scoreText);

		}
		

		scoreBoardItem = new ExpandItem(mainBar, SWT.NONE, 1);
		scoreBoardItem.setText("Scores");
		scoreBoardItem.setHeight(scoreBoardComp.computeSize(SWT.DEFAULT,
				SWT.DEFAULT).y);
		scoreBoardItem.setControl(scoreBoardComp);
		scoreBoardItem.setImage(shell.getDisplay().getSystemImage(
				SWT.ICON_INFORMATION));
		scoreBoardItem.setExpanded(true);

	}

	public static void main(String args[]) {
		
		ArrayList<Category> categories = GoGetter.getQuestions();
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(new Player("Emanuela"));
		players.add(new Player("Abel"));
		players.add(new Player("Dorcas"));
		players.add(new Player("Daniela"));
		players.add(new Player("Juniors"));
		players.add(new Player("Leslie"));
		players.add(new Player("Michaia"));

		
		
		JeopardyBoard board= new JeopardyBoard(categories, players);
		//board.loadSwtJar();
		board.run();
		
	}
	

}
