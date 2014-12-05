package comp343proj1;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

public class Model extends Observable{
	int age = 0;
	private Population pop;
	public List<Cell> myCellList = new ArrayList<Cell>();
	public List<Drone> droneList = new ArrayList<Drone>();
	
	public List<Integer> closestDrone = new ArrayList<Integer>();




	/**
	 * Constructor for new GameOfLifeModel
	 */
	public Model(){
		this.pop = new Population(250,250);
	}
	

	
	
	/**
	 * Turns a cell on/off
	 * @param Point myPoint
	 */
	public void toggle(Point myPoint, int w, int trash){
		if(pop.get(myPoint) != null){
			Cell c = pop.get(myPoint);
			if(c.state == 0){
				c.state = 1;
			}
			else{
				c.state = 0;
			}
			c.weight = w;
			c.trash = trash;
			pop.put(myPoint, c);
		
			setChanged();
			notifyObservers();
	}
		else return;
	}
	
	
	
	public void toggleDrone(Point p){
		Drone d = new Drone(1,p);
		this.droneList.add(d);
		setChanged();
		notifyObservers();
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
	
	
	
	public static int minIndex (List<Integer> list) {
		  return list.indexOf (Collections.min(list)); }
	
	public void startSim(){
		
		
		/*
		 * for each cell in pop
		 * 		if not trashcan then:
		 * 			send drone to that cell
		 * 			drone sees if it needs help or not
		 * 		if drone doesnt need help:
		 * 			move drone and rubble to trash
		 * 			if current cell doesnt equal trash:
		 * 				keep moving towards trash
		 * 			else:
		 * 				remove rubble from pop, move drone back
		 */
		for(int i = 0; i < pop.numRows; i++){
			for(int j = 0; j < pop.numCols; j++){
				Cell c = pop.get(new Point(i,j));
				if(c.state == 1){
					
					for(int a = 0; a < droneList.size(); a++){
						Point currentDrone = droneList.get(a).getLoc();
						int x = Math.abs(currentDrone.x - c.loc.x);
						int y = Math.abs(currentDrone.y - c.loc.y);
						closestDrone.add(x+y);
						}
					Drone closest = droneList.get(minIndex(closestDrone));
					Point b = closest.getLoc();
					if(droneList.contains(new Drone(1, b))){
						droneList.remove(new Drone(1,b));
						}
					droneList.add(new Drone(1, new Point(b.x -1, b.y)));
				
				}
					
					
					closestDrone.clear();
			}
		}
			
		setChanged();
		notifyObservers();
}
	
	/**
	 * runGameOfLife is used by the ActionListener for the Start Button
	 * As long as the list of alive cells is not empty, continue the game
	 */
	public void runGameOfLife(){
		while(myCellList.isEmpty()==false){
			this.startSim();
		}
		return;
	}

	
	
}//end GameOfLifeModel
