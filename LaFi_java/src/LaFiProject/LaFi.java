package LaFiProject;
import java.awt.Image;
import javax.swing.*;
public class LaFi {
	public static String imgURL = "/Users/hwang/eclipse-workspace/LaFi/Img/";
	public static String LinkURL = "http://localhost:8080/lafi/JAVAPHP/";
	
	static void setBackGround(JPanel pn) {
		
		String imgName = "BackGround2.jpg";
		ImageIcon Img = new ImageIcon(LaFi.imgURL+imgName);
		Image getImg = Img.getImage();
		Image setImg = getImg.getScaledInstance(1280,800,java.awt.Image.SCALE_SMOOTH);
		Img = new ImageIcon(setImg);
		JLabel Main_BackGround = new JLabel(Img);
		pn.add(Main_BackGround);
		Main_BackGround.setOpaque(false);
		Main_BackGround.setBounds(0, 0, 1280, 800);
	}
}
