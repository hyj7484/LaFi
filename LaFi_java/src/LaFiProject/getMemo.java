package LaFiProject;

public class getMemo {
	private static String GetUserMemo(String UserNum, String Today, int num) {
		String url = "getUserMemo";
		String returntext = "";

		String Get = "Num="+UserNum+"&Today="+Today;

		String b = ""; 
		b = LinkPHP.getCon(url, Get);
		
		if(b.length() != 0) {
		String Num[] = b.split("/");
		
		String time[] = new String[Num.length/2];
		String memo[] = new String[Num.length/2];
		int count = 0;
		
		for(int i = 0 ; i < Num.length ; i++) {
			switch(i % 2) {		
			case 0:
				time[count] = Num[i];
				break;
			case 1:
				memo[count] = Num[i];
				count++;
				break;
			}	
		}

		for(int i = 0; i < time.length; i++){
			returntext += time[i]+"  ";
			returntext += memo[i]+"\n";
		}
//		if(num == 1) {
//			for(int i = 0; i < memo.length; i++)
//				returntext += memo[i]+"/";
//		}else if(num == 2){
//			for(int i = 0; i < time.length; i++)
//				returntext += time[i]+"/";
//		} else{
//	        for(int i = 0; i < time.length; i++){
//	             returntext += time[i]+"  ";
//	             returntext += memo[i]+"2\n";
//	        }
//	    }	
		
//		System.out.println(returntext);
		}
		return returntext;
	}

	static String getMemo(String userNum, String date) {
		String getMemo = GetUserMemo(userNum, date, 1);
		String returnMemo = getMemo;//.split("/");
		return returnMemo;
	}
	static String getTime(String userNum, String date) {
		String getTime = GetUserMemo(userNum, date, 2);
		String returnTime = getTime;//.split("/");
		return returnTime;
	}
//	static String getString(String userNum, String date) {
//		String getAll = GetUserMemo(userNum, date, 3);
//		return getAll;
//	}
	public static void main(String args[]) {
		String b = getMemo("8", "20200513");
		
		System.out.println("hello");
		System.out.println(b);
	}
}