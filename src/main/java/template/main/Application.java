package template.main;

import org.springframework.core.io.ClassPathResource;

public class Application {
	private static final String APPLICATION_CONTEXT = "configuration/applicationContext.xml";

	public Application(String[] args) {
	
	}

	public void run() {
		@SuppressWarnings("resource")
		CustomEmbeddedWebApplicationContext context = 
				new CustomEmbeddedWebApplicationContext(new ClassPathResource(APPLICATION_CONTEXT));

		context.refresh();
		context.start();
		
		context.registerShutdownHook();
	}

	public static void run(String[] args) {
		new Application(args).run();
	}
}
