package LaFiProject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import LaFiProject.getMemo;


class BorderColor {

    static Border border_BLACK = BorderFactory.createLineBorder(Color.BLACK);

    static Border border_RED = BorderFactory.createLineBorder(Color.RED);

    static Border border_BLUE = BorderFactory.createLineBorder(Color.BLUE);

}

class Weather {
    private final String USER_AGENT = "Mozilla/5.0";
    static String[] allRainTem = new String[10]; // All Information
    public static void main(String[] args) {
        Weather http = new Weather();
        http.sendGet();
    }
    // return Array
    String[] getAllRainTem() {
        sendGet();
        return allRainTem;
    }
    private void sendGet() {
        try { // Date
            Calendar cal = Calendar.getInstance();
            String setMonth = ""; // month
            String setDate = "";
            // date
            // "0" + month
            if (cal.get(Calendar.MONTH) + 1 < 10) 
                setMonth = "0" + (
                    cal.get(Calendar.MONTH) + 1
                );
             else 
                setMonth = "" + (
                    cal.get(Calendar.MONTH) + 1
                );
            // "0" + date
            if (cal.get(Calendar.DATE) + 1 < 10) 
                setDate = "0" + cal.get(Calendar.DATE);
             else 
                setDate = "" + cal.get(Calendar.DATE);
            // Today
            String today = cal.get(Calendar.YEAR) + setMonth + setDate;
            // set URL
            String serviceKey = "3NnzDEKDN2z5gLj28VUHJfxytpWNHCUVuPRrb%2F4TcwEZONHUSF9d1ZxeeXPVjcyIlGuwY7wLHHgnGaiVEH7AZw%3D%3D";
            String baseDate = today; // Today
            String baseTime = "0200"; // Time
            String nx = "89"; // X
            String ny = "91"; // Y
            String _type = "json"; // File Type
            String numOfRows = "82";
            // Information
            // URL
            String urlStr = "http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst?" + "serviceKey=" + serviceKey + "&base_date=" + baseDate + "&base_time=" + baseTime + "&nx=" + nx + "&ny=" + ny + "&_type=" + _type + "&numOfRows=" + numOfRows;

            URL url = new URL(urlStr); // URL

            HttpURLConnection con = (HttpURLConnection)url.openConnection();

            con.setRequestMethod("GET");

            con.setRequestProperty("User-Agent", USER_AGENT);

            con.getResponseCode();

            // Read File

            BufferedReader bf = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String inputLine;

            StringBuffer response = new StringBuffer();

            while ((inputLine = bf.readLine()) != null) {

                response.append(inputLine);

            }

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            FileOutputStream output = new FileOutputStream("./TodayWeather");

            output.write(response.toString().getBytes());

            output.close();

            Document doc = dBuilder.parse("./TodayWeather");

            doc.getDocumentElement().normalize();

            // Read

            Element body = (Element)doc.getElementsByTagName("body").item(0);

            Element items = (Element)body.getElementsByTagName("items").item(0);

            // Lowest Temperature

            Element getLowest = (Element)items.getElementsByTagName("item").item(7);

            Element lowest = (Element)getLowest.getElementsByTagName("fcstValue").item(0);

            // Highest Temperature

            Element getHighest = (Element)items.getElementsByTagName("item").item(37);

            Element highest = (Element)getHighest.getElementsByTagName("fcstValue").item(0);

            // 06 AM Rain

            Element getRain06 = (Element)items.getElementsByTagName("item").item(0);

            Element rain06 = (Element)getRain06.getElementsByTagName("fcstValue").item(0);

            // 06 AM Temperature

            Element getTem06 = (Element)items.getElementsByTagName("item").item(6);

            Element tem06 = (Element)getTem06.getElementsByTagName("fcstValue").item(0);

            // 12 PM Rain

            Element getRain12 = (Element)items.getElementsByTagName("item").item(21);

            Element rain12 = (Element)getRain12.getElementsByTagName("fcstValue").item(0);

            // 12 PM Temperature

            Element getTem12 = (Element)items.getElementsByTagName("item").item(27);

            Element tem12 = (Element)getTem12.getElementsByTagName("fcstValue").item(0);

            // 06 PM Rain

            Element getRain18 = (Element)items.getElementsByTagName("item").item(42);

            Element rain18 = (Element)getRain18.getElementsByTagName("fcstValue").item(0);

            // 06 PM Temperature

            Element getTem18 = (Element)items.getElementsByTagName("item").item(48);

            Element tem18 = (Element)getTem18.getElementsByTagName("fcstValue").item(0);

            // 00 AM Rain

            Element getRain24 = (Element)items.getElementsByTagName("item").item(62);

            Element rain24 = (Element)getRain24.getElementsByTagName("fcstValue").item(0);

            // 00 AM Temperature

            Element getTem24 = (Element)items.getElementsByTagName("item").item(68);

            Element tem24 = (Element)getTem24.getElementsByTagName("fcstValue").item(0);

            // Get Weather Array

            allRainTem[0] = rain06

                .getChildNodes()

                .item(0)

                .getNodeValue();

            allRainTem[1] = tem06

                .getChildNodes()

                .item(0)

                .getNodeValue();

            allRainTem[2] = rain12

                .getChildNodes()

                .item(0)

                .getNodeValue();

            allRainTem[3] = tem12

                .getChildNodes()

                .item(0)

                .getNodeValue();

            allRainTem[4] = rain18

                .getChildNodes()

                .item(0)

                .getNodeValue();

            allRainTem[5] = tem18

                .getChildNodes()

                .item(0)

                .getNodeValue();

            allRainTem[6] = rain24

                .getChildNodes()

                .item(0)
                

                .getNodeValue();

            allRainTem[7] = tem24

                .getChildNodes()

                .item(0)

                .getNodeValue();

            allRainTem[8] = lowest

                .getChildNodes()

                .item(0)

                .getNodeValue();

            allRainTem[9] = highest

                .getChildNodes()

                .item(0)

                .getNodeValue();

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

}


public class Memo_Main implements Runnable {
	
	static String Name;
	static String Num;
	
	String Font11 = "Gulim";

    private JFrame frame; // All Frame

    static JLabel mainLabel_pic = new JLabel();

    static JLabel mainLabel_date = new JLabel(); // MainLabel Date

    static JLabel mainLabel_clock = new JLabel(); // MainLabel Clock

    static JLabel mainLabel_sentence = new JLabel(); // MainLabel Sentence

    static String text = ""; // Good Sentence Make

    static int count = 0; // Good Sentence Count

    final static int SENTENCE = 3; // Good Sentence List

    static int pickSentence = (int)(Math.random() * SENTENCE); // Good Sentence Pick

    static String comboBoxAll = ""; // ComboBox Result

    static int stop = 0; // MainLabel Memo First

    static String[] allRainTem = new Weather().getAllRainTem(); // Get Weather
   
    JTextArea mainTextArea_tomorrow;
    JTextArea mainTextArea_tooday;
    JTextArea mainTextArea_yesterday;
    String tomorrow_ymd;
    String today_ymd;
    String yesterday_ymd;
    boolean check = false;
    int dayCheck = 0;
    public void update_memo() {
    	if(check) {
    		
    		String getMemoTomorrow = getMemo.getMemo(userNumber, tomorrow_ymd);
    		mainTextArea_tomorrow.setText(" \n"+getMemoTomorrow);
    	
    		String getMemoToday = getMemo.getMemo(userNumber, today_ymd);//getUserMemo.returnMemo("1", today_ymd);
    		mainTextArea_tooday.setText(" \n"+getMemoToday);
    	
    		String getMemoYesterday = getMemo.getMemo(userNumber, yesterday_ymd);//getUserMemo.returnMemo("1", yesterday_ymd);
    		mainTextArea_yesterday.setText(" \n"+getMemoYesterday);
    	}
    }
    /**

 

	 * Launch the application.

 

	 */
    
    static {
    	
    	Num = NumPad.UserNum1;
    	Name = NumPad.UserName1;
    	
      	Memo_Main th1 = new Memo_Main();

        Thread t1 = new Thread(th1);

        t1.start();

        EventQueue.invokeLater(new Runnable() {

            public void run() {

                try {
                    th1.frame.setVisible(true);

                } catch (Exception e) {
 
                    e.printStackTrace();

                }

            }

        });
    	
    }

    public static void main (String[] args) {

    }

    /**

 

	 * Create the application.

 

	 */

    public Memo_Main() {
	
        initialize(Num);

    }
    
    public Memo_Main(String Name) {

//    	this.Name = Name;
//    	this.Num = Num;
//    	System.out.println(this.Num);
//    	System.out.println("테스트용");
//    	initialize(this.Num);
    }

    /**

 

	 * Initialize the contents of the frame.

 

	 */
    String userNumber;
    private void initialize(String Num) {
        userNumber = Num;
    	frame = MainFrame.frame;

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        
        String imgURL = LaFi.imgURL+"TitleLogo2.png";
        Image img = toolkit.getImage(imgURL);

//        frame.setIconImage(img);

//        frame.setSize(1280, 800);

        // frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

//        frame.setUndecorated(true);
//
//        frame.setResizable(false);
//
//        frame.setLocationRelativeTo(null);
//
//        frame.getContentPane().setLayout(null);
        
        Calendar today = Calendar.getInstance();

        Calendar dday = Calendar.getInstance();

        dday.set(2020, Calendar.JULY, 5);

        long today1 = today.getTimeInMillis() / (24 * 60 * 60 * 1000);

        long dday1 = dday.getTimeInMillis() / (24 * 60 * 60 * 1000);

        String result = (today1 - dday1 < 0)

            ? (-(today1 - dday1)) + " days"

            : " + " + (

                today1 - dday1

            ) + " days";
        
        // Get Yesterday, Today, Tomorrow

        Calendar yesterdayCalendar = Calendar.getInstance();

        Calendar todayCalendar = Calendar.getInstance();

        Calendar tomorrowCalendar = Calendar.getInstance();

        yesterdayCalendar.add(Calendar.DATE, -1);

        tomorrowCalendar.add(Calendar.DATE, + 1);

        int yes_y = yesterdayCalendar.get(Calendar.YEAR);

        int yes_m = yesterdayCalendar.get(Calendar.MONTH) + 1;
      
        int yes_d = yesterdayCalendar.get(Calendar.DATE);

        int tod_y = todayCalendar.get(Calendar.YEAR);

        int tod_m = todayCalendar.get(Calendar.MONTH) + 1;

        int tod_d = todayCalendar.get(Calendar.DATE);

        int tom_y = tomorrowCalendar.get(Calendar.YEAR);

        int tom_m = tomorrowCalendar.get(Calendar.MONTH) + 1;

        int tom_d = tomorrowCalendar.get(Calendar.DATE);




        String y_yes = ""+yes_y;
        
        String m_yes = ""+yes_m;
        
        String d_yes = ""+yes_d;
        
        if(m_yes.length() == 1)
        
            m_yes = "0"+m_yes;
            
        if(d_yes.length() == 1)
        
            d_yes = "0"+d_yes;
            
        yesterday_ymd = y_yes+m_yes+d_yes;
        
        
        
        String y_tod = ""+tod_y;
        
        String m_tod = ""+tod_m;
        
        String d_tod = ""+tod_d;
        
        if(m_tod.length() == 1)
        
            m_tod = "0"+m_tod;
            
        if(d_tod.length() == 1)
        
            d_tod = "0"+d_tod;
            
       today_ymd = y_tod+m_tod+d_tod;
        
        
        
        String y_tom = ""+tom_y;
        
        String m_tom = ""+tom_m;
        
        String d_tom = ""+tom_d;
        
        if(m_tom.length() == 1)
        
            m_tom = "0"+m_tom;
            
        if(d_tom.length() == 1)
        
            d_tom = "0"+d_tom;
            
        tomorrow_ymd = y_tom+m_tom+d_tom;
        
        
        //main Panel
        JPanel mainPanel = new JPanel();

        mainPanel.setBounds(0, 0, 1280, 800);

        frame.getContentPane().add(mainPanel);

        mainPanel.setBorder(null);

        mainPanel.setBackground(Color.WHITE);

        mainPanel.setLayout(null);

        // MainPanel Date

        mainLabel_date.setForeground(Color.GRAY);

        mainLabel_date.setFont(new Font("Arial Black", Font.PLAIN, 30));

        mainLabel_date.setHorizontalAlignment(SwingConstants.CENTER);

        mainLabel_date.setBounds(0, 10, 450, 54);

        mainPanel.add(mainLabel_date);

        // MainPanel Clock

        mainLabel_clock.setFont(new Font("Arial Black", Font.PLAIN, 40));

        mainLabel_clock.setHorizontalAlignment(SwingConstants.CENTER);

        mainLabel_clock.setBounds(0, 45, 450, 64);

        mainPanel.add(mainLabel_clock);

        // MainPanel User Name

        JLabel mainLabel_name = new JLabel();

        mainLabel_name.setFont(new Font("Arial Black", Font.BOLD, 20));

        mainLabel_name.setHorizontalAlignment(SwingConstants.CENTER);

        mainLabel_name.setForeground(Color.BLACK);

        mainLabel_name.setBounds(0, 100, 450, 40);
        
        mainLabel_name.setText(Name);

        mainPanel.add(mainLabel_name);

        // MainPanel Good Sentence

        mainLabel_sentence.setForeground(Color.GRAY);

        mainLabel_sentence.setFont(new Font("Arial Black", Font.BOLD, 15));

        mainLabel_sentence.setHorizontalAlignment(SwingConstants.CENTER);

        mainLabel_sentence.setBounds(0, 130, 450, 45);

        mainPanel.add(mainLabel_sentence);

        // MainPanel TurnOff Button

        JButton mainBtn_turnOff = new JButton("");

        mainBtn_turnOff.setContentAreaFilled(false); // Image Size

        mainBtn_turnOff.setBorder(null);

        mainBtn_turnOff.setIcon(new ImageIcon(LaFi.imgURL+"icon.png"));

        mainBtn_turnOff.setBounds(1150, 704, 64, 64);

        mainPanel.add(mainBtn_turnOff);

        mainBtn_turnOff.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                try {

                    // Process pr = Runtime.getRuntime().exec("raspistill -o test.jpg");

                    // Time Sleep

                    // sThread.sleep(100);

                } catch (Exception ex) {

                    System.out.println(ex.getMessage());

                }

                System.exit(0); // Exit System

            }

        });

