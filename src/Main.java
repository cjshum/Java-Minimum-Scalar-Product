/* Minimum Scalar Product
 * Problem taken from Google Code Jam - Round 1A 2008:
 * https://code.google.com/codejam/contest/32016/dashboard#s=p0
 * 
 * Problem
 * You are given two vectors v1=(x1,x2,...,xn) and v2=(y1,y2,...,yn). The scalar 
 * product of these vectors is a single number, calculated as x1y1+x2y2+...+xnyn.
 *
 * Suppose you are allowed to permute the coordinates of each vector as you wish.
 * Choose two permutations such that the scalar product of your two new vectors is
 * the smallest possible, and output that minimum scalar product.
 *
 * Input
 * The first line of the input file contains integer number T - the number of test
 * cases. For each test case, the first line contains integer number n. The next two
 * lines contain n integers each, giving the coordinates of v1 and v2 respectively.
 *
 * Output
 * For each test case, output a line
 * Case #X: Y
 * where X is the test case number, starting from 1, and Y is the minimum scalar
 * product of all permutations of the two given vectors.
 *
 * Limits
 * Small dataset
 * T = 1000
 * 1 ≤ n ≤ 8
 * -1000 ≤ xi, yi ≤ 1000
 *
 * Large dataset
 * T = 10
 * 100 ≤ n ≤ 800
 * -100000 ≤ xi, yi ≤ 100000
 *
 * Sample
 * Input 
 * 2
 * 3
 * 1 3 -5
 * -2 4 1
 * 5
 * 1 2 3 4 5
 * 1 0 1 0 1
 * Output
 * Case #1: -25
 * Case #2: 6
 */

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