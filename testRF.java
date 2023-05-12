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


//LINEAR SEARCH
wine[] search = rf.returnSet(); //size 6497
// represeents data forest wineSet
wine q = new wine(); //wine inputed with attributes from GUI

//instead of new wine, set wine q to GUI wine input
//the GUI string inputs must connect to the search
	//q.setAlcohol(); //wine input alcohol
	q.setFixedAcidity(Float.parseFloat(GUIstring[0])); //GUIstring= text input from gui
	q.setVolatileAcidity(Float.parseFloat(GUIstring[1]));
	q.setCitricAcid(Float.parseFloat(GUIstring[2]));
	q.setResidualSugar(Float.parseFloat(GUIstring[3]));
	q.setChlorides(Float.parseFloat(GUIstring[4]));
	q.setFreeSulfer(Float.parseFloat(GUIstring[5]));
	q.setTotalSulfer(Float.parseFloat(GUIstring[6]));
	q.setDensity(Float.parseFloat(GUIstring[7]));
	q.setpH(Float.parseFloat(GUIstring[8]));
	q.setSulfates(Float.parseFloat(GUIstring[9]));
	q.setAlcohal(Float.parseFloat(GUIstring[10]));
	q.setType(String(GUIstring[])); //color of wine

int sim; //similar amount of attributes, start at zero, increments by 1 
//if atrribute is similar

for(int j=0; j< 6497; j++){ //size of dataset
sim=0;

	if(q.getType().equals (search[j].getType())) //Wine color is string
		sim++;	
		
	float qAlc=(q.getAlcohal()/10); //10% of the input
	if(q.getAlcohal()-qAlc<=(search[j].getAlcohal()) && (q.getAlcohal()+qAlc)>=(search[j].getAlcohal()))
		sim++; //if wine from data is within 10% value of input for attribute, then similarity incements by 1

	float qFixA=(q.getFixedAcidity()/10);
	if(q.getFixedAcidity()-qFixA<=(search[j].getFixedAcidity()) && (q.getFixedAcidity()+qFixA)>=(search[j].getFixedAcidity()))
		sim++;} 

	float qAlc=(q.getAlcohal() /10);
	if(q.getAlcohal()-qAlc<=(search[j].getAlcohal()) && (q.getAlcohal()+qAlc)>=(search[j].getAlcohal()))
		sim++;

	float qVolatile=(q.getVolatileAcidity() /10);
	if(q.getVolatileAcidity()-qVolatile<=(search[j].getVolatileAcidity()) && (q.getVolatileAcidity()+qVolatile)>=(search[j].getVolatileAcidity()))
		sim++;

	float qCitric=(q.getCitricAcid() /10);
	if(q.getCitricAcid()-qCitric<=(search[j].getCitricAcid()) && (q.getCitricAcid()+qCitric)>=(search[j].getCitricAcid()))
		sim++;

	float qSugar=(q.getResidualSugar() /10);
	if(q.getResidualSugar()-qSugar<=(search[j].getResidualSugar()) && (q.getResidualSugar()+qSugar)>=(search[j].getResidualSugar()))
		sim++;

	float qChlor=(q.getChlorides() /10);
	if(q.getChlorides()-qChlor<=(search[j].getChlorides()) && (q.getChlorides()+qAlc)>=(search[j].getChlorides()))
		sim++;

	float qSulphF=(q.getFreeSulfer() /10);
	if(q.getFreeSulfer()-qSulphF<=(search[j].getFreeSulfer()) && (q.getFreeSulfer()+qSulphF)>=(search[j].getFreeSulfer()))
		sim++;

	float qSulphT=(q.getTotalSulfer() /10);
	if(q.getTotalSulfer()-qSulphF<=(search[j].getTotalSulfer()) && (q.getTotalSulfer()+qSulphF)>=(search[j].getTotalSulfer()))
			sim++;

	float qDens=(q.getDensity()/10);
	if(q.getDensity()-qDens<=(search[j].getDensity())&&(q.getDensity()+qDens)>=(search[j].getDensity()))
		sim++;

	float qPH=(q.getpH()/10);
	if(q.getpH()-qPH<=(search[j].getpH())&&(q.getpH()+qPH)>=(search[j].getpH()))
		sim++;

	float qSulf=(q.getSulfates()/10);
	if(q.getSulfates()-qSulf<=(search[j].getSulfates())&&(q.getSulfates()+qSulf)>=(search[j].getSulfates()))
		sim++;

	if (sim>=7) //if there are at least 7 similarities between wines, system will print wine
	//if not similar, loop restarts and goes into next wine n dataset
		System.out.println(search[j]);
		return;
}
}
//System.out.println("No similar wine found.");

