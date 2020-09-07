import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1version2 {

	public static void main(String[] args) throws IOException {

		System.out.print("Enter your name: ");

		String consoleArgument = new BufferedReader(new InputStreamReader(System.in)).readLine();

		if (consoleArgument.length() > 0) {
			System.out.println("Hello, " + consoleArgument + "!");
		} else {
			System.out.println("Your didn't enter your name");
		}
	}
}
