package Week12_HW;

import java.util.ArrayList;
import java.util.Iterator;

public class Player {
	private ArrayList<Card> hand;
	
	// ������ ��(hand)�� ������ �÷��̾� ������
	public Player() {
		hand = new ArrayList<Card>();
	}
		
	// �÷��̾��� �п� ī�带 �߰�
	public void hit(Card card) {
		hand.add(card);
	}
	
	// �÷��̾��� �� ������ ����Ͽ� ��ȯ
	public int getScore() {
		int score = 0;
		for(int i=0; i<hand.size(); i++) {
			switch(hand.get(i).getRank()) {
			case "A":
				if(score <= 10) {
					score += 11; break;
				} else {
					score += 1; break;
				}
			case "2": score += 2; break;
			case "3": score += 3; break;
			case "4": score += 4; break;
			case "5": score += 5; break;
			case "6": score += 6; break;
			case "7": score += 7; break;
			case "8": score += 8; break;
			case "9": score += 9; break;
			case "10": case "K" : case "Q" : case "J": score += 10; break;
			}
		}
		return score;
	}
	
	// ���� ������ 21�� ���� ��� true, �ƴ� ��� false
	public boolean isBust() {
		if(getScore() > 21) return true;
		return false;
	}
	
	// ���� ������ 21�� �� ��� true, �ƴ� ��� false
	public boolean isBlackJack() {
		if(getScore() == 21) return true;
		return false;
	}
}
