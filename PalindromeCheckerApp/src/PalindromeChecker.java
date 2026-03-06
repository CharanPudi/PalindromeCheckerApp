import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String word = sc.nextLine();

        String fixedWord = "racecar";

        if (isPalindrome(word)) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }

        if (isPalindrome(fixedWord)) {
            System.out.println(fixedWord + " is a palindrome.");
        } else {
            System.out.println(fixedWord + " is not a palindrome.");
        }

        sc.close();
    }

    public static boolean isPalindrome(String str) {

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