        // MainPanel Mirror

        // JLabel mainLabel_mirror = new JLabel("");

        // mainLabel_mirror.setBounds(-5, 151, 450, 649);

        // mainPanel.add(mainLabel_mirror);

        // mainLabel_mirror.setHorizontalAlignment(SwingConstants.CENTER);

        // mainLabel_mirror.setBorder(BorderColor.border_BLACK);

        // MainPanel Dday Icon

        JLabel mainLabel_icon = new JLabel("");

        mainLabel_icon.setIcon(new ImageIcon(LaFi.imgURL+"Logo_login.png"));

        mainLabel_icon.setHorizontalAlignment(SwingConstants.CENTER);

        mainLabel_icon.setFont(new Font("Arial Black", Font.PLAIN, 15));

        mainLabel_icon.setBounds(716, 39, 57, 67);

        mainPanel.add(mainLabel_icon);

        // MainPanel Dday Background

        JLabel mainLabel_DdayBackground = new JLabel();

        mainLabel_DdayBackground.setIcon(new ImageIcon(LaFi.imgURL+"Main_Dday.png"));

        mainLabel_DdayBackground.setHorizontalAlignment(SwingConstants.CENTER);

        mainLabel_DdayBackground.setFont(new Font("Arial Black", Font.PLAIN, 15));

