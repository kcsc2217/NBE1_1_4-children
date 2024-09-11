package practice.application.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MemberControllerAspects {


    @Pointcut("within(practice.application.controllers.MemberController)")
    public void MemberControllerPointcut() {
    }


}
