public class Task2 {
	public static void main(String[] args) {

		System.out.println("Reserve order of arguments");

		for (int i = 1; i <= args.length; i++) {
			System.out.print(args[args.length - i] + " ");
		}
	}
}
