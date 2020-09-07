import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task4version2 {

	public static void main(String[] args) throws IOException {

		String stringPattern = "123456";

		System.out.println("Enter your password: ");

		String consoleArgument = new BufferedReader(new InputStreamReader(System.in)).readLine();

		if (consoleArgument.equals(stringPattern)) {
			System.out.println("Your password is correct");
		} else {
			System.out.println("Your password is incorrect. Try again");
		}
	}

}
