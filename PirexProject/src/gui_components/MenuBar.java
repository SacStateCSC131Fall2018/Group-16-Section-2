package gui_components;

import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
	
	JMenuBar menu = new JMenuBar();
	JFrame f = new JFrame();
	JMenu file = new JMenu("file");
	JMenu edit= new JMenu("edit");
	JMenu close = new JMenu("close");
	String files[] = {"new","open","save"};
	String edits[] = {"copy","paste"};
			
	

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
		
		//BarMenu Set Up By Minh
		f.setVisible(true);
		f.setSize(400,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		
		JMenuBar mb = new JMenuBar();
		JMenu file = new JMenu("File");
		mb.add(file);
		JMenu edit = new JMenu("Edit");
		mb.add(edit);
		JMenuItem exit = new JMenuItem("Exit");
		file.add(exit);
		
		f.setJMenuBar(mb);
		
		
		
		
		
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
