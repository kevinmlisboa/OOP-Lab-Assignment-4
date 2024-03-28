import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int loginAttempts = 0;
        final int MAX_LOGIN_TRIES = 3;

        while (loginAttempts < MAX_LOGIN_TRIES) {
            try {
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                login(password);
                break;
            } catch (MaxLoginTriesExceededException e) {
                System.out.println("Error: " + e.getMessage());
                System.exit(1);
            } catch (InvalidPasswordException e) {
                System.out.println("Error: " + e.getMessage());
                loginAttempts++;
            }
        }
        
        if (loginAttempts >= MAX_LOGIN_TRIES) {
            System.out.println("Maximum login attempts exceeded.");
            System.exit(1);
        }
    }

    public static void login(String enteredPassword) throws MaxLoginTriesExceededException, InvalidPasswordException {
        final String VALID_PASSWORD = "password";

        if (!enteredPassword.equals(VALID_PASSWORD)) {
            throw new InvalidPasswordException("Invalid password.");
        }

        
        System.out.println("Login successful!");
    }
}

class MaxLoginTriesExceededException extends Exception {
    public MaxLoginTriesExceededException(String message) {
        super(message);
    }
}

class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}
