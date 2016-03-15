import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
	public static void main(String []args) throws Exception {
		String inFile = "A-small-practice.in";
		String outFile = "output-small.txt";
		//String inFile = "A-large-practice.in";
		//String outFile = "output-large.txt";
		
		// TODO make sure that the number type is large enough to store the result
		String resultType = Long.class.getSimpleName();
		
		BufferedReader fileReader = new BufferedReader(new FileReader(inFile));
		BufferedWriter fileWriter = new BufferedWriter(new FileWriter(outFile));
		
		int numEntries = Integer.parseInt(fileReader.readLine());
		
		for(int entryIndex=0; entryIndex<numEntries; entryIndex++) {
			int vecSize = Integer.parseInt(fileReader.readLine());
			
			Vector vec1 = new Vector(vecSize, resultType, fileReader.readLine().split(" "));
			Vector vec2 = new Vector(vecSize, resultType, fileReader.readLine().split(" "));
			Number result = vec1.minDotProduct(vec2);
			
			//System.out.println("Case #"+ (entryIndex+1) +": "+ result);
			fileWriter.write("Case #"+ (entryIndex+1) +": "+ result +"\n");
		}
		
		fileReader.close();
		fileWriter.close();
	}
}