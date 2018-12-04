package gui_components;

import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/*/
 * Authors:
 * 		Ly Nguyen
 * Team: Group 16 Section 2
 */
public class MenuBar extends JMenuBar {
	JMenu fileMenu, optionsMenu, helpMenu;
	JMenuItem item;

	public MenuBar() {
		super();			//Intiallize Bar
		setupMenus();
	}
	
	
	public void setupMenus() {
		//FileMenu set up by Ly
		fileMenu = new JMenu("File");
		item = new JMenuItem("Save Query");
		fileMenu.add(item);
		item = new JMenuItem("Load Query");
		fileMenu.add(item);
		item = new JMenuItem("Import");
		fileMenu.add(item);
		item = new JMenuItem("Export");
		fileMenu.add(item);
		item = new JMenuItem("Save Query");
		fileMenu.add(item);
		item = new JMenuItem("Exit");
		fileMenu.add(item);
		this.add(fileMenu);
		
		//Help Menu
		
		//Options Menu
	}
	
}
