package ninja.harmless.vishnu.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
@Aspect
@Component
public class DataServiceLoggingAspect {
    @Pointcut("execution(* ninja.harmless.vishnu.common.data.DataService.*(..))")
    public void pointcut() {}

    @AfterThrowing(pointcut = "pointcut()", throwing = "e")
    public void logAfterExceptionWasThrown(JoinPoint jp, Throwable e) {
        System.out.println("SADIJKASKDJAKSDJASKD");
    }

}
