import java.awt.Menu;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sun.xml.internal.ws.org.objectweb.asm.Label;
import gui_components.*;
public class HomeLayout extends JFrame 
			 implements WindowListener	
{

	public HomeLayout()
	{
		super();
        ImageIcon   icon;
        String      lookAndFeel;
        
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        icon = new ImageIcon("C:/Users/Jingwei/OneDrive/@FAll 2018/CSC 131/Week07/sacstate.gif");
        setIconImage(icon.getImage());
        setSize(500,300);
        setTitle("Sac State");
        TabPanelLayout tbPnl;
        //tbPnl = new TabPanelLayout();
        //tbPnl.add(this);
        JTabbedPane tabbedPane = new JTabbedPane();
		JComponent panel1 = new JPanel();
		JLabel label = new JLabel("Query :");
		JTextArea txtBox = new JTextArea(2,40);
		//txtBox.setSize(500, 30);
		JButton btn = new JButton();
		btn.setText("Clear");
		panel1.add(label);
		panel1.add(txtBox);
		panel1.add(btn);
		
		tabbedPane.addTab("Search for Documents", null, panel1,"Tab 1");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
			
		JComponent panel2 = new JPanel();
		tabbedPane.addTab("Load Documents", null, panel2,"Tab 2");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

		JComponent panel3 = new JPanel();
		tabbedPane.addTab("Summarize Documents", null, panel3, "Tab 3");
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);	
		add(tabbedPane);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        addWindowListener(this);
        
        //Adding Menu Bar -LY
        MenuBar mainBar = new MenuBar();
        setJMenuBar(mainBar);
	}
	
	public void windowClosing(WindowEvent e)
    {
       int        response;
       
       response = JOptionPane.showConfirmDialog(this,
                                                "Exit this application?",
                                                "Exit?", 
                                                JOptionPane.YES_NO_OPTION);

       if (response == JOptionPane.YES_OPTION)
       {
          dispose();          
          System.exit(0);
       }
    }
	
	
	 /**
     * Handle other windowing events (required by WindowListener)
     */
    public void windowOpened(WindowEvent e){};
    public void windowClosed(WindowEvent e){};
    public void windowIconified(WindowEvent e){};
    public void windowDeiconified(WindowEvent e){};
    public void windowActivated(WindowEvent e){};
    public void windowDeactivated(WindowEvent e){};
	
}
