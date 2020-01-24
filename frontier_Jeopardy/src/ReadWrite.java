
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadWrite {
	public String url;
	private String[] categories = {"Music", "Laws", "Names", "How Many", "Mathematics", "   Where was it Founded?"};
	File f;
	public ReadWrite(String yooareel) {
		url = yooareel;
		f = new File(url);
	}
	
	protected String[][][] breakApart() {
		try {
			String[][][] file = new String[9][9][9];
			Scanner sc = new Scanner(f);
			String[] currentSegments;
			int column = 0;
			int row = 0;
			while(sc.hasNextLine()) {
				currentSegments = sc.nextLine().split(";");
				for(int segment = 0; segment < currentSegments.length; segment++) {
					file[segment][column][row] = currentSegments[segment];
				} if(row >= 4) {
					column++;
					row = 0;
					continue;
				} row++;
			}
			
			sc.close();
			
			return file;
		} catch(FileNotFoundException ee) {
			ee.printStackTrace();
			return null;
		}
	}
	
	
	
	public String getQuestion(int column, int row) {
		String[][][] t = breakApart();
		return breakApart()[0][column][row];
	}
	public String getCorrectAnswer(int column, int row) {
		return breakApart()[1][column][row];
	}
	public String[] getWrongAnswers(int column, int row) {
		String[] temp = {breakApart()[2][column][row], breakApart()[3][column][row], breakApart()[4][column][row]};
		return temp;
	}
	public String[] getAllAnswers(int column, int row) {
		String[] temp = {breakApart()[2][column][row], breakApart()[3][column][row], breakApart()[4][column][row], breakApart()[1][column][row]};
		return temp;
	}
	public String getCategories(int a) {
		return categories[a];
	}
}