        mainLabel_DdayBackground.setBorder(null);

        mainLabel_DdayBackground.setBounds(727, 10, 513, 129);

        mainPanel.add(mainLabel_DdayBackground);

        
        // MainPanel Dday Count
        String DdayArray[] = getDday.getDday(userNumber);
        
        JLabel mainText_DdayCount = new JLabel();

        mainText_DdayCount.setFont(new Font("Arial Black", Font.PLAIN, 25));

        mainText_DdayCount.setHorizontalAlignment(SwingConstants.CENTER);

        mainText_DdayCount.setBounds(1098, 62, 116, 21);

        mainText_DdayCount.setBorder(null);

        mainText_DdayCount.setText(DdayArray[0]);

        mainPanel.add(mainText_DdayCount);

        // MainPanel Dday Sentence  
        
        JLabel mainText_DdaySentence = new JLabel();

        mainText_DdaySentence.setHorizontalAlignment(SwingConstants.CENTER);

//        mainText_DdaySentence.setFont(new Font("Arial Black", Font.BOLD, 15));
        mainText_DdaySentence.setFont(new Font("Arial Black", Font.PLAIN, 35));
        mainText_DdaySentence.setBounds(783, 52, 317, 40);

        mainText_DdaySentence.setBorder(null);

        mainText_DdaySentence.setText(DdayArray[1]);

