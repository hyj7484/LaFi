package LaFiProject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EXIT {
	JButton EXIT = new JButton();
	EXIT(JLabel pnl){
		setEXIT(pnl);
	}
	
	void setEXIT(JLabel pnl) {
		EXIT.setBounds(1180,650,80,80);
		setBtn(EXIT, "icon.png", pnl);
		
		EXIT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	void setBtn(JButton btn, String img, JLabel pnl) {
		pnl.add(btn);
		btn.setBorderPainted(false);  		//외곽선
		btn.setContentAreaFilled(false); 	//내용영역 채우기
		btn.setFocusPainted(false); 		//선택시 채우기
		btn.setIcon(new ImageIcon(LaFi.imgURL+img));
	}

}
