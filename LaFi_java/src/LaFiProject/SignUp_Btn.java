package LaFiProject;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


class UserBtn extends SignUp_Btn{
	private JButton btn = new JButton();

	static int setY = 100;
	static int setX = 100;
	static int userCount = 0;

	private int objY;
	private int objX;

	private int countY;
	private int countX;

	String UserName;
	String UserNum;

	UserBtn(String argName, String argNum, JLabel Label){

		userCount++;

		Label.add(btn);

		UserName = argName;
		UserNum  = argNum;

		btn.setText(argName);

		objY = setY;
		setY += 63;

		objX = setX;

		if(userCount % 10 == 0) {
			setY = 100;
			setX += 200;
			userCount = 0;

		}

		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(UserName);
				System.out.println(UserNum);
			}
		});
	}
	public void run() {
		try{
			Thread.sleep(500);
		}catch(Exception e) {

		}
		while(countY <= 50) {
			btn.setBounds(objX , objY, countX, countY);
			countY+= 2;
			countX+= 6;
			objX-=3;
			objY-=1;
			try {
				Thread.sleep(15);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}		
		}
	}


}

public class SignUp_Btn extends Thread{
	private static getUser User = new getUser();
	private static JButton backBtn = new JButton();
	{
		new EXIT(SignUpPanel.SignUpLabel);
		setBack(backBtn, "back.png");
	}
	void setBack(JButton btn, String img) {
		SignUpPanel.SignUpLabel.add(btn);
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
				SignUpPanel.SignUpPanel.setVisible(false);
				MainLogo.MainPanel.setVisible(true);
				
				UserBtn.setY = 100;
				UserBtn.setX = 100;
				UserBtn.userCount = 0;
			}
		});
	}

//
//	void setBtn(JButton btn, JPanel Panel) {
//		Panel.add(btn);
//		//		btn.setBounds();
//	}

	UserBtn btn[];
	public void run() {
		btn = new UserBtn[User.Name.length];
		for(int i = 0; i < btn.length; i++) {
			try {
				//				Thread.sleep(500);
			}catch(Exception e) {

			}
			btn[i] = new UserBtn(User.Name[i], User.Num[i], SignUpPanel.SignUpLabel);
			btn[i].start();
		}
	}
}
