package LaFiProject;

public class getDday {

	private static String[] GetUserDday(String UserNum) {
		String url = "getdday";
		String returntext = "";
		String day[] = new String[1];

		String Get = "Num="+UserNum;

		String b = ""; 
		b = LinkPHP.getCon(url, Get);

		if(b.length() != 0) {
			String Num[] = b.split("/");
			day = Num;
		}else {
			day = new String[2];
			day[0] = "X";
			day[1] = "X";
		}	
		return day;
	}
	
	static String[] getDday(String userNum) {
		String getMemo[] = GetUserDday(userNum);
		return getMemo;
	}
	
	public static void main(String args[]) {
		String b[] = GetUserDday("3");

		System.out.println("hello");
		for(int i = 0; i < b.length; i++) {
			if(b[i] == "") {
				b[i] = ".?";
			}
			System.out.println(b[i]);
			System.out.println("?????");
		}
		System.out.println("?");
		
	}
}