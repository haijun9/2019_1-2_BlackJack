package Week12_HW;

import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {
	private String suits[] = {"Spade", "Heart", "Diamond", "Club"};
	private String ranks[] = {"A", "2", "3", "4", "5", "6", "7", "8", "9" ,"10", "K","Q", "J"};
	private ArrayList<Card> deck;
	
	// ī�� 52���� ������ �ִ� ī�嵦�� ����� ������
	public CardDeck() {
		deck = new ArrayList<Card>();
		for(int i=0; i<4; i++) {
			for(int j=0; j<13; j++) {
				Card card = new Card(suits[i],ranks[j]);
				deck.add(card);
			}
		}
	}

	// ���� �տ� �ִ� ī�带 �̾Ƽ� ��ȯ
	public Card popCard() {		
		deck.remove(0);
		return deck.get(0);
	}
	
	// ���� ���� ī�� ���� ��ȯ
	public int getSize() {
		return deck.size();
	}
	
	// ���� ������
	public void shuffle() {
		Collections.shuffle(deck);
	}
}
