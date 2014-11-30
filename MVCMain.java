package comp343proj1;

import javax.swing.SwingUtilities;

public class MVCMain {
	public static void main(String[] args){	

		
		SwingUtilities.invokeLater(new Runnable(){
			Model model = new Model();
			View2 view = new View2(model);
			Control controller = new Control(model, view);
			public void run() {
				createAndShowGUI( view );
				}
			});
		}//end main

		
		private static void createAndShowGUI( View2 view) {
			view.setVisible(true);			
			view.pack();
			}
		}//end class
		    