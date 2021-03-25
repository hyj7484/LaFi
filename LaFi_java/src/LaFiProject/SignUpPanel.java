package LaFiProject;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;
public class SignUpPanel {
	public static JLabel SignUpLabel = new JLabel();
	public static JPanel SignUpPanel = new JPanel();
	SignUp_Btn btn = new SignUp_Btn();
	{
		SignUpPanel = new JPanel();
		SignUpLabel = new JLabel();
	}
	SignUpPanel(){
		setPanel();
		btn.start();
		LaFi.setBackGround(SignUpPanel);
	}
	
	void setPanel() {
		MainFrame.frame.add(SignUpPanel);
		SignUpPanel.setLayout(null);
		SignUpPanel.setBounds(0,0,1280,800);
		SignUpPanel.setVisible(true);
		
		
		SignUpPanel.add(SignUpLabel);
		SignUpLabel.setLayout(null);
		SignUpLabel.setBounds(0,0,1280,800);
	}

}
