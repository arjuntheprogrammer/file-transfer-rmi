import java.rmi.Naming;
import java.util.concurrent.TimeUnit;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Client{

	/*public static JSONObject printFnames(String sDir) throws NullPointerException
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
	*/
	
	public static Tree input(Tree tree,int n, JSONObject obj){
		if(obj.get("type").toString()=="file"){
			
		}
		else{
			
			JSONArray a=(JSONArray)obj.get("subDir");
			//if(a.length!=0)
			for(Object o:a){
				JSONObject obj1=(JSONObject) o; 
				 TreeItem	 treeItem0 = new TreeItem(tree, 0);
			     treeItem0.setText("Level "+(n+1) +" Item " );
			     treeItem0=input_(treeItem0,n+1,obj1);
			}
			
		}
		
		return tree;
	}
	
	public static TreeItem input_ (TreeItem treeitem,int n,JSONObject obj){
		treeitem.setText(obj.get("name").toString() );
		treeitem.setData(obj);
		if(obj.get("type").toString()=="file"){ 
			
		}
		else{
			
			JSONArray a=(JSONArray)obj.get("subDir");
			//if(a.length!=0)
			for(Object o:a){
				JSONObject obj1=(JSONObject) o; 
				 TreeItem treeItem0 = new TreeItem(treeitem, 0);
			     treeItem0=input_(treeItem0,n+1,obj1);
			}
			
		}
		
		
		return treeitem;
	}
	
	
  public static void main(String[] args) {
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setText("Tree Example");

    final Text text = new Text(shell, SWT.BORDER);
    text.setBounds(0, 270, 290, 25);

    Tree tree = new Tree(shell, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL
        | SWT.H_SCROLL);
    tree.setBounds(0,0,290, 260);
    shell.setSize(300, 330);
    
    
    
    String name="dir";
    try {
    	Interface fi = (Interface) Naming.lookup(name);
    	JSONObject obj = (JSONObject)fi.printFnames ("/media/arjun/46A6A679A6A668DF/Users/arjun gupta/Documents/ethical hacking");
    	System.out.println("json object="+obj);
    	TimeUnit.SECONDS.sleep(3);
    	tree=input(tree,0, obj);
    }
    catch(Exception e)
    {
    	System.out.println("Here"+e);
    }
     
    

//    tree.addListener(SWT.Selection, new Listener() {
//      public void handleEvent(Event event) {
//        if (event.detail == SWT.CHECK) {
//          String string="";
//          //JSONObject o = (JSONObject)tree.getSelection();
//          /*TreeItem[] selection = tree.getSelection();
//          for (int i = 0; i < selection.length; i++)
//              string += selection[i].getText().toString() + " ";
//            System.out.println("Selection={" + string + "}");	
//          */
//          TreeItem item = (TreeItem) event.item;
//          TreeItem t;
//          String path=item.getText();
//          
//          t=item.getParentItem();
//          while(t!=null)
//          {
//        	  path=t.getText()+"\\"+path;
//        	  t=t.getParentItem();
//          }
//          System.out.println(path);
//          
//          //text.setText(o.get("name").toString() + " was checked.");
//        } else {
//          text.setText(event.item + " was selected");
//        }
//      }
//    });

    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch())
        display.sleep();
    }
    display.dispose();
  }
}
