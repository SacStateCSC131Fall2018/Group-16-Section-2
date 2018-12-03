import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabPanelLayout extends JTabbedPane 
							implements WindowListener
{
	public TabPanelLayout()
	{
		super();
		
		JTabbedPane tabbedPane = new JTabbedPane();
		JComponent panel1 = new JPanel();
		tabbedPane.addTab("Search for Documents", null, panel1,"Tab 1");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		JComponent panel2 = new JPanel();
		tabbedPane.addTab("Load Documents", null, panel2,"Tab 2");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

		JComponent panel3 = new JPanel();
		tabbedPane.addTab("Summarize Documents", null, panel3, "Tab 3");
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

		//JComponent panel4 =  "Panel #4 (has a preferred size of 410 x 50).");
		//panel4.setPreferredSize(new Dimension(410, 50));
		//tabbedPane.addTab("Tab 4", icon, panel4,
		//                      "Does nothing at all");
		//tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
		
		//addChangeListener(this);
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
