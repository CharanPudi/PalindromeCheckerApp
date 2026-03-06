import java.util.Scanner;

public class UC11{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to check palindrome: ");
        String input = scanner.nextLine();
        scanner.close();

        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        boolean isPalindrome = checkPalindrome(normalized);

        if (isPalindrome) {
            System.out.println(input + " is a palindrome (ignoring case and spaces).");
        } else {
            System.out.println(input + " is not a palindrome (ignoring case and spaces).");
        }
    }

    private static boolean checkPalindrome(String str) {
        class PalindromeChecker {
            public boolean checkPalindrome(String str) {
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

        public class PalindromeCheckerApp {
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter a string to check palindrome: ");
                String input = scanner.nextLine();
                scanner.close();

                PalindromeChecker checker = new PalindromeChecker();
                if (checker.checkPalindrome(input)) {
                    System.out.println(input + " is a palindrome.");
                } else {
                    System.out.println(input + " is not a palindrome.");
                }
            }
        }