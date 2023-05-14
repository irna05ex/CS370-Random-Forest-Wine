package rf;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
public class rfInputGUI implements ActionListener
{
	
	public String[] input = new String[12];
	
	JFrame popup;
	
	JComboBox Blee;
	JTextField FixedAcidity;
	JTextField VolatileAcidity;
	JTextField CitricAcid;
	JTextField ResidualSugar;
	JTextField Chlorides;
	JTextField FreeSulfurDioxide;
	JTextField TotalSulfurDioxide;
	JTextField Density;
	JTextField PH;
	JTextField Sulphates;
	JTextField Alcohol;
	
	JPanel B;
	JPanel F;
	JPanel V;
	JPanel C;
	JPanel R;
	JPanel Rs;
	JPanel Cl;
	JPanel Fs;
	JPanel Ts;
	JPanel D;
	JPanel P;
	JPanel S;
	JPanel A;
	
	String t1;
	String[] t2;
	
	rfInputGUI() 
	{   
		popup = new JFrame();
		popup.setSize(690, 420);
		popup.setTitle("Wine Quality App");
		popup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		popup.setLayout(new GridLayout(7, 3));
		popup.getContentPane().setBackground(new Color(140, 0, 52));
		
		B = new JPanel();
		B.setBackground(new Color(140, 0, 52));
		F = new JPanel();
		F.setBackground(new Color(140, 0, 52));
		V = new JPanel();
		V.setBackground(new Color(140, 0, 52));
		C = new JPanel();
		C.setBackground(new Color(140, 0, 52));
		R = new JPanel();
		R.setBackground(new Color(140, 0, 52));
		Rs = new JPanel();
		Rs.setBackground(new Color(140, 0, 52));
		Cl = new JPanel();
		Cl.setBackground(new Color(140, 0, 52));
		Fs = new JPanel();
		Fs.setBackground(new Color(140, 0, 52));
		Ts = new JPanel();
		Ts.setBackground(new Color(140, 0, 52));
		D = new JPanel();
		D.setBackground(new Color(140, 0, 52));
		P = new JPanel();
		P.setBackground(new Color(140, 0, 52));
		S = new JPanel();
		S.setBackground(new Color(140, 0, 52));
		A = new JPanel();
		A.setBackground(new Color(140, 0, 52));
		
		popup.add(new JLabel());
		popup.add(new JLabel());
		popup.add(new JLabel());
		popup.add(new JLabel());
		popup.add(B);
		popup.add(new JLabel());
		popup.add(F);
		popup.add(V);
		popup.add(C);
		popup.add(Fs);
		popup.add(Ts);
		popup.add(D);
		popup.add(P);
		popup.add(S);
		popup.add(A);
		popup.add(new JLabel());
		
		JButton button = new JButton();
		button.setText("Test");
		button.addActionListener(this);
		button.setFocusable(false);
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(227, 83, 117));
		button.setBorder(new LineBorder (new Color(227, 83, 117)));
		
		JLabel Bl = new JLabel("Color/Blee");
		String [] BleeStrings = {"Red", "White"};
		Blee = new JComboBox(BleeStrings);
		Bl.setForeground(Color.WHITE);
		B.add(Bl);
		B.add(Box.createHorizontalStrut(15));
		Blee.setForeground(Color.WHITE);
		Blee.setBackground(new Color(227, 83, 117));
		Blee.setBorder(new LineBorder (new Color(227, 83, 117)));;
		B.add(Blee);
		
		JLabel FA = new JLabel("Fixed Acidity:");
		FixedAcidity = new JTextField(5);
		FA.setForeground(Color.WHITE);
		FixedAcidity.setForeground(Color.WHITE);
	    FixedAcidity.setBackground(new Color(227, 83, 117));
	    FixedAcidity.setBorder(new LineBorder (new Color(227, 83, 117)));;
		F.add(FA);
		F.add(FixedAcidity);
		
		
		JLabel VA = new JLabel("Volatile Acidity");
		VolatileAcidity = new JTextField(5);
		VA.setForeground(Color.WHITE);
		VolatileAcidity.setForeground(Color.WHITE);
		VolatileAcidity.setBackground(new Color(227, 83, 117));
		VolatileAcidity.setBorder(new LineBorder (new Color(227, 83, 117)));;
		V.add(VA);
		V.add(VolatileAcidity);
		
		
		JLabel CA = new JLabel("Citric Acid Amount");
		CitricAcid = new JTextField(5);
		CA.setForeground(Color.WHITE);
		CitricAcid.setForeground(Color.WHITE);
		CitricAcid.setBackground(new Color(227, 83, 117));
		CitricAcid.setBorder(new LineBorder (new Color(227, 83, 117)));;
		C.add(CA);
		C.add(CitricAcid);
		
