һ.�漰����ע��

1.@Configuration:ָ������Ϊע����

2.@ComponentScan(value="com.kaka")����ɨ��

3.@Bean(name = "person1")��bean����������û��nameʱĬ�Ϸ�����
                            ����init-method��destory-method������
                            /*��ʼ���������ڶ��󴴽���ɲ�����ֵ�����ٷ������������ر�*/
                            
4.@Import({color.class,person.class}):���ٸ����������bean�������

5.@lazy�����ڵ���bean�����������أ������������������ͼ���bean

6.@Conditional({WindowsCondition.class}):�������������Ƿ�Ҫ������ע��

7.@value("kaka"):Ϊ���Ը�ֵ

8.@PropertySource(value={"classpath:/person.properties"}):��ȡ�ⲿ�����ļ��е�key/value���浽���������У�ʹ��${}ȡ��

9.@autowired 1�����Ȱ�������ȥ�������Ҷ�Ӧ����� 2������ҵ���ͬ���͵Ķ�����ٽ���������Ϊ���idȥ��������

10.@Qualifier("person") ֱ��ָ��װ�������id

11.@Resource java�淶�е�ע�⣬��autowiredһ��ʵ���Զ�װ�书�ܣ�Ĭ�ϰ���������ƽ���װ��

12.implement XXXAware �Զ������ʹ��spring�����ײ������applicationContext��beanFactory...��

13.@Profile()����� �����ݵ�ǰ��������̬���л�һϵ������Ĺ��� Ĭ��ʹ��default
    (1)�л�����ʱʹ�������в�����-Dspring.profiles.active=test  (2)����ʹ��java����ķ�ʽ��
    ��������Ҫ����Ļ���applicationContext.getEnviroment().setActiveProfiles("test")
    ��ע���������ࣺapplicationContext.register(ProfileConfig.class)
    ������ˢ��������applicationContext.refresh();
    
    

