package aa_web;

import com.cbl.aa.biz.YjBiz;
import com.cbl.aa.entity.Yj;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

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

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext_biz.xml","applicationContext_dao.xml","applicationContext_datasource.xml");
        YjBiz yjBiz= (YjBiz) applicationContext.getBean("yjBiz");
        List<Yj> list=yjBiz.getByOne("city","西昌");
        for (Yj yj : list) {
            System.out.println(yj.toString());
        }
    }

}