        mainPanel.add(mainText_DdaySentence);

        // Weather Panel
        

        JPanel panel_Weather = new JPanel();
        TitledBorder Weather_Border = new TitledBorder(new LineBorder(Color.black),"Weather");
       
        panel_Weather.setBounds(20, 250, 450, 600);
        panel_Weather.setBorder(Weather_Border);

        panel_Weather.setBorder(null);

        panel_Weather.setBackground(null);

        mainPanel.add(panel_Weather);

        panel_Weather.setLayout(null);

        // Weather Panel lowest temperature Text

        JLabel mainLable_lowest = new JLabel("Lowest");

//        mainLable_lowest.setFont(new Font("Arial Black", Font.PLAIN, 15));

        mainLable_lowest.setHorizontalAlignment(SwingConstants.CENTER);

        mainLable_lowest.setBounds(60, 2, 72, 30);

        panel_Weather.add(mainLable_lowest);

        // Weather Panel lowest temperature Value

        JLabel mainLable_lowestValue = new JLabel();

        mainLable_lowestValue.setFont(new Font("HyhwpEQ", Font.BOLD, 17));

        mainLable_lowestValue.setHorizontalAlignment(SwingConstants.CENTER);

        mainLable_lowestValue.setBounds(200, 2, 72, 30);

        mainLable_lowestValue.setText(allRainTem[8] + "℃");

        panel_Weather.add(mainLable_lowestValue);

        // Weather Panel highest temperature Text

        JLabel mainLable_highest = new JLabel("Highest");

        mainLable_highest.setFont(new Font("Arial Black", Font.PLAIN, 15));

        mainLable_highest.setHorizontalAlignment(SwingConstants.CENTER);

        mainLable_highest.setBounds(60, 32, 72, 30);

        panel_Weather.add(mainLable_highest);

        // Weather Panel highest temperature Value

        JLabel mainLable_highestValue = new JLabel();

