import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	 public static void main(String[] args) throws IOException, InterruptedException {
	        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	        ctx.start();
	        System.out.println("started");
	        System.in.read();
	        
	    }
}
