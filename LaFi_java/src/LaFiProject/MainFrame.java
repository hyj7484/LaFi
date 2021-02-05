package LaFiProject;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainFrame {
	public static JFrame frame = new JFrame();
	
	JButton btn = new JButton("H");

	MainFrame(){
		setFrame();
		frame.add(btn);
//		btn.setBounds(100,100,100,100);
		new MainLogo();
	
	}
	
	private void setFrame() {
		frame.setSize(1280, 800);
		frame.setUndecorated(true);			//�뀒�몢由� �뾾�븷湲�
		frame.setLocationRelativeTo(null); 	// 以묒븰�젙�젹
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
