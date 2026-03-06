import java.util.Scanner;

class Nodes {
    char data;
    Nodes next;

    Nodes(char data) {
        this.data = data;
        this.next = null;
    }
}

public class UC9PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        Nodes head = null;
        Nodes tail = null;

        for (int i = 0; i < input.length(); i++) {
            Nodes newNode = new Nodes(input.charAt(i));
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        Nodes slow = head;
        Nodes fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Nodes secondHalf = reverse(slow);
        Nodes firstHalf = head;

        boolean isPalindrome = true;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                isPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        if (isPalindrome && isPalindrome(input, 0, input.length() - 1)) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is not a palindrome.");
        }
    }

    private static Nodes reverse(Nodes head) {
        Nodes prev = null;
        Nodes current = head;

        while (current != null) {
            Nodes nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }

    private static boolean isPalindrome(String str, int start, int end) {
        if (start >= end) {
            return true;
        }

        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        return isPalindrome(str, start + 1, end - 1);
    }
}