import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.SpringInterface;

public class Entry {

    public static void main(String[] args){
        ApplicationContext app = new ClassPathXmlApplicationContext("App.xml");
        app.getBean("Impl", SpringInterface.class).hello();
    }
}
