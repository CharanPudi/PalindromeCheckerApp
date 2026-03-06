import java.util.*;

interface PalindromeStrategy {
    boolean checkPalindrome(String str);
}

class StackStrategy implements PalindromeStrategy {
    public boolean checkPalindrome(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return str.equals(reversed.toString());
    }
}

class DequeStrategy implements PalindromeStrategy {
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

class RecursiveStrategy implements PalindromeStrategy {
    public boolean checkPalindrome(String str) {
        return isPalindrome(str, 0, str.length() - 1);
    }
    private boolean isPalindrome(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindrome(str, start + 1, end - 1);
    }
}

public class UC13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to check palindrome: ");
        String input = scanner.nextLine();
        System.out.print("Choose strategy (stack/deque): ");
        String choice = scanner.nextLine().toLowerCase();
        scanner.close();

        PalindromeStrategy strategy;
        if (choice.equals("stack")) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }
        List<PalindromeStrategy> strategies = Arrays.asList(
                new StackStrategy(),
                new DequeStrategy(),
                new RecursiveStrategy()
        );

        List<String> names = Arrays.asList("StackStrategy", "DequeStrategy", "RecursiveStrategy");

        if (strategy.checkPalindrome(input)) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is not a palindrome.");
            for (int i = 0; i < strategies.size(); i++) {
                strategy = strategies.get(i);
                long startTime = System.nanoTime();
                boolean result = strategy.checkPalindrome(input);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                System.out.println(names.get(i) + ": " + (result ? "Palindrome" : "Not Palindrome") +
                        " | Time: " + duration + " ns");
            }
        }
    }}