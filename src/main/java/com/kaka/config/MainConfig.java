package com.kaka.config;

import com.kaka.bean.Person;
import com.kaka.condition.WindowsCondition;
import org.springframework.context.annotation.*;

/**
 * @Author yc
 * @Date 2018/9/30 9:05
 */
@Configuration
//value:ָ��Ҫɨ��İ�
@ComponentScan(value="com.kaka")
public class MainConfig {


    //��beanע�뵽����-nameĬ�Ͼ��Ƿ�����
    //��ȻҲ�����Զ��壨bean��name��
    @Bean(name = "person1")
    /*
        ָ�����÷�Χ Ĭ��singleton ---������ioc������������÷����������Ķ������������ ���Խ������������ã�@lazy��
                      prototype ---������ÿ�λ�ȡ��ʱ��ŵ��÷���������
    */

//    @Scope("prototype")
    @Lazy  //������  -��Ե���
    @Conditional({WindowsCondition.class})
    public Person person(){
        return new Person("yc", 18);
    }
}
