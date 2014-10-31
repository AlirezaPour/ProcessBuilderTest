import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;



public class ProcessBuildDemo {

	 public static void main(String [] args) throws IOException {
	        
	        String[] command = {"/home/alireza/prism-4.2/bin/prism", "model.sm", "-simpath 'time=5.200000,snapshot=0.100000,vars=(user_near_sending),sep=comma'", "output_path.csv", "-simpathlen 100000000"};
	        ProcessBuilder probuilder = new ProcessBuilder( command );

	        //You can set up your work directory
	        probuilder.directory(new File("/home/alireza/Dropbox/Academics/Thesis/TwoTierNetworkCaseStudy/Model/TwoFemtoCells"));
	        
	        Process process = probuilder.start();
	        
	      //Read out dir output
	        InputStream is = process.getInputStream();
	        InputStreamReader isr = new InputStreamReader(is);
	        BufferedReader br = new BufferedReader(isr);
	        String line;
	        System.out.printf("Output of running %s is:\n",
	                Arrays.toString(command));
	        while ((line = br.readLine()) != null) {
	            System.out.println(line);
	        }
	         
	        
	    }
	
}
