package cs113.miracosta.edu;
/**
 * 
 * @author Joshua Kang
 * @version 1.0
 * Program Name: Code 
 * Program Description: An instance of a Code keeps track of a morse code, and it's respective english letter.
 *
 */
public class Code {
	private String code; 
	private String letter;
	
	public Code(String code, String letter)
	{
		this.code = code;
		this.letter = letter;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	@Override
	public String toString() {
		return "Code : code = " + code + " : letter = " + letter;
	}
	
	

}
