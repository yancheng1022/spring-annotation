一.涉及到的注解

1.@Configuration:指定该类为注解类

2.@ComponentScan(value="com.kaka")：包扫描

3.@Bean(name = "person1")：bean加入容器，没有name时默认方法名

4.@lazy：对于单例bean，采用懒加载，而不是已启动容器就加载bean

5.@Conditional({WindowsCondition.class}):根据条件决定是否要将对象注入