        mainLable_highestValue.setHorizontalAlignment(SwingConstants.CENTER);

        mainLable_highestValue.setFont(new Font("HyhwpEQ", Font.BOLD, 17));

        mainLable_highestValue.setBounds(200, 32, 72, 30);

        mainLable_highestValue.setText(allRainTem[9] + "℃");

        panel_Weather.add(mainLable_highestValue);
        
        // Weather Temperature and Precipitation
        JLabel t1 = new JLabel("온도");

        t1.setFont(new Font("맑은고딕", Font.PLAIN, 15));

        t1.setHorizontalAlignment(SwingConstants.CENTER);

        t1.setBounds(120, 75, 110, 40);

        panel_Weather.add(t1);
        
        JLabel t2 = new JLabel("강수확률");

        t2.setFont(new Font("맑은고딕", Font.PLAIN, 15));

        t2.setHorizontalAlignment(SwingConstants.CENTER);

        t2.setBounds(240, 75, 110, 40);

        panel_Weather.add(t2);
        // Weather Panel 06 AM Text

        JLabel mainLable_06 = new JLabel("06 AM");

        mainLable_06.setFont(new Font("Arial Black", Font.PLAIN, 15));

        mainLable_06.setHorizontalAlignment(SwingConstants.CENTER);

        mainLable_06.setBounds(0, 120, 110, 40);

        panel_Weather.add(mainLable_06);

        // Weather Panel 06 AM Rain

        JLabel mainLable_rain06Value = new JLabel();

        mainLable_rain06Value.setFont(new Font("HyhwpEQ", Font.BOLD, 20));

        mainLable_rain06Value.setHorizontalAlignment(SwingConstants.CENTER);

        mainLable_rain06Value.setBounds(240, 120, 110, 40);

        mainLable_rain06Value.setText(allRainTem[0] + "%");

        panel_Weather.add(mainLable_rain06Value);

        // Weather Panel 06 AM temperature

        JLabel mainLable_tem06Value = new JLabel();

        mainLable_tem06Value.setFont(new Font("HyhwpEQ", Font.BOLD, 20));

        mainLable_tem06Value.setHorizontalAlignment(SwingConstants.CENTER);

        mainLable_tem06Value.setBounds(120, 120, 110, 40);

        mainLable_tem06Value.setText(allRainTem[1] + "℃");

        panel_Weather.add(mainLable_tem06Value);

        // Weather Panel 12 PM Text

        JLabel mainLable_12 = new JLabel("12 PM");

        mainLable_12.setFont(new Font("Arial Black", Font.PLAIN, 15));

        mainLable_12.setHorizontalAlignment(SwingConstants.CENTER);

        mainLable_12.setBounds(0, 190, 110, 40);

        panel_Weather.add(mainLable_12);

        // Weather Panel 12 PM Rain

        JLabel mainLable_rain12Value = new JLabel();

        mainLable_rain12Value.setFont(new Font("HyhwpEQ", Font.BOLD, 20));

        mainLable_rain12Value.setHorizontalAlignment(SwingConstants.CENTER);

        mainLable_rain12Value.setBounds(240,190, 110, 40);

        mainLable_rain12Value.setText(allRainTem[2] + "%");

        panel_Weather.add(mainLable_rain12Value);

        // Weather Panel 12 PM temperature

        JLabel mainLable_tem12Value = new JLabel();

        mainLable_tem12Value.setFont(new Font("HyhwpEQ", Font.BOLD, 20));

        mainLable_tem12Value.setHorizontalAlignment(SwingConstants.CENTER);

        mainLable_tem12Value.setBounds(120, 190, 110, 40);

        mainLable_tem12Value.setText(allRainTem[3] + "℃");

        panel_Weather.add(mainLable_tem12Value);

        // Weather Panel 06 PM Text

        JLabel mainLable_18 = new JLabel("06 PM");

        mainLable_18.setFont(new Font("Arial Black", Font.PLAIN, 15));

        mainLable_18.setHorizontalAlignment(SwingConstants.CENTER);

        mainLable_18.setBounds(0, 260, 110, 40);

        panel_Weather.add(mainLable_18);

        // Weather Panel 06 PM Rain

        JLabel mainLable_rain18Value = new JLabel();

        mainLable_rain18Value.setFont(new Font("HyhwpEQ", Font.BOLD, 20));

        mainLable_rain18Value.setHorizontalAlignment(SwingConstants.CENTER);

        mainLable_rain18Value.setBounds(240, 260, 110, 40);

        mainLable_rain18Value.setText(allRainTem[4] + "%");

        panel_Weather.add(mainLable_rain18Value);

        // Weather Panel 06 PM temperature

        JLabel mainLable_tem18Value = new JLabel();

        mainLable_tem18Value.setFont(new Font("HyhwpEQ", Font.BOLD, 20));

        mainLable_tem18Value.setHorizontalAlignment(SwingConstants.CENTER);

