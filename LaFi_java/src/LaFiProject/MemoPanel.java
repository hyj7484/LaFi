package LaFiProject;

import java.awt.Color;
import javax.swing.*;

public class MemoPanel {
	public static JPanel MemoPanel = new JPanel();
	public static JLabel MemoLabel = new JLabel();

	Memo_Btn btn;
	
	{
		MemoPanel = new JPanel();
		MemoLabel = new JLabel();
	}
	MemoPanel(){
		setPanel(MemoPanel, MemoLabel);
		LaFi.setBackGround(MemoPanel);
		btn = new Memo_Btn();
	}
	
	void setPanel(JPanel PN, JLabel LB) {
		MainFrame.frame.add(PN);
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
