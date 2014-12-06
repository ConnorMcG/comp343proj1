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


	@Override
	public String toString() {
		return "Drone [state=" + state + ", loc=" + loc + ", canHold="
				+ canHold + ", DronePop=" + DronePop + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((DronePop == null) ? 0 : DronePop.hashCode());
		result = prime * result + canHold;
		result = prime * result + ((loc == null) ? 0 : loc.hashCode());
		result = prime * result + state;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Drone other = (Drone) obj;
		if (DronePop == null) {
			if (other.DronePop != null)
				return false;
		} else if (!DronePop.equals(other.DronePop))
			return false;
		if (canHold != other.canHold)
			return false;
		if (loc == null) {
			if (other.loc != null)
				return false;
		} else if (!loc.equals(other.loc))
			return false;
		if (state != other.state)
			return false;
		return true;
	}
	


	


	
}
