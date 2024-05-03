package view;

import java.awt.Font;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dal.TrigramDal;
import model.TrigramObject;
import util.CenteredTableCellRenderer;
import util.R;

@SuppressWarnings("serial")
public class TrigramView extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private JTable table;

	DefaultTableModel model;
	
	private CenteredTableCellRenderer cellModel;
	
	private TrigramDal trigramDal;
	
	private List<TrigramObject> trigrams;
	
	private DecimalFormat df;
	
	public TrigramView(String fileName, int n) {
		df = new DecimalFormat("#.#####");
		this.trigramDal = TrigramDal.getInstance();
		cellModel = new CenteredTableCellRenderer();
		
		setBorder(new EmptyBorder(35, 10, 45, 10));
		setLayout(new GridLayout(1, 1, 5, 5));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setRowHeight(27);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "First Piece", "Second Piece", "Count(Word1, Word2, Word3)", "Count(Word1, Word2)", "Probability"
			}
		));
		
		model = (DefaultTableModel) table.getModel();
		
		scrollPane.setViewportView(table);
		
		initTable(fileName, n);
		
	}
	
	public void initTable(String fileName, int n) {
		resetTable();
		int index = 0;
		int order = 1;
		for(int i = 0;i < table.getColumnModel().getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(cellModel);
		}
		
		trigrams = getTrigramList(fileName);
		
		for(TrigramObject trigram : trigrams) {
			Object[] row = {order ,
					trigram.getTwoWord(), 
					trigram.getThreeWord(),
					trigram.getFrequency(),
					trigram.getBigramFrequency(), 
					df.format(trigram.getProbability())};
			model.addRow(row);
			index++;
			order++;
			if(index == n) {
				break;
			}
		}
	}
	
	private void resetTable() {
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
	}
	
	private List<TrigramObject> getTrigramList(String fileName){
		
		if(fileName.equals(R.fileName1)) {
			return trigramDal.getTrigramList(R.fileName1);
		}
		else if(fileName.equals(R.fileName2)) {
			return trigramDal.getTrigramList(R.fileName2);
		}
		else if(fileName.equals(R.fileName3)) {
			return trigramDal.getTrigramList(R.fileName3);
		}
		else if(fileName.equals(R.fileName4)) {
			return trigramDal.getTrigramList(R.fileName4);
		}
		else {
			return trigramDal.getTrigramList(R.fileName5);
		}
	}

}
