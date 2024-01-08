package hello_spring.hello.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component//Bean에 등록
@Aspect//공통관심분야로 설정
public class TimeTraceAop {
    @Around("execution(* hello_spring.hello..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("START : "+ joinPoint.toString());
        try{
            return joinPoint.proceed();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END : "+ joinPoint.toString() + " "  + timeMs + "ms");
        }

    }
}
