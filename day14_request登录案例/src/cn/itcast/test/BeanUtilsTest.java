package cn.itcast.test;

import cn.itcast.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class BeanUtilsTest {

    @Test
    public void getProperty01(){
        User user=new User();
        try {
            BeanUtils.setProperty(user,"username","zhangsan");
            String username = BeanUtils.getProperty(user, "username");
            System.out.println(user);
            System.out.println(username);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
