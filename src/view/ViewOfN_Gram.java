package view;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import util.NumberFormatController;
import util.R;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class ViewOfN_Gram extends JPanel {
	
	private JPanel firstTab;
	private JPanel secondTab;
	private JPanel thirdTab;
	
	private JPanel unigramHolder;
	private JPanel actionBarOfFirstTab;
	private JTextField textFieldActionBarOfFirstTab;
	private JLabel labelActionBarOfFirstTab;
	private JButton applyBtnOfFirstTab;
	UnigramView unigramView;
	
	private JPanel bigramHolder;
	private JPanel actionBarOfSecondTab;
	private JTextField textFieldActionBarOfSecondTab;
	private JLabel labelActionBarOfSecondTab;
	private JButton applyBtnOfSecondTab;
	BigramView bigramView;
	
	private JPanel trigramHolder;
	private JPanel actionBarOfThirdTab;
	private JTextField textFieldActionBarOfThirdTab;
	private JLabel labelActionBarOfThirdTab;
	private JButton applyBtnOfThirdTab;
	TrigramView trigramView;

	/**
	 * Create the panel.
	 */
	
	long startTime, endTime;
	
	public ViewOfN_Gram(String fileName) {

		startTime = System.nanoTime();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 5, 1023, 748);
		add(tabbedPane);
		
		firstTab = new JPanel();
		tabbedPane.addTab("Unigram", null, firstTab, null);
		firstTab.setLayout(null);
		actionBarOfFirstTab = new JPanel();
		actionBarOfFirstTab.setBounds(10, 10, 998, 46);
		firstTab.add(actionBarOfFirstTab);
		labelActionBarOfFirstTab = new JLabel("Search for N items with highest frequency : ");
		labelActionBarOfFirstTab.setFont(new Font("MV Boli", Font.BOLD, 18));
		actionBarOfFirstTab.add(labelActionBarOfFirstTab);
		textFieldActionBarOfFirstTab = new JTextField();
		textFieldActionBarOfFirstTab.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldActionBarOfFirstTab.setText("20");
		textFieldActionBarOfFirstTab.setFont(new Font("MV Boli", Font.BOLD, 18));
		textFieldActionBarOfFirstTab.setColumns(5);
		actionBarOfFirstTab.add(textFieldActionBarOfFirstTab);
		unigramView = new UnigramView(fileName, R.DEFAULT_TABLE_ELEMENTS);
		unigramView.setBounds(0, 0, 1018, 721);
		unigramHolder = new JPanel();
		unigramHolder.setBounds(10, 66, 998, 645);
		unigramHolder.setLayout(new GridLayout(1, 1, 5, 5));
		unigramHolder.add(unigramView);
		firstTab.add(unigramHolder);
		applyBtnOfFirstTab = new JButton("Apply");
		applyBtnOfFirstTab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(NumberFormatController.isNumber(getN(1))) {
					unigramView.initTable(fileName, Integer.valueOf(getN(1)));
				}
				else {
					JOptionPane.showMessageDialog(null, "Please enter just a number!", "ERROR!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		applyBtnOfFirstTab.setFocusable(false);
		applyBtnOfFirstTab.setFont(new Font("MV Boli", Font.BOLD, 18));
		actionBarOfFirstTab.add(applyBtnOfFirstTab);
		
		secondTab = new JPanel();
		tabbedPane.addTab("Bigram", null, secondTab, null);
		secondTab.setLayout(null);
		actionBarOfSecondTab = new JPanel();
		actionBarOfSecondTab.setBounds(10, 10, 998, 46);
		secondTab.add(actionBarOfSecondTab);
		labelActionBarOfSecondTab = new JLabel("Search for N items with highest frequency : ");
		labelActionBarOfSecondTab.setFont(new Font("MV Boli", Font.BOLD, 18));
		actionBarOfSecondTab.add(labelActionBarOfSecondTab);
		textFieldActionBarOfSecondTab = new JTextField();
		textFieldActionBarOfSecondTab.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldActionBarOfSecondTab.setText("20");
		textFieldActionBarOfSecondTab.setFont(new Font("MV Boli", Font.BOLD, 18));
		textFieldActionBarOfSecondTab.setColumns(5);
		actionBarOfSecondTab.add(textFieldActionBarOfSecondTab);
		bigramView = new BigramView(fileName, R.DEFAULT_TABLE_ELEMENTS);
		bigramView.setBounds(0, 0, 1018, 721);
		bigramHolder = new JPanel();
		bigramHolder.setBounds(10, 66, 998, 645);
		bigramHolder.setLayout(new GridLayout(1, 1, 5, 5));
		bigramHolder.add(bigramView);
		secondTab.add(bigramHolder);
		applyBtnOfSecondTab = new JButton("Apply");
		applyBtnOfSecondTab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(NumberFormatController.isNumber(getN(2))) {
					bigramView.initTable(fileName, Integer.valueOf(getN(2)));
				}
				else {
					JOptionPane.showMessageDialog(null, "Please enter just a number!", "ERROR!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		applyBtnOfSecondTab.setFocusable(false);
		applyBtnOfSecondTab.setFont(new Font("MV Boli", Font.BOLD, 18));
		actionBarOfSecondTab.add(applyBtnOfSecondTab);
		
		
		thirdTab = new JPanel();
		tabbedPane.addTab("Trigram", null, thirdTab, null);
		thirdTab.setLayout(null);
		actionBarOfThirdTab = new JPanel();
		actionBarOfThirdTab.setBounds(10, 10, 998, 46);
		thirdTab.add(actionBarOfThirdTab);
		labelActionBarOfThirdTab = new JLabel("Search for N items with highest frequency : ");
		labelActionBarOfThirdTab.setFont(new Font("MV Boli", Font.BOLD, 18));
		actionBarOfThirdTab.add(labelActionBarOfThirdTab);
		textFieldActionBarOfThirdTab = new JTextField();
		textFieldActionBarOfThirdTab.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldActionBarOfThirdTab.setText("20");
		textFieldActionBarOfThirdTab.setFont(new Font("MV Boli", Font.BOLD, 18));
		textFieldActionBarOfThirdTab.setColumns(5);
		actionBarOfThirdTab.add(textFieldActionBarOfThirdTab);
		trigramView = new TrigramView(fileName, R.DEFAULT_TABLE_ELEMENTS);
		trigramView.setBounds(0, 0, 1018, 721);
		trigramHolder = new JPanel();
		trigramHolder.setBounds(10, 66, 998, 645);
		trigramHolder.setLayout(new GridLayout(1, 1, 5, 5));
		trigramHolder.add(trigramView);
		thirdTab.add(trigramHolder);
		applyBtnOfThirdTab = new JButton("Apply");
		applyBtnOfThirdTab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(NumberFormatController.isNumber(getN(3))) {
					trigramView.initTable(fileName, Integer.valueOf(getN(3)));
				}
				else {
					JOptionPane.showMessageDialog(null, "Please enter just a number!", "ERROR!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		applyBtnOfThirdTab.setFocusable(false);
		applyBtnOfThirdTab.setFont(new Font("MV Boli", Font.BOLD, 18));
		actionBarOfThirdTab.add(applyBtnOfThirdTab);
		
		
		setLayout(null);
		setVisible(true);

		endTime = System.nanoTime();
		
		System.out.println(fileName + " : " + String.valueOf((double)(endTime-startTime) / 1000000000) + "s.");
	}
	
	private String getN(int source) {
		if(source == 1) {
			return textFieldActionBarOfFirstTab.getText();
		}
		else if(source == 2) {
			return textFieldActionBarOfSecondTab.getText();
		}
		else {
			return textFieldActionBarOfThirdTab.getText();
		}
		
	}
}
