package poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;





public class player {
	public String name = "";
	public int initM = 0;
	private int money = 0;
	private int index =0;
	private int betting = 1;
	private int points =0;

	private  ArrayList<String> suits = new ArrayList<String>();
	private  ArrayList<String> ranks = new ArrayList<String>();
	
	private  ArrayList<String> things = new ArrayList<String>();
	private  ArrayList<String> things2 = new ArrayList<String>();
	
	private  ArrayList<Integer> ranknums = new ArrayList<Integer>();
	
	private  ArrayList<Integer> currentRanknums = new ArrayList<Integer>();
	private boolean changed = false;
	private card[] hand = new card[5];
	public player(String name,int initM) {
		this.name = name;
		this.initM=initM;
		setMoney(getMoney() + initM);
	}
	public void addCard(card o) {
		if(index<hand.length) {
			hand[index]= o;
			index++;
		}else {
			int count=0;
			for(int i=0;i<hand.length;i++) {
				if(hand[i]==null) {
					hand[i]=o;
					changed = true;
					
				}
				
			}
			if(changed==false) {
				hand[hand.length-1]=o;
			}
			
				
			
		}
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String showCardRank(int index) {
		card o = hand[index];
		String ret ="";
		if (o !=null){
			ret = o.getRank();
		}else{
			ret = "empty";
		}
		return 	ret;
				}
	public String showCardSuit(int index) {
		card o = hand[index];
		String ret ="";
		if (o !=null){
			ret = o.getSuit();
		}else{
			ret = "empty";
		}
		return 	ret;
	}
	public void clearHand() {
		for(int i=0;i<hand.length;i++) {
		hand[i]=null;
		}
		ranknums.removeAll(ranknums);
		currentRanknums.removeAll(currentRanknums);
		suits.removeAll(suits);
		ranks.removeAll(ranks);
		things.removeAll(things);
		things2.removeAll(things2);
	}
	public void removeCard(int index) {
		
	}
	public void setCard(card o, int index) {
		hand[index] = o;
		
	}
	public int HandLength() {
		
		return hand.length;
	}
	public boolean hasLastCard() {
		boolean is = false;
		if(hand[4]!=null) {
			is=true;
		}
	return is;
	}
	private void CountHand() {
		for(int i=0;i<hand.length;i++) {
		if(hand[i]!=null) {
			ranks.add(hand[i].getRank());
			suits.add(hand[i].getSuit());
		}
		
		}
		
		
		
	}
	public String whatSuit() {
		String SuitHand ="";
		
		for(int i=0;i<Deck.suits.length;i++) {
			int instances = Collections.frequency(suits, Deck.suits[i]);
			System.out.println(Deck.suits[i]+" "+ instances);
					switch(instances) {
			case 2:
				things.add("Pair");
				break;
			case 3:
				things.add("Three");
				break;
			case 4:
				things.add("Four");
				break;
				
			case 5: 
				things.add("Five");
				break;
			}
		}
		if(things.contains("Five")) {
			SuitHand = "Five";
		}else {
			if(things.contains("Four")) {
				SuitHand = "Four";
			}
		else {
				if(things.contains("Three")) {
					SuitHand = "Three";
				}
				else {
					if(things.contains("Pair")) {
						SuitHand="Pair";
					}
				}
			}
		}
		
		System.out.println(Arrays.deepToString(hand));
		return SuitHand;
	}
	public String whatRank() {
		
		String rankHand ="";
		
		for(int i=0;i<Deck.ranks.length;i++) {
			int instances = Collections.frequency(ranks, Deck.ranks[i]);
			
			switch(instances) {
			case 2:
				things2.add("Pair");
				break;
			case 3:
				things2.add("Three");
				break;
			case 4:
				things2.add("Four");
				break;
				
			case 5: 
				things2.add("Five");
				break;
			}
		}
		if(things2.contains("Five")) {
			rankHand = "Five";
		}else {
			if(things2.contains("Four")) {
				rankHand = "Four";
				points=8;
			}
		else {
				if(things2.contains("Three")) {
					rankHand = "Three";
					points=4;
				}
				else {
					if(things2.contains("Pair")) {
						rankHand="Pair";
						points=2;
					}
				}
			}
		}
		if(things2.contains("Three")&&things2.contains("Pair")) {
			rankHand="Full House";
			points=7;
		}else if(Collections.frequency(things2, "Pair")==2) {
			points =3;
		}
		return rankHand;
	}
	public String whatRoyalFlush() {
		String is="";
		if(isStraight()&&ranknums.contains(13)&&whatSuit().equals("Five")) {
			is="Royal Flush";
		}
		return is;
	}
	private boolean isStraight() {
		boolean is=false;
		int consecutives=0;
		for(int i=0;i<hand.length;i++) {
			ranknums.add(hand[i].getRanknum());
		}
		for(int i=0;i<hand.length;i++) {
			if(ranknums.contains(Collections.max(ranknums)-i)) {
				consecutives++;
			}
		}
		if(consecutives==hand.length) {
			is=true;
		}
		return is;
	}
	public String whatStraight() {
		String is="";
		if(isStraight()) {
			is="Straight";
		}
		return is;
	}
	public String whatFlush() {
		String is ="";
		if(isStraight()) {
			is = "Flush";
		}
		return is;
	}
	public String whatStraightFlush() {
		String is="";
		if(isStraight()&&whatSuit().equals("Five"))
		is="Straight Flush";
		return is;
	}
	public String handType() {
		CountHand();
		String s = "nothing";
		
		if(whatFlush()!="") {
			s = whatFlush();
			points=6;
		}
		if(whatRoyalFlush()!="") {
			s = whatRoyalFlush();
			points=10;
			
		}
		if(whatStraight()!="") {
			s = whatStraight();
			points=5;
		}
		if(whatRank()!="") {
			s = whatRank();
		}
		if(whatStraightFlush()!="") {
			s=whatStraightFlush();
			points=9;
		}
	
		return s;
	}
	public int getPoints() {
		return points;
	}
	public int maxRank() {
		return Collections.max(ranknums);
	}
	public void resetMoney() {
		money = initM;
	}
	public int autoBet() {
		
		for(int i=0;i<hand.length;i++) {
			if(hand[i]!=null) {
				currentRanknums.add(hand[i].getRanknum());
			}
		}
		int a = Collections.max(currentRanknums);
		
		
		
		int r = (int) (Math.random() * (5 - 0)) + 0;
		if(r==0) {
			betting= a*Collections.frequency(currentRanknums, a);
			betting +=(main.getBetting()/4);
		}else {
			betting =1;
		}
		System.out.println(r);
		return betting;
		
	}
	public void resetIndex() {
		index=0;
		
	}
}
