import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class testRFvar {
	String [] wineVar = new String[12];//global vairable to store input wine variables
	public static void main(String args[]) throws Exception{
		String [] a = new String[12];//strings of wines attributes
		a[0] = "color";
		a[1] = "fixed acidity";
		a[2] = "volatile acidity";
		a[3] = "citric acid";
		a[4] = "residual sugar";
		a[5] = "chlorides";
		a[6] = "free sulfur";
		a[7] = "total sulfur";
		a[8] = "density";
		a[9] = "pH";
		a[10] = "sulphates";
		a[11] = "alcohol";
		Scanner red = null, white = null;
		try {
			red = new Scanner(new FileReader("winequality-red.csv"));
			white =  new Scanner(new FileReader("winequality-white.csv"));
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Wine date set files not found. Program closing."); 
			System.exit(1);
		}
		
		RandomForest rf = new RandomForest(17,25,a);
		rf.loadData(red, white);
		
		String answer = "";
		Scanner read = new Scanner(new FileReader("forestFileLOAD.txt"));
		rf.readForest(read);
		//rf.buildForest();
		
		wine test;
		int acc = 0;
		for(int i = 0; i<3000; i++) {
			test = rf.getWine();
			answer = rf.test(test);
			if(answer.equals("good quality") && test.getQuality() == 1) {
				System.out.println("true good");
				acc++;
				}
			else if(answer.equals("bad quality") && test.getQuality() == 0)
				acc++;
			
			if(answer.equals("good quality") && test.getQuality() == 0)
				System.out.println("not true good");
		}
		System.out.println(acc/3000.0);
		//1277
		//int good = 0;
		
		//BufferedWriter forest = new BufferedWriter(new FileWriter("forestFile.txt"));
		//rf.writeForest(forest);
		
		//Scanner read =  new Scanner(new FileReader("forestFile.txt"));
		//rf.readForest(read);
	}
}


