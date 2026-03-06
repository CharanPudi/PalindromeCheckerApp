import java.util.*;

class PalindromeChecker {

    interface PalindromeStrategy {
        boolean checkPalindrome(String str);
    }

    static class StackStrategy implements PalindromeStrategy {
        public boolean checkPalindrome(String str) {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < str.length(); i++) {
                stack.push(str.charAt(i));
            }

            StringBuilder reversed = new StringBuilder();

            while (!stack.isEmpty()) {
                reversed.append(stack.pop());
            }

            return str.contentEquals(reversed);
        }
    }

    static class DequeStrategy implements PalindromeStrategy {
        public boolean checkPalindrome(String str) {

            Deque<Character> deque = new LinkedList<>();

            for (int i = 0; i < str.length(); i++) {
                deque.add(str.charAt(i));
            }

            while (deque.size() > 1) {
                if (deque.removeFirst() != deque.removeLast()) {
                    return false;
                }
            }

            return true;
        }
    }
}

public class UC12 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check palindrome: ");
        String input = scanner.nextLine();

        System.out.print("Choose strategy (stack/deque): ");
        String choice = scanner.nextLine().toLowerCase();

        PalindromeChecker.PalindromeStrategy strategy;

        if (choice.equals("stack")) {
            strategy = new PalindromeChecker.StackStrategy();
        } else {
            strategy = new PalindromeChecker.DequeStrategy();
        }

        if (strategy.checkPalindrome(input)) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is not a palindrome.");
        }

        scanner.close();
    }
}