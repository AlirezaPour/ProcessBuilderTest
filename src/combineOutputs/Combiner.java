package combineOutputs;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class Combiner {

	HashMap<Integer, Double> outProb; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Combiner comb = new Combiner(); 
		comb.run();
			
	}
	
	public Combiner(){
		outProb = new HashMap<Integer, Double>();
	}
	
	public void run(){
		
		Scanner in1 = null ;
		Scanner in2 = null; 
		Scanner in3 = null;
		try {
			in1 = new Scanner(new FileReader("/home/alireza/Dropbox/Academics/Thesis/TwoTierNetworkCaseStudy/Model/TwoFemtoCells/PRISM_Analysis/prob_user_near_sending_series_1.csv"));
			in2 = new Scanner(new FileReader("/home/alireza/Dropbox/Academics/Thesis/TwoTierNetworkCaseStudy/Model/TwoFemtoCells/PRISM_Analysis/prob_user_near_sending_series_2.csv"));
			in3 = new Scanner(new FileReader("/home/alireza/Dropbox/Academics/Thesis/TwoTierNetworkCaseStudy/Model/TwoFemtoCells/PRISM_Analysis/prob_user_near_sending_series_3.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Could not the input files.");
			e.printStackTrace();
		}
		
		String line1= "";
		String line2= "";
		String line3= "";
		
		// we skip the first line
		line1 = in1.nextLine();
		line2 = in2.nextLine();
		line2 = in3.nextLine();
		
		while(in1.hasNext()){
			
			line1 = in1.nextLine();
			line2 = in2.nextLine();
			line3 = in3.nextLine();

			String[] tokens1 = line1.split(",");
			String[] tokens2 = line2.split(",");
			String[] tokens3 = line3.split(",");
			
			int currentValue = Integer.parseInt(tokens1[0]);
			
			double prob1 = Double.parseDouble(tokens1[1]); 
			double prob2 = Double.parseDouble(tokens2[1]);
			double prob3 = Double.parseDouble(tokens3[1]);
			
			double prob = ( prob1 + prob2 + prob3 ) / 3; 
			
			outProb.put(currentValue, prob);
			
		}
		
		String output;
		 try {
		        BufferedWriter out = new BufferedWriter(new FileWriter("/home/alireza/Dropbox/Academics/Thesis/TwoTierNetworkCaseStudy/Model/TwoFemtoCells/PRISM_Analysis/prob_user_near_sending.csv"));
		        out.write("value,prob\n");
		        for (int i = 0; i <= 200; i++) {
		        	output = String.format("%d,%f\n",i,outProb.get(i));
		            out.write(output);
		        }
		        out.close();
		 } catch (IOException e) {
			 System.out.printf("Could not write the output file.\n");
			 e.printStackTrace();			 
		 }
		
		
		
		
	}

}
