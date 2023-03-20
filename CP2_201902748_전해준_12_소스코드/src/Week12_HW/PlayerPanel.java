package Week12_HW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;

public class PlayerPanel extends JPanel {
	private ImagePanel imagepanel;
	private ImagePanel[] panels;
	private String[] Address;
	private int number;
	
	public PlayerPanel() {
		setSize(400, 70);
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		Address = new String[8];
		panels = new ImagePanel[8];
		imagepanel = new ImagePanel();
		for(int i=0; i<8; i++) {
			panels[i] = imagepanel;
		}
		number = 0;
		setVisible(true);
	}

	public void ShowCard(String address) {
		Address[number] = address;
		panels[number] = new ImagePanel("./images/cards/" + address + ".png");
		for(int i=0; i<8; i++) {
			add(panels[i]);	
		}
		number++;
	}
}