        mainLable_tem18Value.setBounds(120, 260, 110, 40);

        mainLable_tem18Value.setText(allRainTem[5] + "℃");

        panel_Weather.add(mainLable_tem18Value);

        // Weather Panel 00 AM Text

        JLabel mainLable_24 = new JLabel("00 AM");

        mainLable_24.setFont(new Font("Arial Black", Font.PLAIN, 15));

        mainLable_24.setHorizontalAlignment(SwingConstants.CENTER);

        mainLable_24.setBounds(0, 330, 110, 40);

        panel_Weather.add(mainLable_24);

        // Weather Panel 00 AM Rain

        JLabel mainLable_rain24Value = new JLabel();

        mainLable_rain24Value.setFont(new Font("HyhwpEQ", Font.BOLD, 20));

        mainLable_rain24Value.setHorizontalAlignment(SwingConstants.CENTER);

        mainLable_rain24Value.setBounds(240, 330, 110, 40);

        mainLable_rain24Value.setText(allRainTem[6] + "%");

        panel_Weather.add(mainLable_rain24Value);

        // Weather Panel 00 AM temperature

        JLabel mainLable_tem24Value = new JLabel();

        mainLable_tem24Value.setFont(new Font("HyhwpEQ", Font.BOLD, 20));

        mainLable_tem24Value.setHorizontalAlignment(SwingConstants.CENTER);

        mainLable_tem24Value.setBounds(120, 330, 110, 40);

        mainLable_tem24Value.setText(allRainTem[7] + "℃");

        panel_Weather.add(mainLable_tem24Value);

        // Main Panel Date Yesterday

        JLabel mainDate_Yesterday = new JLabel();

        mainDate_Yesterday.setHorizontalAlignment(SwingConstants.CENTER);

        mainDate_Yesterday.setBounds(672, 585, 399, 33);

        mainDate_Yesterday.setText(yes_y + " / " + yes_m + " / " + yes_d + " (Yesterday)");

        mainDate_Yesterday.setVisible(false);

        mainPanel.add(mainDate_Yesterday);

        // Main Panel Date Today

        JLabel mainDate_Today = new JLabel();

        mainDate_Today.setHorizontalAlignment(SwingConstants.CENTER);

        mainDate_Today.setBounds(672, 585, 399, 33);

        mainDate_Today.setText(tod_y + " / " + tod_m + " / " + tod_d + " (Today)");

        mainPanel.add(mainDate_Today);

        // Main Panel Date Tomorrow

        JLabel mainDate_Tomorrow = new JLabel();

        mainDate_Tomorrow.setHorizontalAlignment(SwingConstants.CENTER);

        mainDate_Tomorrow.setBounds(672, 585, 399, 33);

        mainDate_Tomorrow.setText(tom_y + " / " + tom_m + " / " + tom_d + " (Tomorrow)");

        mainDate_Tomorrow.setVisible(false);

        mainPanel.add(mainDate_Tomorrow);

        // Main Panel Memo Yesterday
        check = true;
        
        mainTextArea_yesterday = new JTextArea();

        String getMemoYesterday = getMemo.getMemo(userNumber, yesterday_ymd);//getUserMemo.returnMemo("1", yesterday_ymd);

		mainTextArea_yesterday.setText(" \n"+getMemoYesterday);

        mainTextArea_yesterday.setEditable(false);

        mainTextArea_yesterday.setCaretPosition(0); // Fixed Top

        mainTextArea_yesterday.setFont((new Font(Font11, Font.PLAIN, 30)));

        mainPanel.add(mainTextArea_yesterday);

        // Main Panel ScrollPane Yesterday

        JScrollPane mainScroll_yesterday = new JScrollPane(mainTextArea_yesterday);

        mainScroll_yesterday.setBounds(512, 173, 716, 400);

        mainScroll_yesterday.setBorder(BorderColor.border_BLACK);

        mainScroll_yesterday.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        mainScroll_yesterday.getVerticalScrollBar().setUnitIncrement(15);

        mainScroll_yesterday.setVisible(false);

        mainPanel.add(mainScroll_yesterday);

        // Main Panel Memo Today
        
       

        mainTextArea_tooday = new JTextArea();

		String getMemoToday = getMemo.getMemo(userNumber, today_ymd);//getUserMemo.returnMemo("1", today_ymd);

		mainTextArea_tooday.setText(" \n"+getMemoToday);
        
        mainTextArea_tooday.setEditable(false);

        mainTextArea_tooday.setCaretPosition(0); // Fixed Top

        mainTextArea_tooday.setFont((new Font(Font11, Font.PLAIN, 30)));

        mainPanel.add(mainTextArea_tooday);

        // Main Panel ScrollPane Today

        JScrollPane mainScroll_today = new JScrollPane(mainTextArea_tooday);

