package Week12_HW;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ImagePanel extends JPanel {
	private Image img;
	
	public ImagePanel() { }
	
	public ImagePanel(String img) {
		// 이미지 경로를 넣으면 이미지 Panel을 생성해주는 생성자
		this(new ImageIcon(img).getImage());
	}
		
	public ImagePanel(Image img) {
		this.img = img;
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}

	public void setImage(String img) {
		// 이미지를 변경해주는 메소드
		this.img = new ImageIcon(img).getImage();
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}
