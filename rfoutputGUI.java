package rf;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class rfoutputGUI implements ActionListener
{
	JFrame pop;
	public rfoutputGUI(String foretelling, int Like) 
	{
		
		pop = new JFrame();
		pop.setSize(690, 420);
		pop.setTitle("Wine Quality App");
		pop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pop.getContentPane().setBackground(new Color(140, 0, 52));
		
		JPanel F = new JPanel();
		F.setForeground(Color.WHITE);
		F.setBackground(new Color(227, 83, 117));
		F.setBorder(new LineBorder (new Color(227, 83, 117)));
		
		JButton again = new JButton("Try another Wine");
		again.setForeground(Color.WHITE);
		again.setBackground(new Color(227, 83, 117));
		again.setBorder(new LineBorder (new Color(227, 83, 117)));
		
		if(foretelling == "bad quality") 
		{
			pop.setLayout(new GridLayout(2, 1));
			
			JLabel ft = new JLabel("This is not a  wine of good quality/make");
			
			ft.setForeground(Color.WHITE);
			ft.add(ft);
			F.add(new JLabel());
			
			pop.add(F);
			pop.add(again);
		}
		else 
		{
			pop.setLayout(new GridLayout(3, 3));
			JLabel ft = new JLabel("this is a well-made wine, that you should feel comfortable buying");
			ft.setForeground(Color.WHITE);
			F.add(ft);
			
			JPanel Others = new JPanel();
			Others.setForeground(Color.WHITE);
			Others.setBackground(new Color(227, 83, 117));
			Others.setBorder(new LineBorder (new Color(227, 83, 117)));
			oth.setForeground(Color.WHITE);
			oth.setBackground(new Color(227, 83, 117));
			oth.setBorder(new LineBorder (new Color(227, 83, 117)));
			
			if(like == 0)
			{
				JLabel oth = new JLabel(); 
			}
			
			else if(like == 1)
			{
				JLabel oth = new JLabel("There is one wine like the one you put in");
			}
			
			else
			{
				String l = "There are " + Like + "wines like the one you put in."; 
				JLabel oth = new JLabel(l);
			}
			
			oth.setForeground(Color.WHITE);
			
			Others.add(oth);
			
			pop.add(new JLabel());
			pop.add(F);
			pop.add(new JLabel());
			pop.add(new JLabel());
			pop.add(Others);
			pop.add(new JLabel());
			F.add(new JLabel());
			pop.add(again);
		}
		
		pop.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		pop.setVisible(false);
		testRF again = new testRF();
		//go to the testrf loop
	}
}
