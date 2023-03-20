package Week12_HW;

public class Card {
	private String suit;
	private String rank;
	
	// Ư�� ���� ���ڸ� ������ ī�带 ����� ������
	public Card(String suit, String rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	// ī���� ����� ��ȯ
	public String getSuit() {
		return suit;
	}
	
	// ī���� ���ڸ� ��ȯ
	public String getRank() {
		return rank;
	}
	
	// ī�带 ����� �� �̿�
	public String toString() {
		return getSuit() + "_" + getRank();
	}
}
