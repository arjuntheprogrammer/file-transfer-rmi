import java.rmi.Naming;

public class StartFileServer {
	public static void main(String ar[]){
		try{
			java.rmi.registry.LocateRegistry.createRegistry(1099);
			
			FileServer fs= new FileServer();
			fs.setFile("a1.txt");
			Naming.rebind("abc", fs);
			System.out.println("FileServer is ready");
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
