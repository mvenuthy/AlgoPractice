/*
 * Given a string, randomize the words in the string and return the output
 * 
 * Given input string is bound by following conditions,
 * ****** Only delimiter is a blankspace character ******
 * ****** Extent of randomization needs to equal to the probability of getting the same output ******
 * 
 * Example 
 * 
 * Input String - "Life is good"
 * Output String - "good is Life" 
 * 
 * */
import java.util.*;
public class shuffleString {	
	public static void main(String[] args){
		String str = "   Life is good   ";
		String output = randomizeStr(str);
		System.out.println("Randomized String is : " + output);		
	}
	
	public static String randomizeStr(String str){
		
		if(str == null || str.length() == 0){return str;}
		
		final String[] splitInput = str.trim().split("\\s+");
		int len = splitInput.length;
		System.out.println("The length is : " + len);
		if(len < 2 ) {return str;}
		StringBuilder sb = new StringBuilder();
		
		Random rand = new Random();
				
		for(int i = len - 1; i > 0; i--) {
			int randIdx = rand.nextInt(i);
			swapRandom(splitInput, randIdx, i);			
		}
		
		for(int j = 0; j < splitInput.length; j++) {
			if(j == splitInput.length - 1) {
				sb.append(splitInput[j]);
			}else {
				sb.append(splitInput[j]);
				sb.append(" ");
			}
		}
		
		return sb.toString();
	}
	
	public static void swapRandom(String[] input, int idx1, int idx2) {
		String temp = input[idx1];
		input[idx1] = input[idx2];
		input[idx2] = temp;		
	}
	
	
}
