	package LaFiProject;

import javax.swing.*;

public class MainLogo{
	public static JPanel MainPanel = new JPanel();
	public static JLabel MainLabel = new JLabel();

	MainLogo_Btn btn = new MainLogo_Btn();

	JLabel Logo1 = new JLabel();
	JLabel Logo2 = new JLabel();


	MainLogo(){
		System.out.println("Logo");
		setPanel();
		setLabel(Logo1,30,"Title.png");
		setLabel(Logo2,300,"logo_login.png");
		LaFi.setBackGround(MainPanel);
	}

	void setLabel(JLabel argLB, int argX, String img) {
		MainPanel.add(argLB);
		argLB.setIcon(new ImageIcon(LaFi.imgURL+img));
		argLB.setBounds(argX,200,500,500);

	}

	void setPanel() {
		MainFrame.frame.add(MainPanel); 
		MainPanel.setLayout(null);
		MainPanel.setBounds(0,0,1280,800);
		
		MainPanel.add(MainLabel);
		MainLabel.setLayout(null);
		MainLabel.setBounds(0,0,1280,800);
	}
}
