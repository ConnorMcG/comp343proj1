package comp343proj1;

import java.awt.Color;
import java.util.Scanner;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class Canvas extends JPanel implements Observer{
	
	private static final long serialVersionUID = 1L;
	private int squareW = 40; //cell width
	private int squareH = 40; //cell height
	public Population cellPop;
	public DronePop dronePop;
	Model myModel;
		
	/**
	 * Initialize array to keep track of alive points
	 */
	//private List<Point> paintedSquares = new ArrayList<Point>();
	private List<Cell> paintedSquares = new ArrayList<Cell>();
	private List<Drone> paintDrones = new ArrayList<Drone>();



	public Canvas(Model m){
		myModel = m;
		
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Point myPoint = e.getPoint();
				int myY = myPoint.y / 40;
				int myX = myPoint.x / 40;
				
				Scanner user_input = new Scanner( System.in );
				String input;
				System.out.print("Enter the weight of the rubble: ");
				input = user_input.next( );
				if(input.equals("trash")){
					myModel.toggle(new Point(myY, myX), 0, 1);
				}
				else if(input.equals("drone")){
					myModel.toggleDrone(new Point(myY, myX));
				}
				
				else{
				myModel.toggle(new Point(myY, myX), Integer.parseInt(input),0);
				}
			}
		}); 
		
	}
	

	public Dimension getPreferredSize() {
		return new Dimension(500,500);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);   
	
		//Paint grey background
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		//Paint alive cells
		g.setColor(Color.RED);
		for(int i = 0; i < paintedSquares.size(); i++){		
			g.setColor(Color.RED);
			Cell c = paintedSquares.get(i);
			Point p = c.loc;
			if(c.trash == 1){
				g.setColor(Color.BLACK);
				g.fillRect(p.y * 40, p.x*40, squareW, squareH);
			}else{
				g.fillRect(p.y * 40, p.x*40, squareW, squareH);
				g.setColor(Color.BLACK);
				g.drawString(Integer.toString(c.weight),p.y*40,p.x*40 + 20);
			}
		}
		//Color drones
		g.setColor(Color.GREEN);
		for(int i = 0; i < paintDrones.size(); i++){		
			g.setColor(Color.GREEN);
			Drone d = paintDrones.get(i);
			Point p = d.loc;
			g.fillRect(p.y * 40, p.x*40, squareW, squareH);
			g.setColor(Color.BLACK);
			g.drawString("Drone",p.y*40,p.x*40 + 20);
			
		}
		
		
		//Paint grid lines
		g.setColor(Color.BLACK);
		for(int i = 0; i < this.getWidth(); i+=40){
			g.drawLine(i, 0, i, this.getHeight());
		}
		for(int j = 0; j < this.getHeight() + 10; j+=40){
			g.drawLine(0, j, this.getWidth(), j);
		}
	}


	@Override
	public void update(Observable o, Object arg) {
		paintedSquares = myModel.setPainted2();
		paintDrones = myModel.paintedDrones();
		this.repaint();
		}	 


}//end class


