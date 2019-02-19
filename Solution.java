import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	// Complete the gameOfThrones function below.
    static String gameOfThrones(String s) {

    	// **** get the length of the string ****
    	int len = s.length();
    	
//    	System.out.println("len: " + len);
    	
       	// **** check for single character strings ****
    	if (len == 1)
    		return "YES";
    	
    	HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
    	
    	// **** traverse the string counting characters ****
    	for (int i = 0; i < s.length(); i++) {
    		char ch = s.charAt(i);
    		if (hm.containsKey(ch)) {
    			int count = hm.get(ch);
    			count++;
    			hm.put(ch, count);
    		} else {
    			hm.put(ch, 1);
    		}
    	}
    	
    	// **** iterate through the string counting odd counts ****
    	int oddCount = 0;
    	for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
    		int charCount = entry.getValue();
    		if ((charCount % 2) == 1)
    			oddCount++;
    	}
    	
//    	System.out.println("oddCount: " + oddCount);
    	
    	// **** ****
		if (oddCount <= 1)
			return "YES";
		else
			return "NO";
    }

    
    private static final Scanner scanner = new Scanner(System.in);

    
    public static void main(String[] args) throws IOException {
    	
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scanner.nextLine();

        String result = gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
