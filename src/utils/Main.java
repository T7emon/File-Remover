package utils;

import java.io.File;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import org.pushingpixels.substance.api.skin.RavenSkin;
import org.pushingpixels.substance.api.skin.SubstanceRavenLookAndFeel;

public class Main {

private static final String USER_HOME = System.getProperty("user.home"); //user's home directory;
private static final String FILE_DIRECTORY = USER_HOME + File.separator + "SteroidsPk Files"; //Change this to the path of the Files u want to be removed.

public static void main(String[] args) {
    JDialog.setDefaultLookAndFeelDecorated(true);
    JPopupMenu.setDefaultLightWeightPopupEnabled(true);
    SubstanceRavenLookAndFeel.setSkin(new RavenSkin());
{

	File directory = new File(FILE_DIRECTORY);
	int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to REMOVE Files??", "Confirm", JOptionPane.YES_NO_OPTION);

	if (option == 0) {
	   System.out.print("yes");
	} else {
	   System.out.print("no");
	   System.exit(0);
	}
	//make sure directory exists
	if(!directory.exists()){

       System.out.println("Directory does not exist.");
       
       JOptionPane.showMessageDialog(null, "Directory does not exist!");
       System.exit(0);


    }else{

       try{
           delete(directory);

       }catch(IOException e){
           e.printStackTrace();
           System.exit(0);
       }
    }

	System.out.println("Done");
}
}

public static void delete(File file)
	throws IOException{

	if(file.isDirectory()){

		//directory is empty, then delete it
		if(file.list().length==0){

		   file.delete();
		  System.out.println("Directory is deleted : "
                                             + file.getAbsolutePath());
 		   JOptionPane.showMessageDialog(null, "Directory is Deleted : ", "Finished", 0);
		  
		}else{

		   //list all the directory contents
    	   String files[] = file.list();

    	   for (String temp : files) {
    	      //construct the file structure
    	      File fileDelete = new File(file, temp);

    	      //recursive delete
    	     delete(fileDelete);
    	   }

    	   //check the directory again, if empty then delete it
    	   if(file.list().length==0){
       	     file.delete();
    	     System.out.println("Directory is deleted : "
                                             + file.getAbsolutePath());
    	   }
		}

	}else{
		//if file, then delete it
		file.delete();
		System.out.println("File is deleted : " + file.getAbsolutePath());
	}
}
}