		JLabel RS = new JLabel("Residual Sugar");
		ResidualSugar = new JTextField(5);
		R.setForeground(Color.WHITE);
		ResidualSugar.setForeground(Color.WHITE);
		ResidualSugar.setBackground(new Color(227, 83, 117));
		ResidualSugar.setBorder(new LineBorder (new Color(227, 83, 117)));;
		R.add(RS);
		R.add(ResidualSugar);
		
		JLabel Ch = new JLabel("Chlorides");
		Chlorides = new JTextField(5);
		Ch.setForeground(Color.WHITE);
		Chlorides.setForeground(Color.WHITE);
		Chlorides.setBackground(new Color(227, 83, 117));
		Chlorides.setBorder(new LineBorder (new Color(227, 83, 117)));;
		Cl.add(Ch);
		Cl.add(Chlorides);
		
		JLabel FSD = new JLabel("Free Sulfur Dioxide");
		FreeSulfurDioxide = new JTextField(5);
		FSD.setForeground(Color.WHITE);
		FreeSulfurDioxide.setForeground(Color.WHITE);
		FreeSulfurDioxide.setBackground(new Color(227, 83, 117));
		FreeSulfurDioxide.setBorder(new LineBorder (new Color(227, 83, 117)));;
		Fs.add(FSD);
		Fs.add(FreeSulfurDioxide);
		
		JLabel TSD = new JLabel("Total Sulfur Dioxide");
		TotalSulfurDioxide = new JTextField(5);
		TSD.setForeground(Color.WHITE);
		TotalSulfurDioxide.setForeground(Color.WHITE);
		TotalSulfurDioxide.setBackground(new Color(227, 83, 117));
		TotalSulfurDioxide.setBorder(new LineBorder (new Color(227, 83, 117)));;
		Ts.add(TSD);
		Ts.add(TotalSulfurDioxide);
		
		JLabel Dn = new JLabel("Density");
		Density = new JTextField(5);
		Dn.setForeground(Color.WHITE);
		Density.setForeground(Color.WHITE);
		Density.setBackground(new Color(227, 83, 117));
		Density.setBorder(new LineBorder (new Color(227, 83, 117)));;
		D.add(Dn);
		D.add(Density);
		
		JLabel pH = new JLabel("Wine pH");
		PH = new JTextField(5);
		pH.setForeground(Color.WHITE);
		PH.setForeground(Color.WHITE);
		PH.setBackground(new Color(227, 83, 117));
		PH.setBorder(new LineBorder (new Color(227, 83, 117)));;
		P.add(pH);
		P.add(PH);
		 
		JLabel Su = new JLabel("Sulfates percentage");
		Sulphates = new JTextField(5);
		Su.setForeground(Color.WHITE);
		Sulphates.setForeground(Color.WHITE);
		Sulphates.setBackground(new Color(227, 83, 117));
		Sulphates.setBorder(new LineBorder (new Color(227, 83, 117)));
		S.add(Su);
		S.add(Sulphates);
		
		JLabel Al = new JLabel("Alcolhol Percentage");
		Alcohol = new JTextField(5);
		Al.setForeground(Color.WHITE);
		Alcohol.setForeground(Color.WHITE);
		Alcohol.setBackground(new Color(227, 83, 117));
		Alcohol.setBorder(new LineBorder (new Color(227, 83, 117)));
		A.add(Al);
		A.add(Alcohol);
		
		popup.add(button);
		popup.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		
		input[0] = Blee.toString();
		input[1] = FixedAcidity.getText();
		input[2] = VolatileAcidity.getText();
		input[3] = CitricAcid.getText();
		input[4] = ResidualSugar.getText();
		input[5] = Chlorides.getText();
		input[6] = FreeSulfurDioxide.getText();
		input[7] = TotalSulfurDioxide.getText();
		input[8] = Density.getText();
		input[9] = PH.getText();
		input[10] = Sulphates.getText();
		input[11] = Alcohol.getText();
		
		for(int a = 1; a < 12; a++) 
		{
			//
			try
			{
				float f = Float.parseFloat(input[a]);
			}
			catch(NumberFormatException nfe)
			{
				//make a array for every minval and maxval for an attribute
				System.out.println("this value must be a number between * and *");
			}
			//make an array of avaerage values for each attribute
			if(input[a] == null) input[a] = avgVal[a];
		}
				
		testRF.test(input);
		popup.setvisible(false);
	}
}
