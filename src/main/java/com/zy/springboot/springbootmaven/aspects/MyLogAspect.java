package com.zy.springboot.springbootmaven.aspects;

import com.zy.springboot.springbootmaven.annotation.MyLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 操作日志记录处理
 * 
 * @author numberone
 */
@Aspect
@Component
public class MyLogAspect
{
    @Pointcut("@annotation(com.zy.springboot.springbootmaven.annotation.MyLog)")
    public void pointcut(){

    }

    /**
     * 通知，用于拦截操作
     * @param joinPoint
     */
    @AfterReturning("pointcut()")
    public void doAfeter(JoinPoint joinPoint){
        handleLog(joinPoint,null);
    }

    /**
     * 拦截异常信息
     * @param joinPoint
     */
    @AfterThrowing(value="pointcut()",throwing ="e")
    public void doAfter(JoinPoint joinPoint,Exception e){
        handleLog(joinPoint,e);
    }

    public  void handleLog(final JoinPoint joinPoint,final Exception e){
        try{
            MyLog log = getAnnotationLog(joinPoint);
            if(log == null){
                return;
            }

            //数据库日志类



            String className = joinPoint.getTarget().getClass().getName();//类名
            String methodName = joinPoint.getSignature().getName();//方法名
            System.out.println("调用了"+className+"."+methodName+"()方法");
            System.out.println("日志参数："+log.businessType()+","+log.title()+","+log.opratorType());

            if(e !=null){
                System.out.println("出异常了"+e.getCause());
            }
            //数据库存储日志数据
            //异步调用

        }catch(Exception exp){
           // System.out.println("异常消息："+exp.getMessage());
        }
    }

    /**
     * 获取方法上的注解
     * @param joinPoint
     * @return
     */
    public MyLog getAnnotationLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature)signature;
        Method method = methodSignature.getMethod();

        if(method !=null){
            return method.getAnnotation(MyLog.class);
        }

        return null;
    }


}
