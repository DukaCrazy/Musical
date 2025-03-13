package code1000.OOP;

public class Code9 {

	public static void main(String[] args) {
		MusicalNotes a = new MusicalNotes("g");
		
		System.out.println("Tone: " + a.getTone() + a.getNumber());
		
		for(var i : a.getTriadArray())
			System.out.println(i);

	}

}

class MusicalNotes {
	//private static final String[] notes = { "A", "B", "C", "D", "E", "F", "G" };//G10 A0 B2 C3 D5 E7 F#9
	private static final String[] notesAll = { "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#" };
	//T T s T T T s
	//0 2 4 5 7 9 11 
	private static final int[][] triad = { { 0, 2, 4 }, { 2, 5, 9 }, { 4, 7, 11 }, { 5, 9, 0 }, { 7, 11, 0 }, { 9, 0, 4 }, { 11, 2, 5 } };

	private String tone;
	private int number;

	public MusicalNotes(String tone) {
		this.tone = tone.toUpperCase();
		
		init(this.tone);
	}
	
	private void init (String tone) {
		
		switch(tone) {
		
		case "A" : {number = 0; break;}
		case "B" : {number = 2; break;}
		case "C" : {number = 3; break;}
		case "D" : {number = 5; break;}
		case "E" : {number = 7; break;}
		case "F" : {number = 8; break;}
		case "G" : {number = 10; break;}
		
		}
		
	}
	
	private String [] triadMethod(int number) {
		String [] triadMethod = new String [7];
		
		for(int i = 0; i < 7; i++) {
			
			int tonic = triad[i][0] + number;
			int third = triad[i][1] + number;
			int fifth = triad[i][2] + number;
			
			if(tonic >= 12)
				tonic -= 12;
			if(third >= 12)
				third -= 12;
			if(fifth >= 12)
				fifth -= 12;
			
			triadMethod[i] = notesAll[tonic] + " : " + notesAll[third]  + " : " + notesAll[fifth];
							
		}
		
		
		return triadMethod;
	}
	
	

	public int getNumber() {
		return number;
	}

	public String getTone() {
		return tone;
	}

	public String[] getTriadArray() {
		return  triadMethod(getNumber());
	}
	
}