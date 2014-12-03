package comp343proj1;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Model extends Observable{
	int age = 0;
	private Population pop;
	private DronePop dronePop;
	public List<Point> myList = new ArrayList<Point>();
	public List<Cell> myCellList = new ArrayList<Cell>();
	public List<Drone> droneList = new ArrayList<Drone>();




	/**
	 * Constructor for new GameOfLifeModel
	 */
	public Model(){
		this.pop = new Population(250,250);
		this.dronePop = new DronePop(250,250);
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
	public void toggle(Point myPoint, int w, int trash){
		if(pop.get(myPoint) != null){
			Cell c = pop.get(myPoint);
			c.state = 1;
			c.weight = w;
			c.trash = trash;
			pop.put(myPoint, c);
		
			setChanged();
			notifyObservers();
	}
		else return;
	}
	
	
	public void toggleDrone(Point myPoint){
		if(dronePop.get(myPoint) != null){
			Drone d = dronePop.get(myPoint);
			d.state = 1;
			dronePop.put(myPoint, d);
		
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
	
	public List<Cell> setPainted2(){
		for(int i = 0; i < pop.numRows; i++){
			for(int j = 0; j < pop.numCols; j++){
				if(pop.get(new Point(i,j)).state == 0){
					myCellList.remove(new Point(i,j));
				}
				else if(pop.get(new Point(i,j)).state == 1){
					if(myCellList.contains(new Point(i,j)) == false){
						int isTrash = pop.get(new Point(i,j)).trash;
						myCellList.add(new Cell(1, 
											new Point(i,j),
											pop.get(new Point(i,j)).weight, isTrash)
											);
					}
				}
			}
		}
		return myCellList;
		
	}
	
	
	public List<Drone> paintedDrones(){
		for(int i = 0; i < dronePop.numRows; i++){
			for(int j = 0; j < dronePop.numCols; j++){
				if(dronePop.get(new Point(i,j)).state == 0){
					droneList.remove(new Point(i,j));
				}
				else if(dronePop.get(new Point(i,j)).state == 1){
					if(droneList.contains(new Point(i,j)) == false){
						droneList.add(new Drone(1, new Point(i,j)) );
					}
				}
			}
		}
		return droneList;
		
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
