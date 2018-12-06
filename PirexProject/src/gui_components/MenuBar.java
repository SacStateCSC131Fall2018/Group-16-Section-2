package gui_components;

import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.Dimension;
import java.awt.MenuItem;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

/*/
 * Authors:
 * 		Ly Nguyen
 * Team: Group 16 Section 2
 */
public class MenuBar extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMenu fileMenu, optionsMenu, helpMenu;
	JMenuItem item;
	JMenuItem exportButton;
	JMenuItem exitButton;
	JFrame frame;
	JMenuBar menuBar;

	public MenuBar() {
		super();			//Intiallize Bar
		setupMenus();
	}
	
	
	public void setupMenus() {
		//Main Menu Bar Set Up By Minh Giang
		frame = new JFrame ("Menu");
		menuBar = new JMenuBar();
				
		//FileMenu set up by Ly
		fileMenu = new JMenu("File");
		item = new JMenuItem("Save Query");
		fileMenu.add(item);
		item = new JMenuItem("Load Query");
		fileMenu.add(item);
		exportButton = new JMenuItem("Import");
		fileMenu.add(exportButton);
		exportButton.addActionListener(this); //Add eventlistner to MenuItem "Import"
		item = new JMenuItem("Export");
		fileMenu.add(item);
		item = new JMenuItem("Save Query");
		fileMenu.add(item);
		exitButton = new JMenuItem("Exit");
		exitButton.addActionListener(this); // Add eventListener to MenuItem "Exit"
		fileMenu.add(exitButton);
		this.add(fileMenu);
		
		//Help Menu
		helpMenu = new JMenu("Help");
		item = new JMenuItem("About Pirex");
		helpMenu.add(item);
		this.add(helpMenu);
		
		//OptionsMenu Set Up By Michael
		optionsMenu = new JMenu("Options");
		item = new JMenuItem("Documents");
		optionsMenu.add(item);
		
		//add menus to menuBar by Minh Giang
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);
		menuBar.add(optionsMenu);
		
		//Put Menu Bar on frame by Minh Giang
		frame.setJMenuBar(menuBar);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(400,300));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
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
		Object source = E.getSource();
		if(source == exportButton) {
			JFileChooser fileChooser = new JFileChooser();
			int status = fileChooser.showOpenDialog(null);
			if(status == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				String filename = selectedFile.getPath();
				JOptionPane.showMessageDialog(null, "You selected" + filename);
			}
		}else if (source == exitButton){
			System.exit(0);
		}
	}
}
