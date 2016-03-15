import java.util.Arrays;
import java.util.Collections;

public class Vector {
	Number vector[];
	String type;
	
	/**
	 * Constructor that creates a vector of integers by default.
	 * 
	 * @param size: the size of the vector array.
	 */
	Vector(int size) {
		vector = new Integer[size];
	}
	
	/**
	 * Constructor that creates a vector of specified numeric type.
	 * 
	 * @param size: the size of the vector array.
	 * @param type: A string containing the simple class name.
	 * @throws Exception: if the given type is not a know numeric type.
	 */
	Vector(int size, String type) throws Exception {
		this.type = type;
		switch (type) { 
			case "Short":
				vector = new Short[size];
				break;
			case "Integer":
				vector = new Integer[size];
				break;
			case "Long":
				vector = new Long[size];
				break;
			case "Float":
				vector = new Float[size];
				break;
			case "Double":
				vector = new Double[size];
				break;
			default:
				throw new Exception("Unknown numeric type: " + type);
		}
	}
	
	/**
	 * Copy constructor.
	 * 
	 * @param copyVec: the vector to be copied from.
	 * @throws Exception: if the given type is not a know numeric type.
	 */
	Vector(Vector copyVec) throws Exception {
		// initialize memory allocation
		this(copyVec.getSize(), copyVec.getType());
		
		// gets the reference to avoid multiple method calls: copyVec.getVector()[i] 
		Number referenceVec[] = copyVec.getVector(); 
		for (int i=0; i<vector.length; i++) {
			vector[i] = referenceVec[i];
		}
	}
	
	/**
	 * Constructor that creates a vector of specified numeric type and
	 * vector component values of the vector are given in an String array.
	 * 
	 * @param size: the size of the vector array.
	 * @param type: A string containing the simple class name.
	 * @param values: String array containing the vector component values.
	 * @throws Exception: if the given type is not a know numeric type.
	 */
	Vector(int size, String type, String values[]) throws Exception {
		this.type = type;
		switch (type) { 
			case "Short":
				vector = new Short[size];
				for (int i=0; i<size; ++i) {
					vector[i] =  Short.parseShort(values[i]);
				};
				break;
			case "Integer":
				vector = new Integer[size];
				for (int i=0; i<size; ++i) {
					vector[i] =  Integer.parseInt(values[i]);
				};
				break;
			case "Long":
				vector = new Long[size];
				for (int i=0; i<size; ++i) {
					vector[i] =  Long.parseLong(values[i]);
				};
				break;
			case "Float":
				vector = new Float[size];
				for (int i=0; i<size; ++i) {
					vector[i] =  Float.parseFloat(values[i]);
				};
				break;
			case "Double":
				vector = new Double[size];
				for (int i=0; i<size; ++i) {
					vector[i] =  Double.parseDouble(values[i]);
				};
				break;
			default:
				throw new Exception("Unknown numeric type: " + type);
		}
	}
	
	public int getSize() {
		return vector.length;
	}
	
	public Number[] getVector() {
		return vector;
	}
	
	public String getType() {
		return type;
	}
	
	public void print() {
		System.out.print("<");
		int i=0;
		for (i=0; i<vector.length-1; i++) {
			System.out.print(vector[i] +", ");
		}
		System.out.println(vector[i] +">");
	}
	
	/**
	 * Calculates the dot product between this vector and another given vector.
	 * 
	 * @param otherVector: the other given vector.
	 * @return: the scalar value of the dot product. 
	 * @throws Exception: 1) if the size of the vectors do not match.
	 *                    2) if the numeric types of the vectors do not match.
	 */
	public Number dotProduct(Vector otherVector) throws Exception {
		if (vector.length != otherVector.getSize()) {
			throw new Exception("The size of the vectors do not match.");
		}
		else if (type != otherVector.getType()) {
			throw new Exception("The numeric types of the vectors do not match.");
		}
		
		Number result = new Integer(0);
		switch (type) { 
			case "Short":
				result = new Short((short) 0);
				for (int i=0; i<vector.length; ++i) {
					result = result.shortValue() +
						(vector[i].shortValue()*otherVector.getVector()[i].shortValue()); 
				}
				break;
			case "Integer":
				result = new Integer(0);
				for (int i=0; i<vector.length; ++i) {
					result = result.intValue() +
						(vector[i].intValue()*otherVector.getVector()[i].intValue()); 
				}
				break;
			case "Long":
				result = new Long((long)0);
				for (int i=0; i<vector.length; ++i) {
					result = result.longValue() +
						(vector[i].longValue()*otherVector.getVector()[i].longValue()); 
				}
				break;
			case "Float":
				result = new Float(0.0);
				for (int i=0; i<vector.length; ++i) {
					result = result.floatValue() +
						(vector[i].floatValue()*otherVector.getVector()[i].floatValue()); 
				}
				break;
			case "Double":
				result = new Double(0.0);
				for (int i=0; i<vector.length; ++i) {
					result = result.doubleValue() +
						(vector[i].doubleValue()*otherVector.getVector()[i].doubleValue()); 
				}
				break;
		}
		
		return result;
	}
	
	/**
	 * Calculates the minimum dot product between this vector and another given vector.
	 * 
	 * @param otherVector: the other given vector.
	 * @return: the scalar value of the dot product. 
	 * @throws Exception: 1) if the size of the vectors do not match.
	 *                    2) if the numeric types of the vectors do not match.
	 */
	public Number minDotProduct(Vector otherVector) throws Exception {
		// copy the vectors to prevent modifying the original ones when sorting
		Vector vec1 = new Vector(this);
		Vector vec2 = new Vector(otherVector);
		Arrays.sort(vec1.getVector());
		Arrays.sort(vec2.getVector(), Collections.reverseOrder());
		
		return vec1.dotProduct(vec2);
	}
}