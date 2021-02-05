package LaFiProject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainLogo_Btn{
	
	SignUpPanel Sign;
	
	JButton Login1 = new JButton();
	JButton Login2 = new JButton();
	
	JButton SignUp1 = new JButton();
	JButton SignUp2 = new JButton();
	
	

	MainLogo_Btn(){
		setLogin(Login1, 650, "Btn_LOGIN.PNG");
		setLogin(Login2, 580, "LoginBtn.jpg");
		setSignUp(SignUp1, 650, "Btn_SIGNUP.png");
		setSignUp(SignUp2, 580, "SignUp_Btn.png");
		new EXIT(MainLogo.MainLabel);
		
	}
	
	
	void setSignUp(JButton btn, int argY, String Img) {
		btn.setBounds(150,argY,100,100);
		setBtn(btn, Img);
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				MainLogo.MainPanel.setVisible(false);
//				new SignUpPanel();
			}
		});
	}
	
	void setLogin(JButton btn, int argY, String Img) {
		btn.setBounds(30,argY,100,100);
		setBtn(btn,  Img);
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainLogo.MainPanel.setVisible(false);
				new LoginPanel();
			}
		});
	}
	
	void setBtn(JButton btn, String img) {
		MainLogo.MainLabel.add(btn);
		
		btn.setBorderPainted(false);  		//�쇅怨쎌꽑
		btn.setContentAreaFilled(false); 	//�궡�슜�쁺�뿭 梨꾩슦湲�
		btn.setFocusPainted(false); 		//�꽑�깮�떆 梨꾩슦湲�
		btn.setIcon(new ImageIcon(LaFi.imgURL+img));
	}	
}