        mainScroll_today.setBounds(512, 173, 716, 400);

        mainScroll_today.setBorder(BorderColor.border_BLACK);

        mainScroll_today.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        mainScroll_today.getVerticalScrollBar().setUnitIncrement(15);

        mainPanel.add(mainScroll_today);

        // Main Panel Memo Tomorrow

        mainTextArea_tomorrow = new JTextArea();

        String getMemoTomorrow = getMemo.getMemo(userNumber, tomorrow_ymd);//getUserMemo.returnMemo("1", tomorrow_ymd);

        mainTextArea_tomorrow.setText(" \n"+getMemoTomorrow);

        mainTextArea_tomorrow.setEditable(false);

        mainTextArea_tomorrow.setCaretPosition(0); // Fixed Top

        mainTextArea_tomorrow.setFont((new Font(Font11, Font.PLAIN, 30)));

        mainPanel.add(mainTextArea_tomorrow);

        // Main Panel ScrollPane Tomorrow

        JScrollPane mainScroll_tomorrow = new JScrollPane(mainTextArea_tomorrow);

        mainScroll_tomorrow.setBounds(512, 173, 716, 400);

        mainScroll_tomorrow.setBorder(BorderColor.border_BLACK);

        mainScroll_tomorrow.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        mainScroll_tomorrow.getVerticalScrollBar().setUnitIncrement(15);

        mainScroll_tomorrow.setVisible(false);

        mainPanel.add(mainScroll_tomorrow);

        // Main Panel Memo Button Yesterday

        JButton mainBtn_yesterday = new JButton();

        mainBtn_yesterday.setIcon(new ImageIcon(LaFi.imgURL+"Memo_Yesterday.png"));

        mainBtn_yesterday.setBounds(512, 582, 112, 33);

        mainBtn_yesterday.setContentAreaFilled(false);

        mainBtn_yesterday.setBorder(null);

        mainPanel.add(mainBtn_yesterday);

        // Main Panel Memo Button Today_LEFT

        JButton mainBtn_todayLeft = new JButton();

        mainBtn_todayLeft.setHorizontalAlignment(SwingConstants.RIGHT);

        mainBtn_todayLeft.setIcon(new ImageIcon(LaFi.imgURL+"Memo_Today2.png"));

        mainBtn_todayLeft.setBounds(511, 583, 84, 33);

        mainBtn_todayLeft.setContentAreaFilled(false);

        mainBtn_todayLeft.setBorder(null);

        mainBtn_todayLeft.setVisible(false);

        mainPanel.add(mainBtn_todayLeft);

        // Main Panel Memo Button Today_RIGHT

        JButton mainBtn_todayRight = new JButton();

        mainBtn_todayRight.setHorizontalAlignment(SwingConstants.LEFT);

        mainBtn_todayRight.setIcon(new ImageIcon(LaFi.imgURL+"Memo_Today1.png"));

        mainBtn_todayRight.setBounds(1147, 583, 84, 33);

        mainBtn_todayRight.setContentAreaFilled(false);

        mainBtn_todayRight.setBorder(null);

        mainBtn_todayRight.setVisible(false);

        mainPanel.add(mainBtn_todayRight);

        // Main Panel Memo Button Tomorrow

        JButton mainBtn_tomorrow = new JButton();

        mainBtn_tomorrow.setIcon(new ImageIcon(LaFi.imgURL+"Memo_Tomorrow.png"));

        mainBtn_tomorrow.setBounds(1114, 583, 114, 33);

        mainBtn_tomorrow.setContentAreaFilled(false);

        mainBtn_tomorrow.setBorder(null);

        mainPanel.add(mainBtn_tomorrow);

        // Main Panel Memon Button Yesterday

