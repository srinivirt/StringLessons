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
				// System.out.printf("%c %n", c);
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
	
	private static String reverseString(String inpString, int len) {
		// create a result char array of length len
		char[] reverseCa = new char[len];
		
		// create char array of inpString
		char[] inpCa = inpString.toCharArray();
		
		// initialize two index to iterate throguht the array
		// index going backwards from last to zero
		int inpIndex = len-1; // set this to the last valid index
		// System.out.printf("inpIndex = %d %n", inpIndex);
		int revIndex = 0; // set to first position
		// Decrement inpIndex by 1 to go backwards, increment revIndex by 1
		for (; inpIndex >= 0; inpIndex--, revIndex++) {
			reverseCa[revIndex] = inpCa[inpIndex]; // copy char from input char array to reverse char array
			// System.out.printf("DEBUG: %c %n", reverseCa[revIndex]);
		}
		// create a string from the reverseCa char[], and return it
		return new String(reverseCa);
	}
	
	private static boolean isPalindrome(String inpString, String revString, int len) {
		// compare inpString and revString one character at a time
		char[] inpCa = inpString.toCharArray();
		char[] revCa = revString.toCharArray();
		
		// start from 0 pos to len, compare inpCa with revCa
		for (int index = 0; index < len; index++) { // iterate until len minus 1
			if (inpCa[index] == revCa[index]) {
				continue;
			} else {
				return false;
			}
		}
		return true; // all positions matched
	}
	
	private static String changeLowerToUpper(String inpString, int len) {
		// convert string to char[]
		char[] inpCa = inpString.toCharArray(); // modified in place
		
		// visit each element in the inpCa, check lowercase, convert to upper
		for (int i = 0; i < len; i++) { // visit until len - 1
			// check if element is lowercase
			/*
			 * lowercase ascii values are from 97 to 122
			 */
			int asciiValue = (int)inpCa[i]; // cast char to int to get ASCII value
			if (asciiValue >= 97 && asciiValue <= 122) { // it is lowercase
				// subtract 32 to convert to upper case ascii value
				asciiValue = asciiValue - 32;
				// store it in inpCa array
				inpCa[i] = (char)asciiValue; // cast it to char before storing in char[]
			}
		} // end for
		// create a new string from inpCa char[] and return
		return new String(inpCa); // create a String from char[]	
	}
	
	private static String removeWhiteSpace(String inpString, int len) {
		// convert to char[]
		char[] inpCa = inpString.toCharArray();
		
		/*
		 * Keep track of last non-whitespace position: lastNonWsPos
		 * Keep track of current position: curPos
		 * if curPos is whitespace:
		 *     continue to next pos
		 * if curPos is not a whitespace:
		 *     advance lastNonWsPos by 1 //NOTE: increment, then copy. Hint for init value
		 *     copy curPos to lastNonWsPos
		 *     continue
		 */
		// initialize the position pointers
		int curPos = 0; // start from position zero
		int lastNonWsPos = -1; // no non-whitespace found yet
		for (; curPos < len; curPos++) { // visit all elements in the array
			// check if char in curPos is non-whitespace
			/*
			 * Non-whitespace char is ASCII code: greater than 32
			 */
			int asciiValue = (int)inpCa[curPos]; // get ASCII code
			if (asciiValue > 32) { // found non-whitespace
				// increment lastNonWsPos
				++lastNonWsPos;
				// copy curPos to lastNonWsPos
				inpCa[lastNonWsPos] = inpCa[curPos];
			}
			// do nothing if whitespace, just go to next
		} // end for
		// check for empty result string: if lastNonWsPos is -1
		if (lastNonWsPos == -1) {
			return null;
		}
		// create a string with subarray zero to lastNonWsPos and return
		return new String(inpCa, 0 /* offset */, lastNonWsPos /* count */);	
	}
	
	private static String capitalizeFirstLet(String inpString, int len) {
		// convert inpString to char[]
		char[] inpCa = inpString.toCharArray();
		
		/*
		 * use a flag (boolean) to track whether to capitalize or not
		 */
		boolean flagCapNow = true; // capitalize the first non-whitespace
		
		for (int curPos = 0; curPos < len; ++curPos) {
			// check if curPos is whitespace
			int asciiValue = (int)inpCa[curPos]; // get ascii value
			if (asciiValue <= 32) {
				flagCapNow = true; // capitalize the next non-whitespace
			} else { // non-whitespace
				if (flagCapNow == true) {
					// is char a lowercase?
					if (asciiValue >= 97 && asciiValue <= 122) {
						// change to uppercase
						asciiValue = asciiValue - 32;
						// modify the char[]
						inpCa[curPos] = (char)asciiValue;
					}
					// reset flag to not capitalize anymore for this word
					flagCapNow = false;
				}
			}
		} // end for
		// return string with new char[]
		return new String(inpCa);
	}
	
	private static int getIndexOf(String inpString, int len, char findC) {
		// convert inpString to char[]
		char[] inpCa = inpString.toCharArray();
		
		// iterate through the array
		int retPos = -1; // default/assume findC not found
		for (int curPos = 0; curPos < len; curPos++) {
			// check for char
			if (inpCa[curPos] == findC) {
				retPos = curPos;
				break;
			}
		} // end for
		return retPos;
	}
	
	private static int countOccurrences(String inpString, int len, char c) {
		// convert string to char[]
		char[] inpCa = inpString.toCharArray();
		
		// iterate through inpCa
		int retCount = 0; // default/assume zero occurrences
		for (int curPos = 0; curPos < len; curPos++) {
			// check for char c
			if (inpCa[curPos] == c) {
				retCount++;
			}
		} // end for
		return retCount;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Open string.txt file from home directory
		Path stringInputPath = Paths.get("/home/sriniv/string.txt");
		
		// create newBufferedReader using Path to read the input string
		try {
			BufferedReader reader = Files.newBufferedReader(stringInputPath);
			// read the string from the file - buffered reader
			String inputTestString = reader.readLine();
			while (inputTestString != null) {
				int len = computeStringLength(inputTestString);
				System.out.printf("Length of %s is: %d %n", inputTestString, len);
				String reversedValue = reverseString(inputTestString, len);
				System.out.printf("Reversed value of %s is: %s %n", inputTestString, reversedValue);
				System.out.printf("Length of reversed value: %d %n", computeStringLength(reversedValue));
				boolean flag = isPalindrome(inputTestString, reversedValue, len);
				System.out.printf("String %s is %s palindrome %n", inputTestString, flag ? "a" : "not a");
				String upperResult = changeLowerToUpper(inputTestString, len);
				System.out.printf("Input %s in upper case is: %s %n", inputTestString, upperResult);
				String noWhiteSpaceString = removeWhiteSpace(inputTestString, len);
				System.out.printf("Input %s without whitespace is: %s %n", inputTestString, noWhiteSpaceString);
				String capFirstLet = capitalizeFirstLet(inputTestString, len);
				System.out.printf("Input %s capitalize first letter is: %s %n", inputTestString, capFirstLet);
				char c = 'a';
				int charIndex = getIndexOf(inputTestString, len, c);
				System.out.printf("Input %s, index of %c is %d %n", inputTestString, c, charIndex);
				for (int letVal = (int)'a'; letVal <= (int)'z'; ++letVal) {
					int charCount = countOccurrences(inputTestString, len, (char)letVal);
					System.out.printf("%c\t%d%n", (char)letVal, charCount);
				}
				for (int letVal = (int)'A'; letVal <= (int)'Z'; ++letVal) {
					int charCount = countOccurrences(upperResult, len, (char)letVal);
					System.out.printf("%c\t%d%n", (char)letVal, charCount);
				}
				System.out.println("=======================");
				// find most often occurring character
				// define variable to store the answer
				int answerCount = 0;
				char answerChar = 'a'; // don't know
				for (int letVal = (int)'a'; letVal <= (int)'z'; ++letVal) {
					int charCount = countOccurrences(inputTestString, len, (char)letVal);
					if (charCount > answerCount) {
						answerChar = (char)letVal;
						answerCount = charCount;
					}
					System.out.printf("%c\t%d%n", (char)letVal, charCount);
				}
				for (int letVal = (int)'A'; letVal <= (int)'Z'; ++letVal) {
					int charCount = countOccurrences(inputTestString, len, (char)letVal);
					if (charCount > answerCount) {
						answerChar = (char)letVal;
						answerCount = charCount;
					}
					System.out.printf("%c\t%d%n", (char)letVal, charCount);
				}
		
				// print the answer
				System.out.printf("Input %s most often char is: %c %d times %n", inputTestString, answerCount == 0 ? null : answerChar, answerCount);
				// read the next line
				inputTestString = reader.readLine();
			}
		} catch (IOException e) {
			System.out.printf("DEBUG: %s %n", e.toString());
			return;
		}
		return;
	}

}
