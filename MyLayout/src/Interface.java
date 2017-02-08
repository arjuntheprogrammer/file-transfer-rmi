import java.rmi.Remote;

import org.json.simple.JSONObject;

public interface Interface extends Remote{
	public  JSONObject printFnames(String sDir) throws Exception;
}
