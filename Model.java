package comp343proj1;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

public class Model extends Observable{
	int age = 0;
	public List<Cell> myCellList = new ArrayList<Cell>();
	public List<Cell> currentCell = new ArrayList<Cell>();

	public List<Drone> droneList = new ArrayList<Drone>();
	public List<Integer> closestDrone = new ArrayList<Integer>();
	Point TRASHCAN = new Point(0,0);
	Drone droneWRubble = new Drone (0, null);


	/**
	 * Constructor for new GameOfLifeModel
	 */
	public Model(){
	}
	
	
	public void toggle(Point p, int w){
		Cell c = new Cell(1, p, w);
		this.myCellList.add(c);
		setChanged();
		notifyObservers();
	}
	
	
	
	public void toggleDrone(Point p){
		Drone d = new Drone(1,p);
		this.droneList.add(d);
		setChanged();
		notifyObservers();
	}
	
	

	
	public static int minIndex (List<Integer> list) {
		  return list.indexOf (Collections.min(list)); 
		  }
	
	public void startSim(){
		
		if(!myCellList.isEmpty()){
			Cell c = this.myCellList.get(0);
			
			Point rubbleLoc = c.loc;
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
				
					
					//Trash collection algorithm
					if(rubbleLoc.x == b.x && rubbleLoc.y == b.y){
						droneList.add(new Drone(1,b));
						
						//Start moving towards trash can
						if(TRASHCAN.x == b.x && TRASHCAN.y == b.y){
							System.out.println("Trash thrown away");
							myCellList.remove(c);
						}
						else{
							if(TRASHCAN.x != b.x){
								if(TRASHCAN.x > b.x){
									droneList.remove(new Drone(1, new Point(b.x, b.y)));
									droneList.add(new Drone(1, new Point(b.x +1, b.y)));
									c.loc = new Point(b.x +1, b.y);
								}
								else if(TRASHCAN.x < b.x){
									droneList.remove(new Drone(1, new Point(b.x, b.y)));
									droneList.add(new Drone(1, new Point(b.x -1, b.y)));
									c.loc = new Point(b.x -1, b.y);
								}
						}
						else if (TRASHCAN.y != b.y){
							if(TRASHCAN.y > b.y){
								droneList.remove(new Drone(1, new Point(b.x, b.y)));
								droneList.add(new Drone(1, new Point(b.x, b.y+1)));
								c.loc = new Point(b.x, b.y+1);
							}
							else if(TRASHCAN.y < b.y){
								droneList.remove(new Drone(1, new Point(b.x, b.y)));
								droneList.add(new Drone(1, new Point(b.x, b.y-1)));
								c.loc = new Point(b.x, b.y-1);
								}
							}
						}
					}//Start moving towards rubble
					else{
						if(rubbleLoc.x != b.x || rubbleLoc.y != b.y){
							if(rubbleLoc.x > b.x){
								droneList.remove(new Drone(1, new Point(b.x, b.y)));
								droneList.add(new Drone(1, new Point(b.x +1, b.y)));
							}
							else if(rubbleLoc.x < b.x){
								droneList.remove(new Drone(1, new Point(b.x, b.y)));
								droneList.add(new Drone(1, new Point(b.x -1, b.y)));
							}
							else if(rubbleLoc.y > b.y){	
								droneList.remove(new Drone(1, new Point(b.x, b.y)));
								droneList.add(new Drone(1, new Point(b.x, b.y+1)));
							}
							else if(rubbleLoc.y < b.y){
								droneList.remove(new Drone(1, new Point(b.x, b.y)));
								droneList.add(new Drone(1, new Point(b.x, b.y-1)));
						}
					}
				}
			
					
					
					closestDrone.clear();
			}
				setChanged();
				notifyObservers();
		}
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
