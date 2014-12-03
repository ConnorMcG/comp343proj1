package comp343proj1;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class Drone {
	
	
	public int state; //1 or 0, either carrying rubble or free
	public Point loc; 
	public int canHold; //Amount of weight drone can hold
	
	public List<Drone> DronePop = new ArrayList<Drone>();
	
	
	/**
	 * Constructor
	 * @param state
	 * @param loc
	 */
	Drone(int state, Point loc){
		this.state = state;
		this.loc = loc;
		this.canHold = 20;
	}
	
	
	//Check if rubble weight > drone can hold before calling getHelp()
	public void getHelp(){
		/* move closest drone to loc
		 * if rubble heavier than numDrone*20
		 * 	recurse getHelp
		 * 
		 * 
		 * 
		 */
	}
	
	/**
	 * Get the location of a Drone
	 * @return Point loc
	 */
	public Point getLoc(){
		return this.loc;
	}
	
	/**
	 * Set the location of a Drone
	 * @param loc
	 */
	public void setLoc(Point loc){
		this.loc = loc;
	}
	


	


	
}
