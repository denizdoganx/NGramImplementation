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

import algorithm.Bigram;
import dal.UnigramDal;
import model.UnigramObject;
import util.CenteredTableCellRenderer;
import util.R;

@SuppressWarnings("serial")
public class UnigramView extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private JTable table;

	DefaultTableModel model;
	
	private CenteredTableCellRenderer cellModel;
	
	private UnigramDal unigramDal;
	
	private List<UnigramObject> unigrams;
	
	private DecimalFormat df;
	
	public UnigramView(String fileName, int n) {
		
		df = new DecimalFormat("#.#####");
		
		this.unigramDal = UnigramDal.getInstance();
		
		cellModel = new CenteredTableCellRenderer();
		
		
		setBorder(new EmptyBorder(35, 55, 45, 55));
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
				"ID", "Word", "Frequency", "Probability"
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
		
		unigrams = getUnigramList(fileName);
		Bigram.getInstance().updateListOfUnigrams(unigrams);
		for(UnigramObject unigram : unigrams) {
			Object[] row = {order ,unigram.getWord(), unigram.getFrequency(), df.format(unigram.getProbability())};
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
	
	private List<UnigramObject> getUnigramList(String fileName){
		
		if(fileName.equals(R.fileName1)) {
			return unigramDal.getUnigramList(R.fileName1);
		}
		else if(fileName.equals(R.fileName2)) {
			return unigramDal.getUnigramList(R.fileName2);
		}
		else if(fileName.equals(R.fileName3)) {
			return unigramDal.getUnigramList(R.fileName3);
		}
		else if(fileName.equals(R.fileName4)) {
			return unigramDal.getUnigramList(R.fileName4);
		}
		else {
			return unigramDal.getUnigramList(R.fileName5);
		}
	}
}
