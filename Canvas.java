package comp343proj1;

import java.awt.Color;
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
	public Population myPop;
	Model myModel;
		
	/**
	 * Initialize array to keep track of alive points
	 */
	private List<Point> paintedSquares = new ArrayList<Point>();


	public Canvas(Model m){
		myModel = m;
		
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Point myPoint = e.getPoint();
				int myY = myPoint.y / 40;
				int myX = myPoint.x / 40;
				myModel.toggle(new Point(myY, myX));
			}
		}); 
		
		addMouseMotionListener(new MouseAdapter(){
			public void mouseDragged(MouseEvent e){
				Point myPoint = e.getPoint();
				int myY = myPoint.y / 40;
				int myX = myPoint.x / 40;
				myModel.toggle(new Point(myY, myX));
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
			Point p = paintedSquares.get(i);
			g.fillRect(p.y * 40, p.x*40, squareW, squareH);
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
		paintedSquares = myModel.setPainted();
		this.repaint();
		}	 


}//end class


