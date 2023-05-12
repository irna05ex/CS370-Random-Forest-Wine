package rf;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class rfInputGUI extends JFrame implements ActionListener
{
	
	public String[] input = new String[12];
	
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
	
	rfInputGUI() 
	{
		JFrame popup = new JFrame();
		popup.setSize(690, 420);
		popup.setTitle("Wine Checking App");
		popup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		popup.setLayout(new GridLayout(7, 2));
		
		B = new JPanel();
		F = new JPanel();
		V = new JPanel();
		C = new JPanel();
		R = new JPanel();
		Rs = new JPanel();
		Cl = new JPanel();
		Fs = new JPanel();
		Ts = new JPanel();
		D = new JPanel();
		P = new JPanel();
		S = new JPanel();
		A = new JPanel();
		
		B.setSize(300, 70);
		
		popup.add(B);
		popup.add(F);
		popup.add(V);
		popup.add(C);
		popup.add(Fs);
		popup.add(Ts);
		popup.add(D);
		popup.add(P);
		popup.add(S);
		popup.add(A);
		
		JButton button = new JButton();
		button.setText("Test");
		button.addActionListener(this);
		button.setFocusable(false);
		button.setHorizontalTextPosition(JButton.RIGHT);
		button.setVerticalTextPosition(JButton.BOTTOM);
		
		JLabel Bl = new JLabel("Color/Blee");
		String [] BleeStrings = {"Red", "White"};
		Blee = new JComboBox(BleeStrings);
		B.add(Bl);
		B.add(Blee);
		
		JLabel FA = new JLabel("Fixed Acidity");
		FixedAcidity = new JTextField();
		F.add(FA);
		F.add(FixedAcidity);
		
		
		JLabel VA = new JLabel("Volatile Acidity");
		VolatileAcidity = new JTextField();
		V.add(VA);
		V.add(VolatileAcidity);
		
		
		JLabel CA = new JLabel("Citric Acid Amount");
		CitricAcid = new JTextField();
		C.add(CA);
		C.add(CitricAcid);
		
		JLabel RS = new JLabel("Residual Sugar");
		ResidualSugar = new JTextField();
		R.add(RS);
		R.add(ResidualSugar);
		
		JLabel Ch = new JLabel("Chlorides");
		Chlorides = new JTextField();
		Cl.add(Ch);
		Cl.add(Chlorides);
		
		JLabel FSD = new JLabel("Free Sulfur Dioxide");
		FreeSulfurDioxide = new JTextField();
		Fs.add(FSD);
		Fs.add(FreeSulfurDioxide);
		
		JLabel TSD = new JLabel("Total Sulfur Dioxide");
		TotalSulfurDioxide = new JTextField();
		Ts.add(TSD);
		Ts.add(TotalSulfurDioxide);
		
		JLabel Dn = new JLabel("Density");
		Density = new JTextField();
		D.add(Dn);
		D.add(Density);
		
		JLabel pH = new JLabel("Wine pH");
		PH = new JTextField();
		P.add(pH);
		P.add(PH);
		 
		JLabel Su = new JLabel("Sulfates percentage");
		Sulphates = new JTextField();
		S.add(Su);
		S.add(Sulphates);
		
		JLabel Al = new JLabel("Alcolhol Percentage");
		Alcohol = new JTextField();
		A.add(Al);
		A.add(Alcohol);
		
		popup.add(button);
		popup.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		input[0] = Blee.getAction().toString();
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
				
		testRF.test(input);
	}
}