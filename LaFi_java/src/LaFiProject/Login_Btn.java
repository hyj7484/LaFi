package LaFiProject;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_Btn extends Thread{

	public static String Check = "";

	private static getUser User = new getUser();
	private JButton backBtn = new JButton();
	

	Login_Btn(){
		new EXIT(LoginPanel.LoginLabel);
		setBack(backBtn, "back.png");
	}
	
	
	public static void checkPW() {
		
	}

	void setBack(JButton btn, String img) {
		LoginPanel.LoginLabel.add(btn);
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
				LoginPanel.LoginPanel.setVisible(false);
				MainLogo.MainPanel.setVisible(true);
			}
		});
	}

	LoginUserBtn btn[];
	
	public void run() {
		btn = new LoginUserBtn[User.Name.length];
		LoginUserBtn.setX = 100;
		LoginUserBtn.setY = 100;
		LoginUserBtn.userCount = 0;
		for(int i = 0; i < btn.length; i++) {
			try {
				//				Thread.sleep(500);
			}catch(Exception e) {

			}
			btn[i] = new LoginUserBtn(User.Name[i], User.Num[i], User.numPW[i], LoginPanel.LoginLabel);
			btn[i].start();
		}
	}
	
}



class LoginUserBtn extends Login_Btn{
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
	String UserNumPW;

	LoginUserBtn(String argName, String argNum, String argNumPW, JLabel Label){

		userCount++;

		Label.add(btn);

		UserName = argName;
		UserNum  = argNum;
		UserNumPW = argNumPW;

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
				Login_Btn.Check = UserNumPW;
				new NumPad(UserName, UserNum);
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