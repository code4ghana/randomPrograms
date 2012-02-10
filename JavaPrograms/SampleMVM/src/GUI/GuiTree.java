



import Models.Animal;
import Models.DayCare;

public class GuiTree extends ApplicationWindow {
	DayCare care;

	public  void setDayCare(DayCare d) {
		care = d;

		// TODO Auto-generated constructor stub
	}

	public GuiTree() {
		super(null);
	}
	
	public void run() {
	    // Don't return from open() until window closes
	    setBlockOnOpen(true);

	    // Open the main window
	    open();

	    // Dispose the display
	    Display.getCurrent().dispose();
	  }

	  /**
	   * Configures the shell
	   * 
	   * @param shell
	   *            the shell
	   */
	  protected void configureShell(Shell shell) {
	    super.configureShell(shell);

	    // Set the title bar text and the size
	    shell.setText("File Tree");
	    shell.setSize(400, 400);
	  }

	protected Control createContents(Composite parent) {
		Animal ani1=new Animal("Scooby","Dog",2,5);
		Animal ani2=new Animal("scraby","Dog",1,10);
		Animal ani3=new Animal("Lucky","Cat",2,4);
		care=new DayCare("BlueMoon Daycare");
		care.addAnmial(ani1);
		care.addAnmial(ani2);
		care.addAnmial(ani2);
		care.addAnmial(ani3);
		
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		final TreeViewer tv = new TreeViewer(composite);
		tv.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));
		tv.setContentProvider(new dayCareTreeProvider());
		tv.setInput("root");
		return composite;
	}


	class dayCareTreeProvider implements ITreeContentProvider {

		@Override
		public void dispose() {
			// TODO Auto-generated method stub

		}

		@Override
		public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public Object[] getChildren(Object arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object[] getElements(Object arg0) {
			// TODO Auto-generated method stub
			return care.getAnimals().toArray();
		}

		@Override
		public Object getParent(Object arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean hasChildren(Object arg0) {
			// TODO Auto-generated method stub
			return false;
		}

	}


	public static void main(String[] args) {
		new GuiTree().run();
	}
}