package LaFiProject;

import java.awt.Color;
import javax.swing.*;

public class LoginPanel {
	public static JPanel LoginPanel = new JPanel();
	public static JLabel LoginLabel = new JLabel();
	
	Login_Btn btn = new Login_Btn();
	{
		LoginPanel = new JPanel();
		LoginLabel = new JLabel();
	}
	LoginPanel(){
		setPanel(LoginPanel, LoginLabel);
		
		btn.start();
		LaFi.setBackGround(LoginPanel);
	}
	
	void setPanel(JPanel PN, JLabel LB) {
		MainFrame.frame.add(LoginPanel);
		PN.setVisible(true);
		PN.setLayout(null);
		PN.setBorder(null);
		PN.setBounds(0,0,1280,800);
        PN.setBackground(Color.WHITE);
        
        PN.add(LB);
        LB.setBounds(0,0,1280,800);
        LB.setLayout(null);   
	}
}
