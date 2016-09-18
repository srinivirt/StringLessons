package my;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StringLength {

	private static int computeStringLength(String inpString) {
		// convert inpString to char[]
		char[] ca = inpString.toCharArray();
		
		// iterate through the char array starting at index 0
		// until ArrayIndexOutOfBoundsException is thrown
	
		int index = 0; // starting index
		for (;;) { // loop until a break statement
			try {
				// try to access the array at index until exception
				char c = ca[index]; // access char at index
				// increment index to try accessing the next element in the array
				System.out.printf("%c %n", c);
				++index;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.printf("Out of Bounds %s %n", e.toString());
				// break out of the loop
				break;
			}
		}
		// we have gone past the end of the array
		// index is 1 past the end of the array
		// therefore, index is the length of the array because we counted
		// starting from zero, not one
		return index;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Open string.txt file from home directory
		Path stringInputPath = Paths.get("/home/sriniv/string.txt");
		
		// create newBufferedReader using Path to read the input string
		try {
			BufferedReader reader = Files.newBufferedReader(stringInputPath);
			// read the string from the file - buffered reader
			String stringToFindLength = reader.readLine();
			int len = computeStringLength(stringToFindLength);
			System.out.printf("Length of %s is %d %n", stringToFindLength, len);
		} catch (IOException e) {
			System.out.printf("DEBUG: %s %n", e.toString());
			return;
		}
		return;
	}

}
