package Week12_HW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlackJackFrame extends JFrame {
	private static Dealer dealer;
	private static Player player;
	private static CardDeck deck;
	private DealerPanel dealerpanel;
	private PlayerPanel playerpanel;
	private JPanel UIpanel;
	private JLabel text;
	private JButton hit;
	private JButton stand;
		
	public BlackJackFrame() {
		setSize(450, 320);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("BlackJack");
		setLayout(new GridLayout(3,1));
		
		dealer = new Dealer();
		player = new Player();
		deck = new CardDeck();
		dealerpanel = new DealerPanel();
		Border dealerborder = BorderFactory.createTitledBorder("Dealer");
		dealerpanel.setBorder(dealerborder);
		playerpanel = new PlayerPanel();
		Border playerborder = BorderFactory.createTitledBorder("Player");
		playerpanel.setBorder(playerborder);
		UIpanel = new JPanel();
		UIpanel.setSize(400, 70);
		
		deck.shuffle();
		for(int i=0; i<2; i++) {
			Object tmp = deck.popCard();
			String address = tmp.toString();
			playerpanel.ShowCard(address);
			player.hit((Card) tmp);
		}
		int i = 0;
		while(dealer.getScore() < 16) {
			Object tmp = deck.popCard();
			String address = tmp.toString();
			if(i==0) {dealerpanel.ShowCard(address);}
			else {dealerpanel.HideCard(address);}
			dealer.hit((Card) tmp);
			i++;
		}
		
		text = new JLabel("Dealer:??, Player:" + player.getScore());
		if(player.isBlackJack()) {
			text.setText("Dealer:" + dealer.getScore() + ", Player:" + player.getScore() + "  BlackJack!!");
			dealerpanel.ShowAll();
		}
		text.setSize(400, 70);
		hit = new JButton("Hit");
		hit.addActionListener(new HitAction());
		stand = new JButton("Stand");
		stand.addActionListener(new StandAction());
		UIpanel.add(text); UIpanel.add(hit); UIpanel.add(stand);
		
		this.add(dealerpanel); this.add(playerpanel); this.add(UIpanel);
		
		setVisible(true);
	}
	
	class HitAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == hit) {
				try{
					Object tmp = deck.popCard();
					String address = tmp.toString();
					playerpanel.ShowCard(address);
					player.hit((Card) tmp);
					text.setText("Dealer:??,Player:" + player.getScore());
					if(player.isBlackJack()) {
						text.setText("Dealer:" + dealer.getScore() + ", Player:" + player.getScore() + "  BlackJack!!");
						dealerpanel.ShowAll();
					}
					if(player.isBust()) {
						text.setText("Dealer:" + dealer.getScore() + ", Player:" + player.getScore() + "  Bust하셨습니다..");
						dealerpanel.ShowAll();
					}
				} catch (Exception x) {
					text.setText("더 이상 진행할 수 없습니다.");
				}
			}
		}
	}
	
	class StandAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == stand) {
				if(Math.abs(dealer.getScore()-21) <= Math.abs(player.getScore()-21)) {
					text.setText("Dealer:" + dealer.getScore() + ", Player:" + player.getScore() + " 딜러의 승리");
				} else {
					text.setText("Dealer:" + dealer.getScore() + ", Player:" + player.getScore() + " 플레이어의 승리");
				}
				dealerpanel.ShowAll();
			}
		}
	}
}