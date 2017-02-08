import java.io.File;
import java.rmi.server.UnicastRemoteObject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Implement extends UnicastRemoteObject implements Interface{
	
	public Implement() throws Exception{
		
		super();
	}
	
	public  JSONObject printFnames(String sDir) throws NullPointerException
	{
		File dir=new File(sDir);
		JSONObject obj= new JSONObject();
		//System.out.println(dir.getAbsolutePath());
		if(dir.isFile())
		{
			obj.put("type","file");
			obj.put("name", dir.getName());
			
		}
		else if(dir.isDirectory())
		{
			JSONArray ja = new JSONArray();
			
			File[] faFiles = dir.listFiles();
			
			for(File file: faFiles)
			{
				try{
					ja.add(printFnames(file.getAbsolutePath()));
				}
				catch(Exception e){
					
				}
			}
			
			obj.put("type","directory");
			obj.put("name", dir.getName());
			obj.put("subDir", ja);
		}
		return obj;	
		
		   
	}
}
