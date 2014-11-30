package comp343proj1;

import java.awt.Point;

public class Cell {
	
	
	public int state;
	public Point loc;
	
	/**
	 * Constructor
	 * @param state
	 * @param loc
	 */
	Cell(int state, Point loc){
		this.state = state;
		this.loc = loc;
		
	}

	
	/**
	 * Get the location of a Cell
	 * @return Point loc
	 */
	public Point getLoc(){
		return this.loc;
	}
	
	/**
	 * Set the location of a Cell
	 * @param loc
	 */
	public void setLoc(Point loc){
		this.loc = loc;
	}
	


	@Override
	public String toString() {
		return "Cell [state=" + state + ", loc=" + loc + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Cell other = (Cell) obj;
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
