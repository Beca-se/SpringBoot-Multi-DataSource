package com.stee.mobility.platform.services.atms.dms.message.aop;

import com.stee.mobility.platform.services.atms.dms.message.holder.DataSourceHolder;
import com.stee.mobility.platform.services.atms.dms.message.intf.DataSourceChoose;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * @author Administrator
 * @Class Name DataSourceAspect
 * @Desc 自定义切面, 切换数据源
 * @create: 2021-01-18 10:41
 **/
@Aspect
@Configuration
public class DataSourceAspect {

    /**
     * 定义一个切入点
     */
    @Pointcut("@annotation(com.stee.mobility.platform.services.atms.dms.message.intf.DataSourceChoose)")
    private void dataSourceAspect() {
    }

    @Before("dataSourceAspect()")
    public void changeDataSource(JoinPoint point) throws Throwable {
        DataSourceChoose datasource = getDataSourceChooseAnno(point);
        String sourceName = datasource.value();
        // 通过aop拦截，获取注解上面的value的值key，然后取判断我们注册的keys集合中是否有这个key,如果没有，则使用默认数据源，如果有，则设置上下文中当前数据源的key为注解的value。
        DataSourceHolder.setDataSource(sourceName);
    }

    @After("dataSourceAspect()")
    public void clearDataSource() {
        DataSourceHolder.clearDataSource();
    }

    private DataSourceChoose getDataSourceChooseAnno(JoinPoint point) throws NoSuchMethodException {
        //获取当前的指定的数据源;
        Signature signature = point.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Object target = point.getTarget();
        Method currentMethod = target.getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
        return currentMethod.getAnnotation(DataSourceChoose.class);
    }
}
