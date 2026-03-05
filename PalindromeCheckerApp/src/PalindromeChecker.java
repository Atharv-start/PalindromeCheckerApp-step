import java.util.Scanner;

public class PalindromeChecker {

    // Method to check palindrome (ignoring spaces and case)
    public static boolean isPalindrome(String input) {

        // Step 1: Normalize the string
        // Remove all spaces using regex and convert to lowercase
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Step 2: Convert to char array (Data Structure concept)
        char[] charArray = normalized.toCharArray();

        // Step 3: Check palindrome using two-pointer technique
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC10: Case-Insensitive & Space-Ignored Palindrome Checker ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        boolean result = isPalindrome(input);

        if (result) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}