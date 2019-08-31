/*
*
*/

public static List<String> mySplitMethod(String input, char delim){
		
		List<String> result = new ArrayList<String>();
		StringBuilder temp = new StringBuilder();
		for(int i = 0; i < input.length(); i++){
			if(input.charAt(i) == delim){
				result.add(temp.toString());
				temp = new StringBuilder();
			}else{
				temp.append(input.charAt(i));				
			}	
		}
		result.add(temp.toString());
		return result;
	} 
