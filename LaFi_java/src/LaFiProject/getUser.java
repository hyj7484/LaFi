package LaFiProject;

public class getUser {
	
	static String User[] = getNum();
	
	public String Name[] = new String[User.length / 3];
	public String numPW[] = new String[User.length / 3];
	public String Num[]  = new String[User.length / 3];
	
	{
		int count = 0;
		for(int i = 0; i < User.length; i+=3) {
			Num[count]  = User[i];		
			Name[count] = User[i+1];
			numPW[count] = User[i+2];
			count++;
		}
	}
	
//	public String Name[] = new String[User.length / 2];
//	public String Num[]  = new String[User.length / 2];
//	
//	
//	{
//		int count = 0;
//		for(int i = 0; i < User.length; i+=2) {
//			Num[count]  = User[i];
//			Name[count] = User[i+1];
//			count++;
//		}
//	}
//	
	private static String[] getNum() {
		String getUser = LinkPHP.postCon("getUser");
		String User[] = getUser.split("/");
		return User;
	}
}
