import java.util.Scanner;

public class PasswordStrength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSymbol = false;
        boolean hasLength = password.length() >= 8;

        
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (Character.isLowerCase(ch)) {
                hasLower = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else {
                hasSymbol = true;
            }
        }

        
        int score = 0;
        if (hasLength) score++;
        if (hasUpper) score++;
        if (hasLower) score++;
        if (hasDigit) score++;
        if (hasSymbol) score++;

        
        if (score <= 2) {
            System.out.println("\nPassword Strength: Weak");
        } else if (score == 3 || score == 4) {
            System.out.println("\nPassword Strength: Medium");
        } else {
            System.out.println("\nPassword Strength: Strong");
        }

        
        if (!hasLength)
            System.out.println("- Password should be at least 8 characters long.");
        if (!hasUpper)
            System.out.println("- Add at least one uppercase letter.");
        if (!hasLower)
            System.out.println("- Add at least one lowercase letter.");
        if (!hasDigit)
            System.out.println("- Add at least one number.");
        if (!hasSymbol)
            System.out.println("- Add at least one special character.");

        sc.close();
    }
}