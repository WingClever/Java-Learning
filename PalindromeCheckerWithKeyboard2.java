import java.util.Scanner;

public class PalindromeCheckerWithKeyboard2 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        boolean keepChecking = true; // Control loop

        while (keepChecking) {
            System.out.println("Enter your word to test:");
            String original = keyboard.nextLine().replaceAll("\\s+", "").toLowerCase();
            
            // Use the isPalindrome method to check if the string is a palindrome
            if (isPalindrome(original)) {
                System.out.println("Is palindrome");
            } else {
                System.out.println("Not palindrome");
            }
         String reply;
         do{
            // Ask if the user wants to try again
            System.out.println("Would you like to try again? (yes or no)");
            reply = keyboard.nextLine().trim().toLowerCase();
            
            if (reply.equals("no")) {
                keepChecking = false;
                System.out.println("Thank you - goodbye");
            } else if (!reply.equals("yes")) {
                System.out.println("Invalid choice - please enter 'yes' or 'no'");
            } 
            
         } while (!reply.equals("yes") && !reply.equals("no"));
        
        }
        
        
        keyboard.close(); // Close resource AI suggestion
    }

    // Method to check if a string is a palindrome
    public static boolean isPalindrome(String str) {
        String original = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reverse = "";
        
        for (int i = original.length() - 1; i >= 0; i--) {
            reverse += original.charAt(i);
        }
        
        return original.equals(reverse);
    }
}
