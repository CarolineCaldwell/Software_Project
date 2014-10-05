package template.main;

public class Main {
	public static void main(String[] args) {
		System.setProperty("environment", "dev");
		System.out.println("Test1");
		System.out.println("Test2");
		System.out.println("Test3");
		System.out.println("Test4");
		System.out.println("Test5");
		System.out.println("Test6");
		System.out.println("Test7");
		Application.run(args);
	}
}
