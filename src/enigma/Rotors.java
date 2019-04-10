package enigma;

public class Rotors {
	
	private Rotor A;
	private Rotor B;
	private Rotor C;
	
	
	
	
	public Rotors(char A, char B, char C, String type) {
		this.A = new Rotor(A, type);
		this.B = new Rotor(B, type);
		this.C = new Rotor(C, type);
	}
	
	public void setRotorPositions(int A, int B, int C) {
		this.A.setWheel(A);
		this.B.setWheel(B);
		this.C.setWheel(C);
	}
	
	public String encryptMessage(String message) {
		String character;
		String encrypted = "";
		int rotorPosition;
		char temp;
		
		for (int x = 0; x < message.length(); ++x) {
			character = String.valueOf(message.charAt(x)).toUpperCase();
			
			if (character.equals(" ")) {
				character = "X";
			}
			
			rotorPosition = ((int) message.toUpperCase().charAt(x)) - 65;
			temp = A.replace(rotorPosition);
			
			rotorPosition = ((int) temp) - 65;
			temp = B.replace(rotorPosition);
			
			rotorPosition = ((int) temp) - 65;
			temp = C.replace(rotorPosition);
			
			rotorPosition = ((int) temp) - 65;
			temp = C.replace(rotorPosition);
			
			rotorPosition = ((int) temp) - 65;
			temp = B.replace(rotorPosition);
			
			rotorPosition = ((int) temp) - 65;
			temp = A.replace(rotorPosition);
			
			encrypted = encrypted + temp;
			A.moveWheel();
			
			if ((x/26) >= 1 && (x&26) == 0) {
				B.moveWheel();
			}
		}
		return encrypted;
	}
}
