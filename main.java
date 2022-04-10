package poker;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;  
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Label;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class main extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private static int phase = 0;
	private static boolean ended = false;
	private static boolean HighCard = false;
	private static File file = new File("balance");
	private static int data = 0;
	private static int betting=1;
	private static ArrayList<Integer> points = new ArrayList<Integer>();
	private boolean pressed = false;
	private boolean Betpressed = false;
	private boolean Callpressed = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					ImageIcon icon = new ImageIcon("chip.jpg");
					Image image = icon.getImage();
					Image image2 = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
					frame.setIconImage(icon.getImage());
					frame.setTitle("poker application");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public main() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 312);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
		Deck deck = new Deck();
		Pot pot = new Pot();
		Action enter = new Action();
		Released nonenter = new Released();
		BetAction space = new BetAction();
		BetReleased nonspace = new BetReleased();
		CallAction c = new CallAction();
		CallReleased nonc = new CallReleased();
		Scanner myReader;
		try {
			myReader = new Scanner(file);
			while (myReader.hasNextLine()) {
		        data = Integer.parseInt(myReader.nextLine());
		        System.out.println(data);
		      }
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	      
		player me = new player("Snake Eye", data);
		player p = new player("Jeff", 1000);
		deck.load();
		
	//	for(int i =0;i<5;i++) {
	//		System.out.println(me.showCardRank(i)+ " of ");
		//	System.out.println(me.showCardSuit(i));
	//	}
		//me.clearHand();
		//for(int i =0;i<5;i++) {
//			System.out.println(me.showCardRank(i)+ " of ");
	//		System.out.println(me.showCardSuit(i));
	//	}
		System.out.println("pot $"+pot.getMoney());
		System.out.println("me $"+me.getMoney());
		
		Bet(me, pot, 10);
		
		System.out.println("pot $"+pot.getMoney());
		System.out.println("me $"+me.getMoney());
		
		contentPane.getInputMap().put(KeyStroke.getKeyStroke("ENTER"),"enter");
		contentPane.getActionMap().put("enter", enter);
		contentPane.getInputMap().put(KeyStroke.getKeyStroke("released ENTER"),"nonenter");
		contentPane.getActionMap().put("nonenter", nonenter);
		
		contentPane.getInputMap().put(KeyStroke.getKeyStroke("B"),"b");
		contentPane.getActionMap().put("b", space);
		contentPane.getInputMap().put(KeyStroke.getKeyStroke("released B"),"nonspace");
		contentPane.getActionMap().put("nonspace", nonspace);
		
		contentPane.getInputMap().put(KeyStroke.getKeyStroke("C"),"c");
		contentPane.getActionMap().put("c", c);
		contentPane.getInputMap().put(KeyStroke.getKeyStroke("released C"),"nonc");
		contentPane.getActionMap().put("nonc", nonc);
		
		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 204, 82, 49);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(102, 204, 82, 49);
		contentPane.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(194, 204, 82, 49);
		contentPane.add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(286, 204, 82, 49);
		contentPane.add(textArea_3);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setBounds(378, 204, 82, 49);
		contentPane.add(textArea_4);
		
		JLabel label = new JLabel(" ");
		label.setBounds(10, 57, 45, 13);
		contentPane.add(label);
		
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setBounds(10, 122, 82, 55);
		
		
		JTextArea textArea_5_1 = new JTextArea();
		textArea_5_1.setBounds(102, 122, 82, 55);
		
		
		JTextArea textArea_5_2 = new JTextArea();
		textArea_5_2.setBounds(194, 122, 82, 55);
		
		
		JTextArea textArea_5_3 = new JTextArea();
		textArea_5_3.setBounds(286, 122, 82, 55);
		
		
		JTextArea textArea_5_4 = new JTextArea();
		textArea_5_4.setBounds(378, 122, 82, 55);
		
		JLabel info = new JLabel(" ");
		info.setForeground(Color.RED);
		info.setBounds(88, 95, 313, 21);
		contentPane.add(info);
		
		
		JButton btnNewButton_1 = new JButton("Confirm");
		btnNewButton_1.setBackground(new Color(255, 255, 0));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if (ended==false) {
			if(phase ==0) {
				Deal(deck, me);
				setTextArea(me,textArea,0);
				setTextArea(me,textArea_1,1);
				setTextArea(me,textArea_2,2);
				setTextArea(me,textArea_3,3);
				setTextArea(me,textArea_4,4);
				label.setText(Integer.toString(deck.cardsleft()));
				
				Deal(deck, p);
				
				setTextArea(p,textArea_5,0);
				setTextArea(p,textArea_5_1,1);
				setTextArea(p,textArea_5_2,2);
				setTextArea(p,textArea_5_3,3);
				setTextArea(p,textArea_5_4,4);
				label.setText(Integer.toString(deck.cardsleft()));
				info.setText("Type bet number in white box and select 'Bet'");
				phase=1;
			}else if(p.hasLastCard()) {
				info.setText("Type bet number in white box and select 'Bet'");
				phase=1;
			}
			}
				
				
			}
		});
		btnNewButton_1.setBounds(353, 95, 107, 21);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(378, 54, 82, 19);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel balance = new JLabel("$"+Integer.toString(me.getMoney()));
		balance.setBounds(378, 10, 82, 13);
		contentPane.add(balance);
		
		JLabel balance2 = new JLabel(Integer.toString(p.getMoney()));
		balance2.setBounds(10, 10, 85, 13);
		contentPane.add(balance2);
			 
		
		JLabel thepot = new JLabel("$"+Integer.toString(pot.getMoney()));
		thepot.setForeground(new Color(0, 0, 205));
		thepot.setFont(new Font("Tahoma", Font.PLAIN, 15));
		thepot.setBounds(194, 54, 82, 28);
		contentPane.add(thepot);
		
	
		
		JButton bet = new JButton("bet");
		bet.setBackground(new Color(0, 191, 255));
		bet.setForeground(new Color(0, 0, 0));
		bet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(ended==false) {	
				
				try {
					BetOverride(p, pot,p.autoBet());
					Bet(me,pot,Integer.valueOf(textField.getText()));
					
					info.setText("Select 'Confirm' to end turn");
				}catch(Exception e1) {
					System.out.println(e1);
					Bet(me,pot,Integer.valueOf(1));
					info.setText("Select 'Confirm' to end turn");
				}
				
				balance.setText("$" + Integer.toString(me.getMoney()));
				
				
				}
				int num = 0 + (int)(Math.random() * 4);
				
				
				Switch(deck, p, num);
				
				balance2.setText("$" + Integer.toString(p.getMoney()));
				thepot.setText("$"+Integer.toString(pot.getMoney()));
			}
		});
		bet.setBounds(375, 72, 85, 21);
		contentPane.add(bet);
		
		JButton btnNewButton = new JButton("Withdraw");
		btnNewButton.setBackground(new Color(230, 230, 250));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(phase==2) {
				Switch(deck, me,0);
				setTextArea(me,textArea,0);
				//me.removeCard(0);
				label.setText(Integer.toString(deck.cardsleft()));
				phase=1;
				}else {
					info.setText("Cannot 'Withdraw' until cards delt");
				}
			}
		});
		btnNewButton.setBounds(10, 183, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Withdraw");
		btnNewButton_2.setBackground(new Color(230, 230, 250));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(phase==2) {
				Switch(deck, me,1);
				setTextArea(me,textArea_1,1);
				//.removeCard(1);
				label.setText(Integer.toString(deck.cardsleft()));
				phase=1;
				}
			}
		});
		btnNewButton_2.setBounds(102, 183, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Withdraw");
		btnNewButton_3.setBackground(new Color(230, 230, 250));
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(phase==2) {
				Switch(deck, me,2);
				setTextArea(me,textArea_2,2);
				//me.removeCard(2);
				label.setText(Integer.toString(deck.cardsleft()));
				phase=1;
				}
			}
		});
		btnNewButton_3.setBounds(194, 183, 82, 21);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Withdraw");
		btnNewButton_4.setBackground(new Color(230, 230, 250));
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(phase==2) {
				Switch(deck, me,3);
				setTextArea(me,textArea_3,3);
				//me.removeCard(3);
				label.setText(Integer.toString(deck.cardsleft()));
				
				
				phase=1;
				}
			}
		});
		btnNewButton_4.setBounds(286, 183, 82, 21);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Withdraw");
		btnNewButton_5.setBackground(new Color(230, 230, 250));
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(phase==2) {
				Switch(deck, me,4);
				setTextArea(me,textArea_4,4);
				//me.removeCard(4);
				label.setText(Integer.toString(deck.cardsleft()));
				phase=1;
				}
			}
		});
		btnNewButton_5.setBounds(378, 183, 85, 21);
		contentPane.add(btnNewButton_5);
		
		
		
		
		JButton btnNewButton_6 = new JButton("Call");
		btnNewButton_6.setBackground(new Color(60, 179, 113));
		btnNewButton_6.setForeground(new Color(240, 248, 255));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(p.hasLastCard()) {
				contentPane.add(textArea_5);
				contentPane.add(textArea_5_1);
				contentPane.add(textArea_5_2);contentPane.add(textArea_5_3);
				contentPane.add(textArea_5_4);
				contentPane.updateUI();
				setTextArea(p, textArea_5, 0);
				setTextArea(p, textArea_5_1, 1);
				setTextArea(p, textArea_5_2, 2);
				setTextArea(p, textArea_5_3, 3);
				setTextArea(p, textArea_5_4, 4);
				phase=3;
				if(ended==false)
					info.setText("you: "+me.handType()+", AI: "+ p.handType());
				if(HighCard==true) {
					info.setText("High Card");
				}
					deterWinner(pot, me, p);
				ended= true;
				balance.setText(Integer.toString(me.getMoney()));
				thepot.setText(Integer.toString(pot.getMoney()));
				balance2.setText(Integer.toString(p.getMoney()));
				try {
				      FileWriter myWriter = new FileWriter("balance");
				      myWriter.write(Integer.toString(me.getMoney()));
				      myWriter.close();
				}catch(Exception e1) {
					System.out.println(e1);
				}
				
				}
			}
		});
		btnNewButton_6.setBounds(10, 72, 85, 21);
		contentPane.add(btnNewButton_6);
		
		
		
			
		info.setText("Select 'Confirm' to enter the Dealing Phase");
		
		JButton btnNewButton_7 = new JButton("Fold");
		btnNewButton_7.setBackground(new Color(220, 20, 60));
		btnNewButton_7.setForeground(new Color(240, 248, 255));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				phase=3;
				info.setText("not in game");
				ended= true;
			}
		});
		btnNewButton_7.setBounds(10, 95, 85, 21);
		contentPane.add(btnNewButton_7);
		
		JLabel lblNewLabel = new JLabel("(select 'Withdraw' when all cards have been delt)");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblNewLabel.setBounds(102, 4, 253, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_8 = new JButton("New Game");
		btnNewButton_8.setForeground(new Color(175, 238, 238));
		btnNewButton_8.setBackground(new Color(32, 178, 170));
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				me.resetIndex();
				p.resetIndex();
				p.clearHand();
				p.resetMoney();
				me.clearHand();
				pot.setMoney(0);
			
				
				thepot.setText(Integer.toString(pot.getMoney()));
				balance2.setText(Integer.toString(p.getMoney()));
				
				setTextArea(me, textArea, 0);
				setTextArea(me, textArea_1, 1);
				setTextArea(me, textArea_2, 2);
				setTextArea(me, textArea_3, 3);
				setTextArea(me, textArea_4, 4);
				
				contentPane.remove(textArea_5);
				contentPane.remove(textArea_5_1);
				contentPane.remove(textArea_5_2);contentPane.remove(textArea_5_3);
				contentPane.remove(textArea_5_4);
				
				
				contentPane.updateUI();
				phase=0;
				ended=false;
				
				
			}
		});
		btnNewButton_8.setBounds(0, 254, 112, 21);
		contentPane.add(btnNewButton_8);
		
		JLabel lblNewLabel_1 = new JLabel("Me");
		lblNewLabel_1.setBounds(378, 31, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("AI");
		lblNewLabel_2.setBounds(10, 31, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		Timer timer = new Timer(1, new ActionListener() {
	        public void actionPerformed(ActionEvent a) {
	        	if(pressed==true) {
	        		if (ended==false) {
	        			if(phase ==0) {
	        				Deal(deck, me);
	        				setTextArea(me,textArea,0);
	        				setTextArea(me,textArea_1,1);
	        				setTextArea(me,textArea_2,2);
	        				setTextArea(me,textArea_3,3);
	        				setTextArea(me,textArea_4,4);
	        				label.setText(Integer.toString(deck.cardsleft()));
	        				
	        				Deal(deck, p);
	        				
	        				setTextArea(p,textArea_5,0);
	        				setTextArea(p,textArea_5_1,1);
	        				setTextArea(p,textArea_5_2,2);
	        				setTextArea(p,textArea_5_3,3);
	        				setTextArea(p,textArea_5_4,4);
	        				label.setText(Integer.toString(deck.cardsleft()));
	        				info.setText("Type bet number in white box and select 'Bet'");
	        				phase=1;
	        			}else if(p.hasLastCard()) {
	        				info.setText("Type bet number in white box and select 'Bet'");
	        				phase=1;
	        			}
	        			}
	        		
	        	
	        	
	        	
	        	
		
	        }
	        	if(Betpressed==true) {
	        		if(ended==false) {	
	    				
	    				try {
	    					BetOverride(p, pot,p.autoBet());
	    					Bet(me,pot,Integer.valueOf(textField.getText()));
	    					
	    					info.setText("Select 'Confirm' to end turn");
	    				}catch(Exception e1) {
	    					System.out.println(e1);
	    					Bet(me,pot,Integer.valueOf(1));
	    					info.setText("Select 'Confirm' to end turn");
	    				}
	    				
	    				balance.setText("$" + Integer.toString(me.getMoney()));
	    				
	    				
	    				}
	    				int num = 0 + (int)(Math.random() * 4);
	    				
	    				
	    				Switch(deck, p, num);
	    				
	    				balance2.setText("$" + Integer.toString(p.getMoney()));
	    				thepot.setText("$"+Integer.toString(pot.getMoney()));
	        	}
	        	if(Callpressed==true) {
	        		if(p.hasLastCard()) {
	    				contentPane.add(textArea_5);
	    				contentPane.add(textArea_5_1);
	    				contentPane.add(textArea_5_2);contentPane.add(textArea_5_3);
	    				contentPane.add(textArea_5_4);
	    				contentPane.updateUI();
	    				setTextArea(p, textArea_5, 0);
	    				setTextArea(p, textArea_5_1, 1);
	    				setTextArea(p, textArea_5_2, 2);
	    				setTextArea(p, textArea_5_3, 3);
	    				setTextArea(p, textArea_5_4, 4);
	    				phase=3;
	    				if(ended==false)
	    					info.setText("you: "+me.handType()+", AI: "+ p.handType());
	    				if(HighCard==true) {
	    					info.setText("High Card");
	    				}
	    					deterWinner(pot, me, p);
	    				ended= true;
	    				balance.setText(Integer.toString(me.getMoney()));
	    				thepot.setText(Integer.toString(pot.getMoney()));
	    				balance2.setText(Integer.toString(p.getMoney()));
	    				try {
	    				      FileWriter myWriter = new FileWriter("balance");
	    				      myWriter.write(Integer.toString(me.getMoney()));
	    				      myWriter.close();
	    				}catch(Exception e1) {
	    					System.out.println(e1);
	    				}
	    				
	    				}
	        	}
	        	}
		});timer.start();
		
			
		
		
	}
	private static void Deal(Deck d, player p) {
		
		if(d.cardsleft()!=0) {
			p.addCard(d.getCard());
		}else {d.load();}
		
	}
	private static void Switch(Deck d, player p, int index) {
		if(d.cardsleft()!=0) {
			p.setCard(d.getCard(),index);
		}else {d.load();}
		
	}
	private static void Bet(player p, Pot o, int amount) {
		setBetting(amount);
			if(phase==1) {
			
				p.setMoney(p.getMoney()-amount);
				o.setMoney(o.getMoney()+amount);
				if(p.hasLastCard()) {
					phase=2;
				}else {
					phase=0;
				
				}
			
			
			}
		
	
		
	}
	private static void BetOverride(player p, Pot o, int amount) {
		if(phase==1) {
		
			p.setMoney(p.getMoney()-amount);
			o.setMoney(o.getMoney()+amount);
		
		}
	}
	private static void ForkitOver(Pot o, player p) {
		p.setMoney(p.getMoney()+o.getMoney());
		o.setMoney(0);
	}
	private static void setTextArea(player p, JTextArea t, int i) {
		if(p.showCardRank(i).equals("empty")) {
			t.setText("");
		}else
		t.setText(p.showCardRank(i)+" of \n"+p.showCardSuit(i));
	}
	
	private static void deterWinner(Pot o, player a, player b) {
		HighCard = false;
		points.add(a.getPoints());
		points.add(b.getPoints());
		if(a.getPoints()>b.getPoints()) {
			ForkitOver(o,a);
		}else if(b.getPoints()>a.getPoints()) {
			ForkitOver(o,b);
		}
		
		if(a.getPoints()==b.getPoints()) {
			HighCard = true;
			if(a.maxRank()>b.maxRank()) {
				ForkitOver(o,a);
			}else if(b.maxRank()>a.maxRank()) {
				ForkitOver(o,b);
			}
		}
		
	}

	public static int getBetting() {
		return betting;
	}

	public static void setBetting(int betting) {
		main.betting = betting;
	}
	class Action extends AbstractAction{
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			pressed=true;
			//leftpressed=false;
		}
		
	}
	class Released extends AbstractAction{

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		pressed=false;
		//leftpressed=false;
	}

	}
class BetAction extends AbstractAction{
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Betpressed=true;
			//leftpressed=false;
		}
		
	}
	class BetReleased extends AbstractAction{

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Betpressed=false;
		//leftpressed=false;
	}

	}
class CallAction extends AbstractAction{
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Callpressed=true;
			//leftpressed=false;
		}
		
	}
	class CallReleased extends AbstractAction{

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Callpressed=false;
		//leftpressed=false;
	}

	}
}

