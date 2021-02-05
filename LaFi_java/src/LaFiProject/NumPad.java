package LaFiProject;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class NumPad {
	static public String UserNum1;
	static public String UserName1;
	
	static JFrame frame = new JFrame();
	JLabel Label;
	static JPanel PN;
	btnNum[] btn = new btnNum[10];
	static JLabel LB = new JLabel("");
	static String Number = "";
	
	btnNum getBtn = new btnNum();

	{
//		frame.setBounds(980,75,500,650);
//		
//		frame.setSize(500,650);
//		frame.setLocationRelativeTo(null);
//		
//		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
//		frame.setUndecorated(true);
//		frame.getContentPane().setLayout(null);
//		frame.setVisible(true);
		
		Label = new JLabel();
		PN = new JPanel();
		
		LoginPanel.LoginPanel.setVisible(false);
//		MainFrame.frame.add(Label);
		
		setPanel(PN, Label);
		
		LaFi.setBackGround(PN);
		
		Label.setBounds(400,0,500,650);
		Label.setLayout(null);
		Label.setVisible(true);
	}
	
	void setPanel(JPanel PN, JLabel LB) {
		MainFrame.frame.add(PN);
		PN.setVisible(true);
		PN.setLayout(null);
		PN.setBorder(null);
		PN.setBounds(0,0,1280,800);
        PN.setBackground(Color.WHITE);
        
        PN.add(LB);
        LB.setLayout(null);   
	}
	NumPad(){
		for(int i = 0; i < 10; i++) {
			btn[i] = new btnNum(i, Label);
		}
		getBtn.setBack(Label);
		getBtn.setEnter(Label);
		setLB();
	}
//	NumPad(int a){}
	
	NumPad(String Name, String Num){
		getBtn.setting(Name, Num);
		
		
		for(int i = 0; i < 10; i++) {
			btn[i] = new btnNum(i, Label);
		}
		getBtn.setBack(Label);
		getBtn.setEnter(Label);
		setLB();
	}

	void setLB() {
		Label.add(LB);
		LB.setBounds(50,0,400,100);
		LB.setHorizontalAlignment(JLabel.CENTER);
	}

//	public static void main(String args[]) {
//		new NumPad();
//	}
}

class btnNum{
	static int setX = 80;
	static int setY = 150;
	static int count;
	
	private JButton Enter = new JButton("Enter");
	private JButton Back = new JButton("Back");
	public static boolean LoginCheck = false;
	int a = 0;
	int setNum;
	
	String UserNum;
	String UserName;
	
	
	JButton btn = new JButton();
	
	btnNum(){

	}
	void setting(String Name, String Num){
		this.UserNum = Num;
		this.UserName = Name;
	}

	btnNum(int num, JLabel frame){
		String strNum = Integer.toString(num);
		setNum = num;
		frame.add(btn);
		btn.setText(strNum);
		btn.setBounds(setX,setY,100,100);
		count++;
		setX += 120;
		if(count % 3 == 0) {
			setY += 120;
			setX  = 80;
		}
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(NumPad.Number.length() < 4) {
					NumPad.Number += num;
					NumPad.LB.setText(NumPad.Number);
				}
			}

		});
	}
	void setBack(JLabel frame) {
		frame.add(Back);
		Back.setBounds(setX,setY,100,100);
		setX += 120;

		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(NumPad.Number.length() > 0) {
					NumPad.Number =  NumPad.Number.substring(0, NumPad.Number.length()-1);
				}
				NumPad.LB.setText(NumPad.Number);
			}
		});
	}
	
	void setEnter(JLabel frame) {
		LoginCheck = false;
		
		frame.add(Enter);
		Enter.setBounds(setX,setY,100,100);

		Enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setX = 80;
				setY = 150;
				count = 0;
				
				if(NumPad.Number.length() < 4) {
					NumPad.Number = "0000";
				}
				
				int Number = Integer.parseInt(Login_Btn.Check);
				int Check = Integer.parseInt(NumPad.Number);
				
				if(Number == Check) {
					JOptionPane.showMessageDialog(null, "로그인 성공");
					LoginCheck = true;
				}else {
					JOptionPane.showMessageDialog(null, "로그인 실패");
					LoginCheck = false;
					LoginPanel.LoginPanel.setVisible(true);
				}
				if(LoginCheck) {
					LoginPanel.LoginPanel.setVisible(false);
//					new MemoPanel();
					NumPad.UserName1 = UserName;
					NumPad.UserNum1 = UserNum;
					new Memo_Main("1");
					LoginCheck = false;
				}
				NumPad.PN.setVisible(false);
				NumPad.LB.setText("");
				NumPad.Number = "";
				frame.setVisible(false);
				NumPad.frame.dispose();
				
			}
		});

	}
}
