package comp343proj1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.Timer;

public class Control {
	int delay = 100;
	public Timer timer = new Timer(delay, new startListener());

	private Model myModel;
	private View2 myView;
	
	//Constructor
	public Control(Model model, View2 view){
		myModel = model;
		myView = view;
		
		view.addNextListener(new nextListener());
		view.addStartListener(new startListener());
		view.addStopListener(new stopListener());
	}
	
	class nextListener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			myView.setAge(myModel.age + " ");

		}
	}
	
	class startListener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			timer.start();
			if(myModel.myCellList.isEmpty() == true){
				timer.stop();
			}
			else{
				myModel.startSim();
				myView.setAge(myModel.age + " ");
			}
		}
	}
	
	class stopListener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			timer.stop();
		}
	}
	

	
	
}
