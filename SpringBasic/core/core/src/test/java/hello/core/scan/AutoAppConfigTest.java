package hello.core.scan;

import hello.core.AppConfig;
import hello.core.AutoAppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService bean = ac.getBean(MemberService.class);
        Assertions.assertThat(bean).isInstanceOf(MemberService.class);

        OrderServiceImpl bean1 = ac.getBean(OrderServiceImpl.class);
        MemberRepository memberRepository = bean1.getMemberRepository();
        System.out.println("memberRepository = " + memberRepository);

    }

    @Test
    void basicScanInfo(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(name);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(name);
                System.out.println("name = " + name + "object = " + bean);
            }

        }
        
        MemberService bean = ac.getBean(MemberService.class);
        Assertions.assertThat(bean).isInstanceOf(MemberService.class);

    }
}
