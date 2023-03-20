package Week12_HW;

import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {
	private String suits[] = {"Spade", "Heart", "Diamond", "Club"};
	private String ranks[] = {"A", "2", "3", "4", "5", "6", "7", "8", "9" ,"10", "K","Q", "J"};
	private ArrayList<Card> deck;
	
	// 카드 52장을 가지고 있는 카드덱을 만드는 생성자
	public CardDeck() {
		deck = new ArrayList<Card>();
		for(int i=0; i<4; i++) {
			for(int j=0; j<13; j++) {
				Card card = new Card(suits[i],ranks[j]);
				deck.add(card);
			}
		}
	}

	// 제일 앞에 있는 카드를 뽑아서 반환
	public Card popCard() {		
		deck.remove(0);
		return deck.get(0);
	}
	
	// 덱에 남은 카드 수를 반환
	public int getSize() {
		return deck.size();
	}
	
	// 덱을 셔플함
	public void shuffle() {
		Collections.shuffle(deck);
	}
}
