import java.awt.Color;
import java.awt.*;
import java.awt.Container;
//import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollBar;
import java.awt.Label;
import javax.swing.JRootPane;
import org.jfree.ui.RefineryUtilities;
import java.io.IOException;


 public class CWC extends JFrame implements ActionListener {

	private JFrame frame,f2,f3,f4;
  private JButton b1,b2,b3,b4,b5;
  private JTextArea  a1;
  private JLabel head;
	private JMenuBar mb;
	private JMenu menu;
  private JMenuItem ab,an,ld;
  private JLabel l3;
  //ImageIcon i;
  String s5="ABOUT:";
  String s1="SARS CoV-2,a coronavirus which is responsible for the 2020 global pandemic.Academic researchers,Doctors and biochemical engineers"+"\n"+" are invested in solving this crisis.";
  String s2="Previous cases of virus epidemics have suggested that weather factors influence the spread of the virus.there is a possibility that"+"\n"+" COVID-19 falls in this category.So we began  to plot graphs between the changing wether conditions (eq-temperature,humidity)to"+"\n"+" the covid cases in certain parts of india. ";
  String s4="Both these analyses were made possible due to the detailed and reliable district-wise dataset provided by the team of https://covindia.com";
  String s6="The app spans 5 featured graphs:"+"\n"+"1.cases vs Temperature"+"\n"+"2.cases vs Relative Humidity"+"\n"+"3.cases vs Specific Humidity "+"\n"+"4.cases vs Dewpoint"+"\n"+"5.cases vs Heatindex";
  String s3=s5+"\n"+"\n"+"\n"+s1+"\n"+"\n"+s2+"\n"+"\n"+s4+"\n"+s6;

public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CWC window = new CWC();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


 
	public CWC() {

		frame = new JFrame();
    f2=new JFrame();
    f3=new JFrame();
    f4=new JFrame();
		frame.setSize(1200,1200);
		frame.setTitle("COVID WEATHER CONNECTION PROJECT");
		frame.getContentPane().setLayout(null);
	  frame.setVisible(true);
  



    f2.setTitle("About");
    f2.setSize(1200,1200);
    f2.setLayout(null);
    f3.setLayout(null);
    f3.setTitle("Analysis");
    f3.setSize(1200,1200);
    f4.setLayout(null);
    f4.setTitle("Effect of Lockdown");
    f4.setSize(1200,1200);
    f2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    f3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    f4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mb=new JMenuBar();
		frame.setJMenuBar(mb);

    
		menu=new JMenu("More");
		ab=new JMenuItem("About");
    an=new JMenuItem("Analysis");
    ld=new JMenuItem("Effect of Lockdown");
		mb.add(menu);
		menu.add(ab);
    menu.add(ld);

    head=new JLabel("COVID WEATHER CONNECTION PROJECT");
    head.setBounds(400,13,800,100);
    head.setFont(new Font("Verdana", Font.BOLD, 16));
    head.setForeground(Color.black);
    frame.add(head);
    a1=new JTextArea();
    a1.setText(s3);
    a1.setFont(new Font("Verdana", Font.PLAIN, 16));
    a1.setForeground(Color.blue);

		b1=new JButton("Temperature");
		b2=new JButton("Relative Humidity");
		b3=new JButton("Dew Point");
		b4=new JButton("Specific Humidity");
		b5=new JButton("Heat Index");

    a1.setBounds(0,50,1170,700);
    f2.add(a1);
    

		b1.setBounds(451,118,249,46);
		b2.setBounds(451,200,249,46);
		b3.setBounds(451,286,249,46);
		b4.setBounds(451,365,249,46);
		b5.setBounds(451,457,249,46);


    frame.add(b1);
    frame.add(b2);
    frame.add(b3);
    frame.add(b4);
    frame.add(b5);

		frame.getContentPane().add(b1);
		frame.getContentPane().add(b2);
		frame.getContentPane().add(b3);
		frame.getContentPane().add(b4);
		frame.getContentPane().add(b5);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(1175,0 , 10, 1000);
		frame.getContentPane().add(scrollBar);

		//Label label = new Label("Click a Button");
		//label.setBounds(530,550, 100, 20);
		//frame.getContentPane().add(label);

		ab.addActionListener(this);
    an.addActionListener(this);
    ld.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}



	public void actionPerformed(ActionEvent e){
try{
		if(e.getSource()==b1){
			Temp p1 =new Temp("Temperature vs Number of Cases");
		}

		if(e.getSource()==b2){
			RelHum p2 =new RelHum("Relative Humidity vs Number of Cases");
		}
		if(e.getSource()==b3){
      DewPoint p3 = new DewPoint("Dew Point vs Number of Cases");
		}
		if(e.getSource()==b4){
			SpecHum p4 = new SpecHum("Specific Humidity vs Number of Cases");
		}
		if(e.getSource()==b5){
      HeatIndex p5 = new HeatIndex("Heat Index vs Number of Cases");
		}
    if(e.getSource()==ab){
      f2.setVisible(true);
    }

    if(e.getSource()==an){
      f3.setVisible(true);
    }
    if(e.getSource()==ld){
      final lockdown demo = new lockdown("Effect of lockdown");
      demo.pack();
      RefineryUtilities.centerFrameOnScreen(demo);
      demo.setVisible(true);
    }
	}

  catch (Exception e1) {
    e1.printStackTrace();
  }
}}
