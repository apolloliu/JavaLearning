package bean注入原理学习;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeanFactory {

    private MyBean myBean;
    @Autowired
    BeanFactory(MyBean bean) {
        this.myBean = bean;
    }

    public void printBean() {
        myBean.printBean();
    }
}
