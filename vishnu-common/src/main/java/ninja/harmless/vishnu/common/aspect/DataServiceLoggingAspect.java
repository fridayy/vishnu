package ninja.harmless.vishnu.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Logging Aspect for all {@link ninja.harmless.vishnu.common.data.DataService} implementations
 *
 * @author bnjm@harmless.ninja - 7/16/17.
 */
@Aspect
@Component
public class DataServiceLoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* ninja.harmless.vishnu.common.data.DataService.*(..))")
    public void pointcut() {}

    @AfterThrowing(pointcut = "pointcut()", throwing = "e")
    public void logAfterExceptionWasThrown(JoinPoint jp, Throwable e) {
        logger.error("{} in {}.{}({}) thrown. Cause: {}. ",
                e.getMessage(), jp.getSignature().getDeclaringTypeName(),
                jp.getSignature().getName(),
                Arrays.toString(jp.getArgs()),
                e.getCause(), e);
    }

}
