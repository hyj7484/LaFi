package LaFiProject;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Memo_Btn {
	private JButton backBtn = new JButton();
	
	Memo_Btn(){
		new EXIT(MemoPanel.MemoLabel);
		setBack(backBtn, "back.png");
	}
	
	
	public static void checkPW() {
		
	}

	void setBack(JButton btn, String img) {
		MemoPanel.MemoLabel.add(btn);
		ImageIcon Img = new ImageIcon(LaFi.imgURL+img);
		Image getImg = Img.getImage();
		Image setImg = getImg.getScaledInstance(80,80,java.awt.Image.SCALE_SMOOTH);
		Img = new ImageIcon(setImg);
		btn.setBounds(1080,650,80,80);
		btn.setBorderPainted(false);  		//외곽선
		btn.setContentAreaFilled(false); 	//내용영역 채우기
		btn.setFocusPainted(false); 		//선택시 채우기
		btn.setIcon(Img);

		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemoPanel.MemoPanel.setVisible(false);
				MainLogo.MainPanel.setVisible(true);
			}
		});
	}

}
