import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int numberOfTestCases = Integer.parseInt(scanner.nextLine());// Get the number of test cases from the user
        int totalCharacterCount = 0; // Keep track of total characters across all lines

        // Loop through each test case
        for (int i = 0; i < numberOfTestCases; i++) {
            String inputLine = scanner.nextLine();
            
            // Check if the input line exceeds the maximum length of 10,000 characters
            if (inputLine.length() > 10000) {
                System.out.println("Line exceeds the maximum allowed length of 10,000 characters.");
                continue; // Skip to the next test case
            }
            
            totalCharacterCount += inputLine.length();// Update total character count
            
            // Validate if the total characters exceed the limit of 1,000,000
            if (totalCharacterCount > 1000000) {
                System.out.println("Total character count exceeded the limit of 1,000,000.");
                break; // Stop processing if the limit is exceeded
            }

            boolean foundValidContent = false; // Flag to indicate if valid content was found
            int currentIndex = 0; // Initialize the current index for tag processing

            // Process the line for tags and content
            while (true) {
                // Locate the next opening tag
                int startTagIndex = inputLine.indexOf("<", currentIndex);
                if (startTagIndex < 0) break; // No more opening tags

                // Locate the corresponding closing tag
                int endTagIndex = inputLine.indexOf(">", startTagIndex);
                if (endTagIndex < 0) break; // No closing angle bracket found
                
                // Extract the tag name
                String tagName = inputLine.substring(startTagIndex + 1, endTagIndex);
                
                // Skip if the tag is empty or it's a closing tag
                if (tagName.isEmpty() || tagName.charAt(0) == '/') {
                    currentIndex = endTagIndex + 1;
                    continue; // Move to the next position
                }
                
                // Look for the closing tag
                int closingTagIndex = inputLine.indexOf("</" + tagName + ">");
                if (closingTagIndex >= 0) {
                    // Extract the content between the opening and closing tags
                    String contentBetweenTags = inputLine.substring(endTagIndex + 1, closingTagIndex);
                    
                    // Ensure the content is valid (not empty and does not contain nested tags)
                    if (!contentBetweenTags.isEmpty() && contentBetweenTags.indexOf("<") < 0) {
                        foundValidContent = true; 
                        System.out.println(contentBetweenTags); // Output the valid content
                    }
                }
                
                currentIndex = endTagIndex + 1; // Update the current index for the next search
            }
            
            if (!foundValidContent) {// If no valid content was found in the line, print "None"
                System.out.println("None");
            }
        }
    }
}
