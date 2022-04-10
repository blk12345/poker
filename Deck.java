package poker;

import java.util.ArrayList;

public class Deck {

	private int num = 52;
	private int ranknum = 4;
	private int rand= 0;
	private card[] objects = new card[num];
	public static String[] ranks = {"Ace", "2", "3", "4","5","6","7","8","9","10","King","Queen","Jack"};
	public static String[] suits= {"hearts", "spades", "daimonds", "deuce"};
	private  ArrayList<card> deck = new ArrayList<card>();
	
	public void load() {
		for (int i=0;i<num;i++) {		
			card s = new card();
			objects[i]=s;
			}
			
			for (int a=0;a<ranknum;a++) {
				
				for(int i=0;i<=(num/ranknum)-1;i++) {
					objects[a+(ranknum*i)].setRank(ranks[i]);
				}
				for (int i =0; i<=(num/4-1);i++) {
					objects[(i*4)+a].setSuit(suits[a]);
					                               
				}
				}
			deck.removeAll(deck);
			for (int i=0;i<num;i++) {
				deck.add(objects[i]);
			}
			System.out.println(getCardRank(50));
			System.out.println(getCardSuit(50));
		
	}
	public Object getCardRank(int index) {
		return objects[index].getRank();
	}
	public Object getCardSuit(int index) {
		return objects[index].getSuit();
	}
	private int rand() {
		
		return rand = (int) (Math.random()*((deck.size()-0)));
	}
	public Object getCardSuit() {
		return objects[rand].getSuit();
	}
	public Object getCardRank() {
		return objects[rand].getRank();
	}
	

	
	public card getCard() {
		
			rand();
			
		
		card o = deck.get(rand);
		deck.remove(rand);
		return o;
	}
	public int cardsleft() {
		return deck.size();
	}
		
}
