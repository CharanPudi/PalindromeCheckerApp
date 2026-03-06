import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Palindrone {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            queue.add(c);
            stack.push(c);
            deque.add(c);
        }

        boolean isPalindrome = true;

        while (!queue.isEmpty() && !stack.isEmpty()) {
            if (queue.remove() != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        while (deque.size() > 1 && isPalindrome) {
            if (deque.removeFirst() != deque.removeLast()) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is not a palindrome.");
        }

        scanner.close();
    }
}