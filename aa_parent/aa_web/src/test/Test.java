import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName Test
 * @Description TODO
 * @Author chenbilang
 * @Date 2019/4/30
 * @Version 1.0
 */
public class Test {

    @org.junit.Test
    public void test(){

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicatonContext_action.xml");

    }

}
