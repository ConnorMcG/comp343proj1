package comp343proj1;

import java.util.Observable;

public class BotModel extends Observable{
	public Point loc;
	public int state; //Shows whether holding debree or free to pick up
	
	BotModel(Point loc, int state){
		loc = this.loc;
		state = this.state;
	}
	

}
