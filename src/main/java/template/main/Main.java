package template.main;

public class Main {
	public static void main(String[] args) {
		System.setProperty("environment", "dev");
		System.out.println("Hi, my name is not Bob. What name is your's not?");
		Application.run(args);
	}
}
