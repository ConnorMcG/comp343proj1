package comp343proj1;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Model extends Observable{
	int age = 0;
	private Population pop;
	public List<Point> myList = new ArrayList<Point>();


	/**
	 * Constructor for new GameOfLifeModel
	 */
	public Model(){
		this.pop = new Population(250,250);
	}
	

	
	/**
	 * Replaces current population with an empty new Population
	 */
	public void clearCurrPop(){
		this.pop = new Population(50,50);
	}
	
	/**
	 * Turns a cell on/off
	 * @param Point myPoint
	 */
	public void toggle(Point myPoint){
		if(pop.get(myPoint) != null){
			Cell c = pop.get(myPoint);
			c.state = 1;
			pop.put(myPoint, c);
		
			setChanged();
			notifyObservers();
	}
		else return;
	}
	
	
	/**
	 * Searches the current working population for all alive cells and
	 * adds them to myList to be painted
	 * @return List<Point>
	 */
	public List<Point> setPainted(){
		for(int i = 0; i < pop.numRows; i++){
			for(int j = 0; j < pop.numCols; j++){
				if(pop.get(new Point(i,j)).state == 0){
					myList.remove(new Point(i,j));
				}
				else if(pop.get(new Point(i,j)).state == 1){
					if(myList.contains(new Point(i,j)) == false){
						myList.add(new Point(i,j));
					}
				}
			}
		}
		return myList;
	}
	
	/**
	 * runGameOfLife is used by the ActionListener for the Start Button
	 * As long as the list of alive cells is not empty, continue the game
	 */
	public void runGameOfLife(){
		while(myList.isEmpty()==false){
			//this.startGame();
		}
		return;
	}

	
	
}//end GameOfLifeModel
