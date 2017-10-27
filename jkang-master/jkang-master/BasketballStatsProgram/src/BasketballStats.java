//upload photo option
//action listeners for each text field
//at least three classes
//using constructors
//use ArrayList, Vector or LinkedList
//Exception Handling
//

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.*;

public class BasketballStats extends JFrame  
{
	private JPanel prompts;
	private JMenuBar bar;
	
	private JMenu add;
	private JMenuItem pro;
	
	private JMenu view;
	private JMenuItem viewAll;
	private JMenuItem viewPlayer;
	
	public BasketballStats()
	{
		super("Basketball Stats");
		setSize(250,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		prompts = new JPanel();
		
		createMenu();
		
		add(prompts);
		
		setVisible(true);
		
	}
	
	public void createMenu()
	{
		bar = new JMenuBar();
				
		add = new JMenu("Add");
		bar.add(add);
		
		pro = new JMenuItem("Pro");
		add.add(pro);
		pro.addActionListener(new addProListener());
		
		view = new JMenu("View");
		bar.add(view);
		
		viewAll = new JMenuItem("All");
		view.add(viewAll);
		
		viewPlayer = new JMenuItem("Player");
		view.add(viewPlayer);
		
		setJMenuBar(bar);
	}
	public void addPro()
	{
		prompts.setLayout(new GridLayout(11,2));
		
		createFont();
		
		setPrompts();
		
		setInput();
		
		addComp();
		
		buttonSetup();
		
		repaint();
	}
	
	Font myFont;
	public void createFont()
	{
		myFont = new Font("Serif", Font.BOLD, 15);
	}
	
	private JLabel nameP, dateP, oppP, scoreP, FGMP, FGAP, REBP,ASTP, BLKP, PTSP;
	public void setPrompts()
	{
		
		
		//prompts
		nameP = new JLabel("Name:");
		nameP.setFont(myFont);
		
		dateP = new JLabel("Date:");
		dateP.setFont(myFont);
		
		oppP = new JLabel("Opp.:");
		oppP.setFont(myFont);
		
		scoreP = new JLabel("Score:");
		scoreP.setFont(myFont);
		
		FGMP = new JLabel("FGM:");
		FGMP.setFont(myFont);
		
		FGAP = new JLabel("FGA:");
		FGAP.setFont(myFont);
		
		REBP = new JLabel("REB:");
		REBP.setFont(myFont);
		
		ASTP = new JLabel("AST:");
		ASTP.setFont(myFont);
		
		BLKP = new JLabel("BLK:");
		BLKP.setFont(myFont);
		
		PTSP = new JLabel("PTS");
		PTSP.setFont(myFont);


	}
	
	private JTextField nameI, dateI, oppI, scoreI, FGMI,FGAI, REBI, ASTI, BLKI, PTSI;
	public void setInput()
	{
		
		//input
		nameI = new JTextField(20);
		dateI = new JTextField(10);
		oppI = new JTextField(3);
		scoreI = new JTextField(7);
		FGMI = new JTextField(2);
		FGAI = new JTextField(2);
		REBI = new JTextField(2);
		ASTI = new JTextField(2);
		BLKI = new JTextField(2);
		PTSI = new JTextField(2);
	}
	
	public void addComp()
	{
		//adding 
		prompts.add(nameP);
		prompts.add(nameI);
		
		prompts.add(dateP);
		prompts.add(dateI);
		
		prompts.add(oppP);
		prompts.add(oppI);
		
		prompts.add(scoreP);
		prompts.add(scoreI);
		
		prompts.add(FGMP);
		prompts.add(FGMI);
		
		prompts.add(FGAP);
		prompts.add(FGAI);
		
		prompts.add(REBP);
		prompts.add(REBI);
		
		prompts.add(ASTP);
		prompts.add(ASTI);
		
		prompts.add(BLKP);
		prompts.add(BLKI);
		
		prompts.add(PTSP);
		prompts.add(PTSI);
	}
	
	JButton save;
	JButton clear;
	public void buttonSetup()
	{
		save = new JButton("Save");
		prompts.add(save);
		save.addActionListener(new SaveInfoListener());
		
		clear = new JButton("Clear");
		prompts.add(clear);
		clear.addActionListener(new ClearInfoListener());
	}
	
	public void repaint()
	{
		prompts.validate();
		prompts.repaint();
	}
	
	private class addProListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			addPro();
		}
	}
	

	String name, date, opp, score, FGM, FGA, REB, AST, BLK, PTS;
	private class SaveInfoListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			name = nameI.getText();
			date = dateI.getText();
			opp = oppI.getText();
			score = scoreI.getText();
			FGM = FGMI.getText();
			FGA = FGAI.getText();
			REB = REBI.getText();
			AST = ASTI.getText();
			BLK = BLKI.getText();
			PTS = PTSI.getText();
		}
		
	}
	
	private class ClearInfoListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			nameI.setText("");
			dateI.setText("");
			oppI.setText("");
			scoreI.setText("");
			FGMI.setText("");
			FGAI.setText("");
			REBI.setText("");
			ASTI.setText("");
			BLKI.setText("");
			PTSI.setText("");
		}
		
	}
	
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getDate() 
	{
		return date;
	}

	public void setDate(String date) 
	{
		this.date = date;
	}

	public String getOpp() 
	{
		return opp;
	}

	public void setOpp(String opp) 
	{
		this.opp = opp;
	}

	public String getScore() 
	{
		return score;
	}

	public void setScore(String score) 
	{
		this.score = score;
	}

	public String getFGM() {
		return FGM;
	}

	public void setFGM(String fGM) {
		FGM = fGM;
	}

	public String getFGA() {
		return FGA;
	}

	public void setFGA(String fGA) {
		FGA = fGA;
	}

	public String getREB() {
		return REB;
	}

	public void setREB(String rEB) {
		REB = rEB;
	}

	public String getAST() {
		return AST;
	}

	public void setAST(String aST) {
		AST = aST;
	}

	public String getBLK() {
		return BLK;
	}

	public void setBLK(String bLK) {
		BLK = bLK;
	}

	public String getPTS() {
		return PTS;
	}

	public void setPTS(String pTS) {
		PTS = pTS;
	}

	
	
	
}
 