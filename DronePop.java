package comp343proj1;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class DronePop {
	public int numRows;
	public int numCols;
	
	
	private Map<Point, Drone> pop;
	
	/**
	 * Constructor
	 * @param rows
	 * @param cols
	 */
	public DronePop(int rows, int cols){
		this.pop = new HashMap<Point, Drone>();
		this.numRows = rows;
		this.numCols = cols;
		for(int i = 0; i < this.numRows; i++){
			for(int j =0; j < this.numCols; j++){
				this.pop.put(new Point(i,j), new Drone(0, new Point(i,j)));
			}
	}
	}

	/**
	 * Set the private population to myPop
	 * @param myPop
	 */
	public void setPop(Map<Point, Drone> myPop){
		this.pop = myPop;
	}
	
	/**
	 * Return the number of rows in the population
	 * @return int numRows
	 */
	public int getNumRows(){
		return this.numRows;
	}
	
	/**
	 * Return the number of columns in the population
	 * @return int numCols
	 */
	public int getNumCols(){
		return this.numCols;
	}

	/**
	 * Get the current population
	 * @return Map<Point, Cell> pop
	 */
	public Map<Point, Drone> getPop() {
		return pop;
	}
	
	public Drone get(Point p){
		return pop.get(p);
	}
	
	public void put(Point p, Drone c){
		pop.put(p, c);
	}

	
	
}//End Population class
