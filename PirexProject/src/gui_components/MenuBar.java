package gui_components;

import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/*/
 * Authors:
 * 		Ly Nguyen
 * Team: Group 16 Section 2
 */
public class MenuBar extends JMenuBar implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		item.addActionListener(this); //Add eventlistner to MenuItem "Import"
		item = new JMenuItem("Export");
		fileMenu.add(item);
		item = new JMenuItem("Save Query");
		fileMenu.add(item);
		item = new JMenuItem("Exit");
		fileMenu.add(item);
		this.add(fileMenu);
		
		//Help Menu
		
		//OptionsMenu Set Up By Michael
		optionsMenu = new JMenu("Options");
		item = new JMenuItem("Documents");
		optionsMenu.add(item);
		
		
		
		
	}

	/*
	 * SETUP BY RONG OU
	 */
	@Override
	public void actionPerformed(ActionEvent E) {
		// TODO Auto-generated method stub
		/*
		 * Clicking Export button triggers filechooser dialogbox and saves filepath for future use.
		 */
		JFileChooser fileChooser = new JFileChooser();
		int status = fileChooser.showOpenDialog(null);
		if(status == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			String filename = selectedFile.getPath();
			JOptionPane.showMessageDialog(null, "You selected" + filename);
		}
		
	}
	
}
