import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SonarDepth{
	public static void main(String[] args){
		List<Integer> values = loadInputs(new File(args[0]));

		int risingIntervals = 0;

		// walk down the List, beginning at index 1, and compare every value to its predecessor
		for(int i = 1; i < values.size(); i++){
			if(values.get(i) > values.get(i-1)){
				risingIntervals++;
			}
		}

		System.out.printf("Number of increasing intervals: %d", risingIntervals);
	}

	public static List<Integer> loadInputs(File input){
		List<Integer> values = new ArrayList<>();

		try(BufferedReader file = new BufferedReader(new FileReader(input))){
			for(String line = file.readLine(); line != null; line = file.readLine()){
				values.add(Integer.parseInt(line));
			}
			file.close();
		}
		catch(java.io.IOException e){
			System.err.printf("Failed to access the file: %s", e);
		}
		
		return values;
	}
}