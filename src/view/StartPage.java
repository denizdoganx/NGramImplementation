package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.ImageResizer;
import util.R;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



@SuppressWarnings("serial")
public class StartPage extends JFrame {

	private JPanel contentPane;
	private JPanel fragmentPanel;
	private JButton btnNewButton_2;
	private JButton btnNewButton_4;
	private JButton btnNewButton_1;
	private JButton btnNewButton_3;
	private JButton btnNewButton;

	/**
	 * Create the frame.
	 */
	public StartPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 327, 753);
		contentPane.add(panel);
		panel.setLayout(null);
		
		ImageResizer.resizeImage(R.inputIconPath, R.outputIconPath, 307, 219);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(R.outputIconPath));
		
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(10, 10, 307, 199);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 219, 307, 524);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Select a .txt file");
		lblNewLabel_1.setFont(new Font("MV Boli", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);
		
		btnNewButton_2 = new JButton("BILIM IS BASINDA");
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartPage.this.fragmentPanel.removeAll();
				StartPage.this.fragmentPanel.revalidate();
				StartPage.this.fragmentPanel.add(new ViewOfN_Gram(R.fileName1));
				StartPage.this.fragmentPanel.repaint();
			}
		});
		btnNewButton_2.setFont(new Font("MV Boli", Font.BOLD, 20));
		panel_1.add(btnNewButton_2);
		
		btnNewButton_4 = new JButton("BOZKIRDA");
		btnNewButton_4.setFocusable(false);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartPage.this.fragmentPanel.removeAll();
				StartPage.this.fragmentPanel.revalidate();
				StartPage.this.fragmentPanel.add(new ViewOfN_Gram(R.fileName2));
				StartPage.this.fragmentPanel.repaint();
			}
		});
		btnNewButton_4.setFont(new Font("MV Boli", Font.BOLD, 20));
		panel_1.add(btnNewButton_4);
		
		btnNewButton_1 = new JButton("DEGISIM");
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartPage.this.fragmentPanel.removeAll();
				StartPage.this.fragmentPanel.revalidate();
				StartPage.this.fragmentPanel.add(new ViewOfN_Gram(R.fileName3));
				StartPage.this.fragmentPanel.repaint();
			}
		});
		btnNewButton_1.setFont(new Font("MV Boli", Font.BOLD, 20));
		panel_1.add(btnNewButton_1);
		
		btnNewButton_3 = new JButton("DENEMELER");
		btnNewButton_3.setFocusable(false);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartPage.this.fragmentPanel.removeAll();
				StartPage.this.fragmentPanel.revalidate();
				StartPage.this.fragmentPanel.add(new ViewOfN_Gram(R.fileName4));
				StartPage.this.fragmentPanel.repaint();
			}
		});
		btnNewButton_3.setFont(new Font("MV Boli", Font.BOLD, 20));
		panel_1.add(btnNewButton_3);
		
		btnNewButton = new JButton("grimms-fairy-tales_P1");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartPage.this.fragmentPanel.removeAll();
				StartPage.this.fragmentPanel.revalidate();
				StartPage.this.fragmentPanel.add(new ViewOfN_Gram(R.fileName5));
				StartPage.this.fragmentPanel.repaint();
			}
		});
		btnNewButton.setFont(new Font("MV Boli", Font.BOLD, 20));
		panel_1.add(btnNewButton);
		
		fragmentPanel = new JPanel();
		fragmentPanel.setBounds(348, 10, 1028, 753);
		fragmentPanel.setLayout(new GridLayout(1, 1, 5, 5));
		contentPane.add(fragmentPanel);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
}
