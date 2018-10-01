一.涉及到的注解

1.@Configuration:指定该类为注解类

2.@ComponentScan(value="com.kaka")：包扫描

3.@Bean(name = "person1")：bean加入容器，没有name时默认方法名
                            还有init-method，destory-method等属性
                            /*初始化方法是在对象创建完成并赋好值，销毁方法是在容器关闭*/
                            
4.@Import({color.class,person.class}):快速给容器中添加bean（组件）

5.@lazy：对于单例bean，采用懒加载，而不是已启动容器就加载bean

6.@Conditional({WindowsCondition.class}):根据条件决定是否要将对象注入

7.@value("kaka"):为属性赋值

8.@PropertySource(value={"classpath:/person.properties"}):读取外部配置文件中的key/value保存到环境变量中，使用${}取出

9.@autowired 1）优先按照类型去容器中找对应的组件 2）如果找到相同类型的多个，再将属性名作为组件id去容器查找

10.@Qualifier("person") 直接指定装配组件的id

11.@Resource java规范中的注解，和autowired一样实现自动装配功能，默认按照组件名称进行装配

12.implement XXXAware 自定义组件使用spring容器底层组件（applicationContext，beanFactory...）

13.@Profile()环境搭建 ：根据当前环境，动态的切换一系列组件的功能 默认使用default
    (1)切换环境时使用命令行参数：-Dspring.profiles.active=test  (2)可以使用java代码的方式：
    ①设置需要激活的环境applicationContext.getEnviroment().setActiveProfiles("test")
    ②注册主配置类：applicationContext.register(ProfileConfig.class)
    ③启动刷新容器：applicationContext.refresh();
    
14.AOP:[动态代理技术]面向切面编程，运行期间动态的将某段代码切入到指定方法指定位置进行运行的编程方式
       1.导入aop模块：（spring-aspects）
       2.定义一个业务逻辑类（calculator），在业务逻辑运行的时候将日志打印（方法前，后）
       3.定义日志切面类（LogAspects）
           通知方法：前置通知（@Before）
                   后置通知（@After）
                   返回通知（@AfterReturning）
                   异常通知（@AfterThrowing）
                   环绕通知（@Around）
       4.给切入类的目标方法标注何时何地运行
       5.将切面类和业务逻辑类都加入到容器中
       6.告诉spring哪个是切面（切面类加注解：@Aspect）
       7.以前xml中<aop:aspectj-autoproxy></aop:aspectj-autoproxy>开启注解版的切面功能
         现在在配置类中加入 @EnableAspectJAutoProxy 开启注解版的切面功能

