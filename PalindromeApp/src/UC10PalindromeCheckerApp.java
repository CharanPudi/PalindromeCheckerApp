import java.util.Scanner;

public class UC10PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to check palindrome: ");
        String input = scanner.nextLine();
        scanner.close();

        if (isPalindrome(input, 0, input.length() - 1)) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is not a palindrome.");
        }

        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        boolean result = checkPalindrome(normalized);

        if (result) {
            System.out.println(input + " is a palindrome (ignoring case and spaces).");
        } else {
            System.out.println(input + " is not a palindrome (ignoring case and spaces).");
        }
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

    private static boolean checkPalindrome(String str) {

        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}