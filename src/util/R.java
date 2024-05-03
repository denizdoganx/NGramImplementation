package util;

import java.util.ArrayList;

public class R {
	
	public static final String fileName1 = "./Novel-Samples/BİLİM İŞ BAŞINDA.txt";
	
	public static final String fileName2 = "./Novel-Samples/BOZKIRDA.txt";
	
	public static final String fileName3 = "./Novel-Samples/DEĞİŞİM.txt";
	
	public static final String fileName4 = "./Novel-Samples/DENEMELER.txt";
	
	public static final String fileName5 = "./Novel-Samples/grimms-fairy-tales_P1.txt";
	
	public static final String inputIconPath = "./images/icon.png";
	
	public static final String outputIconPath = "./images/newicon.png";
	
	private static final String[] DELIMITERS = {
    	    "-", "+", " ", "\r\n", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "’", "'", "\"", "(", ")", "{", "}", "<", ">", "\\[", "\\]",
    	    ":", ",", "‒", "–", "—", "―", "…", "!", ".", "«", "»", "-", "‐", "?", "‘", "’", "“", "”", ";", "/", "⁄", "␠", "·", "&", "@", "*",
    	    "\\", "•", "^", "¤", "¢", "$", "€", "£", "¥", "₩", "₪", "†", "‡", "°", "¡", "¿", "¬", "#", "№", "%", "‰", "‱", "¶", "′", "§",
    	    "~", "¨", "_", "|", "¦", "⁂", "☞", "∴", "‽", "※", "'"
    	};
	
	private static ArrayList<String> delimiters;
	
	public static final int DEFAULT_TABLE_ELEMENTS = 20;
	
	public static ArrayList<String> getDelimiters(){
		
		if(delimiters == null) {
			delimiters = new ArrayList<>();
			for(String seperator : DELIMITERS) {
				delimiters.add(seperator);
			}
		}

		return delimiters;
	}
	
	
}
