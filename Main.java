package comp343proj1;



import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SpringLayout;

public class Main extends JFrame{
	
	private View view;
	
	public Main(){
		
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		this.view = new View();
		
		this.setTitle ("Automated Bot Trash Pickup");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(800,800));
		
		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		new Main();
	}

}
