package hello_spring.hello.service;

import hello_spring.hello.aop.TimeTraceAop;
import hello_spring.hello.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

/*    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }*/

//JPA
//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }
    private final MemberRepository memberRepository;
    @Autowired
    public SpringConfig(MemberRepository memberRepository) {

        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){

        return new MemberService(memberRepository);
    }

/*
    @Bean// AOP bean 등록
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }
*/

/*    @Bean
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        //return new jdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);//Jpa 사용시

    }*/
}
