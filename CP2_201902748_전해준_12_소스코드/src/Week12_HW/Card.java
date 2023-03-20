package Week12_HW;

public class Card {
	private String suit;
	private String rank;
	
	// 특정 모양과 숫자를 가지는 카드를 만드는 생성자
	public Card(String suit, String rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	// 카드의 모양을 반환
	public String getSuit() {
		return suit;
	}
	
	// 카드의 숫자를 반환
	public String getRank() {
		return rank;
	}
	
	// 카드를 출력할 때 이용
	public String toString() {
		return getSuit() + "_" + getRank();
	}
}
