import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class testRF {
	public static void main(String args[]) throws Exception{
		String [] a = new String[12];
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
			System.out.println("Data set file not found");
			System.exit(1);
		}
		
		RandomForest rf = new RandomForest(2,13,a);
		rf.loadData(red, white);
		
		rf.buildForest();
		/*
		String answer;
		wine test;
		for(int i = 0; i<10000; i++) {
			test = rf.getWine();
			answer = rf.test(test);
			System.out.println(answer);
		}*/
		
		BufferedWriter forest = new BufferedWriter(new FileWriter("forestFile.txt"));
		rf.writeForest(forest);
		//Scanner read =  new Scanner(new FileReader("forestFile.txt"));
		//rf.readForest(read);
	}
}
