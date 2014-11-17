package comp343proj1;

import java.util.Observable;
import java.util.Observer;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class View extends JPanel implements Observer{
	
	public View(){
		
		this.setPreferredSize (new Dimension (800,800));
		this.setMinimumSize (new Dimension (800, 800));
		
		this.setBackground (Color.WHITE);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	
	

}
