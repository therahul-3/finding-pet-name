package day7;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserFace {

	    public String findPetName(String fileName) {
	        try (FileReader fileReader = new FileReader(fileName);
	             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

	            String line;
	            while ((line = bufferedReader.readLine()) != null) {
	                if (hasExactlyTwoVowels(line)) {
	                    return line;
	                }
	            }
	           
	            return "No name with exactly two vowels found";
	        } catch (FileNotFoundException e) {
	            return "Please give the correct file name";
	        } catch (IOException e) {
	            return "Error occurred while reading the names from file";
	        }
	    }

	    private boolean hasExactlyTwoVowels(String name) {
	        int count = 0;
	        for (char c : name.toLowerCase().toCharArray()) {
	            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
	                count++;
	            }
	        }
	        return count == 2;
	    }

	    public static void main(String[] args) {
	        UserFace ui = new UserFace();
	        String fileName = "Pet-Names"; 
	        String petName = ui.findPetName(fileName);
	        System.out.println("Pet name with exactly two vowels: " + petName);
	    }
	}
