import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeChecker {

    // Stack-based palindrome check
    public static boolean stackCheck(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char ch : normalized.toCharArray()) {
            stack.push(ch);
        }
        for (char ch : normalized.toCharArray()) {
            if (ch != stack.pop()) return false;
        }
        return true;
    }

    // Deque-based palindrome check
    public static boolean dequeCheck(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : normalized.toCharArray()) {
            deque.add(ch);
        }
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }

    // StringBuilder reverse check
    public static boolean stringBuilderCheck(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(normalized).reverse().toString();
        return normalized.equals(reversed);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("=== UC13: Palindrome Performance Comparison ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Stack Strategy
        long startStack = System.nanoTime();
        boolean resultStack = stackCheck(input);
        long endStack = System.nanoTime();

        // Deque Strategy
        long startDeque = System.nanoTime();
        boolean resultDeque = dequeCheck(input);
        long endDeque = System.nanoTime();

        // StringBuilder Strategy
        long startSB = System.nanoTime();
        boolean resultSB = stringBuilderCheck(input);
        long endSB = System.nanoTime();

        // Display results
        System.out.println("\nResults:");
        System.out.println("Stack check: " + resultStack + ", Time: " + (endStack - startStack) + " ns");
        System.out.println("Deque check: " + resultDeque + ", Time: " + (endDeque - startDeque) + " ns");
        System.out.println("StringBuilder check: " + resultSB + ", Time: " + (endSB - startSB) + " ns");

        scanner.close();
    }
}