import java.rmi.Naming;
import java.util.Scanner;

public class StartFileClient {
	public static void main(String ar[]){
		try{
			FileClient c=new FileClient("arjun.txt");
			FileServerInt server= (FileServerInt)Naming.lookup("abc");
			server.login(c);
			System.out.println("Listening.....");			
			Scanner s=new Scanner(System.in);			
			while(true){
				String line=s.nextLine();
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