        mainBtn_yesterday.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) { // Change Scroll
            	dayCheck = 1;
                mainScroll_yesterday.setVisible(true);

                mainScroll_today.setVisible(false);

                mainScroll_tomorrow.setVisible(false);

                // Change Button

                mainBtn_yesterday.setVisible(false);

                mainBtn_todayLeft.setVisible(true);

                mainBtn_todayRight.setVisible(false);

                mainBtn_tomorrow.setVisible(true);

                // Change Date

                mainDate_Yesterday.setVisible(true);

                mainDate_Today.setVisible(false);

                mainDate_Tomorrow.setVisible(false);

            }

        });

        // Main Panel Memon Button Today Left

        mainBtn_todayLeft.addActionListener(new ActionListener() {
        	
            public void actionPerformed(ActionEvent e) { // Change Scroll
            	dayCheck = 2;

                mainScroll_yesterday.setVisible(false);

                mainScroll_today.setVisible(true);

                mainScroll_tomorrow.setVisible(false);

                // Change Button

                mainBtn_yesterday.setVisible(true);

                mainBtn_todayLeft.setVisible(false);

                mainBtn_todayRight.setVisible(false);

                mainBtn_tomorrow.setVisible(true);

                // //Change Date

                mainDate_Yesterday.setVisible(false);

                mainDate_Today.setVisible(true);

                mainDate_Tomorrow.setVisible(false);

            }

        });

        // Main Panel Memon Button Today Right

        mainBtn_todayRight.addActionListener(new ActionListener() {
        	
            public void actionPerformed(ActionEvent e) { // Change Scroll Dispaly

                mainScroll_yesterday.setVisible(false);

                mainScroll_today.setVisible(true);

                mainScroll_tomorrow.setVisible(false);

                // Change Button

                mainBtn_yesterday.setVisible(true);

                mainBtn_todayLeft.setVisible(false);

                mainBtn_todayRight.setVisible(false);

                mainBtn_tomorrow.setVisible(true);

                // Change Date

                mainDate_Yesterday.setVisible(false);

                mainDate_Today.setVisible(true);

                mainDate_Tomorrow.setVisible(false);

            }

        });

        // Main Panel Memon Button Tomorrow

        mainBtn_tomorrow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { // Change Scroll
            	
                mainScroll_yesterday.setVisible(false);

                mainScroll_today.setVisible(false);

                mainScroll_tomorrow.setVisible(true);

                // Change Button

                mainBtn_yesterday.setVisible(true);

                mainBtn_todayLeft.setVisible(false);

                mainBtn_todayRight.setVisible(true);

                mainBtn_tomorrow.setVisible(false);

                // Change Date

                mainDate_Yesterday.setVisible(false);

                mainDate_Today.setVisible(false);

                mainDate_Tomorrow.setVisible(true);

            }

        });


    	
    	
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    @Override 
    
	public void run() { // TODO Auto-generated method stub

    	String[] sentence = new String[SENTENCE];
    	
    	// Good Sentence(Same SENTENCE[].length)

    	sentence[0] = "Life isn't always what one like";

    	sentence[1] = "A friend is a second self";

    	sentence[2] = "Respect yourself and other will respect you";

    	while (true) {

    		Calendar t = Calendar.getInstance();

    		Calendar t_yes = Calendar.getInstance();

    		Calendar t_tom = Calendar.getInstance();

    		String week = "";
        
    		String ampm = "";
    		
    		String hour = "";
    		
    		String min = "";
    		
    		String sec = "";
        
    		// Get Time

    		int year = t.get(Calendar.YEAR);
    		
    		int month = t.get(Calendar.MONTH);
	
	        int date = t.get(Calendar.DATE);
	
	        int getweek = t.get(Calendar.DAY_OF_WEEK);
	        
	        int gethour = t.get(Calendar.HOUR);

	        int getmin = t.get(Calendar.MINUTE);
	        
	        int getsec = t.get(Calendar.SECOND);

	        int getampm = t.get(Calendar.AM_PM);
	        
	        // SMTWTFS

	        switch (getweek) {

	        	case 1:
            	
	        		week = "SUN";
	
	                break;

	        	case 2:
            	
	        		week = "MON";

	        		break;

	        	case 3:

	        		week = "TUE";
                
	        		break;
                
	        	case 4:

	        		week = "WED";
	        		
	        		break;

	        	case 5:

	        		week = "THU";
                
	        		break;

	        	case 6:

	        		week = "FRI";

	        		break;

	        	case 7:

	        		week = "SAT";

	        		break;
                
	        }

	        // AM PM

	        if (getampm == 1) {

	        	ampm = "PM";

	        } else {
        	
	        	ampm = "AM";

	        }

	        // "0" + Hour, Minute, second

	        if (gethour < 10) 
	        	hour = "0" + gethour;
	        else 
	        	hour = "" + gethour;
	        if (getmin < 10) 
	        	min = "0" + getmin;
	         else 
	        	 min = "" + getmin;
	        if (getsec < 10)
	        	sec = "0" + getsec;
	        else 
	        	sec = "" + getsec;
	        month += 1;
	        // (why) month is start 0
	        // Select Sentence
	        char[] arr = {};
	        arr = sentence[pickSentence].toCharArray();
	        // Print Sentence
	        if (count < arr.length && count < arr.length) {
	        	text += arr[count ++];
	        	Memo_Main.mainLabel_sentence.setText(text);
	        }
	        // Make Clock
	        Memo_Main.mainLabel_date.setText(year + " / " + month + " / " + date + " " + week);
	        Memo_Main.mainLabel_clock.setText(hour + " : " + min + " : " + sec + " " + ampm);
	        // 이걸로 실시간 업데이트
	        update_memo();
	        // Time sleep
	        try { // Time Sleep
	        	Thread.sleep(100);
	        } catch (Exception e) {
	        	System.out.println(e.getMessage());	
	        }
    	} // Thread while
    } // Thread run
}
