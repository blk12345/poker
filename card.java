package poker;

public class card {
	private String suit ="";
	private String rank ="";
	private int ranknum = 0;
	
	public void initiate() {
	switch(rank) {
	case "Ace":
		ranknum=13;
		break;
	case"2":
		ranknum=1;
		break;
		
	case"3":
		ranknum=2;
		break;
	case"4":
		ranknum=3;
		break;
	case"5":
		ranknum=4;
		break;
	case"6":
		ranknum=5;
		break;
	case"7":
		ranknum=6;
		break;
	case"8":
		ranknum=7;
		break;
	case"9":
		ranknum=8;
		break;
	case"10":
		ranknum=9;
	break;
	case"King":
		ranknum=12;
		break;
	case"Queen":
		ranknum=11;
		break;
	case"Jack":
		ranknum=10;
		break;
	}}
	
	public void CheckVar() {
		System.out.println("suit  = " + suit);
		System.out.println("rank = "+ rank);
	}
	
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
		initiate();
	}
	public int getRanknum() {
		return ranknum;
	}
	public void setRanknum(int ranknum) {
		this.ranknum = ranknum;
	}
	
	
	
	
}


